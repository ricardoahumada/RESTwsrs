package com.netmind.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid; 
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "propietario")
	private int propietario;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=Tarea.class,fetch=FetchType.EAGER)
	@JoinColumn(name="proyecto")
	private List<Tarea> tareas;
	
	public Proyecto() {}
	
	public Proyecto(int pid, String titulo, List<Tarea> tareas) {
		super();
		this.pid = pid;
		this.titulo = titulo;
		this.tareas = tareas;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public int getPropietario() {
		return propietario;
	}

	public void setPropietario(int propietario) {
		this.propietario = propietario;
	}
	
	
}
