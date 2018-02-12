package com.netmind.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tarea")
public class Tarea implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="estimado")
	private int estimado;
	@Column(name="dedicado")
	private int dedicado;
	@Column(name="restante")
	private int restante;
	@Column(name="estado")
	private int estado;
	@Transient
	private Usuario responsable;
	
	public Tarea() {}
	
	public Tarea(int tid,String desc, int estimado, int dedicado, int restante, int estado, Usuario responsable) {
		this.tid = tid;
		this.descripcion=desc;
		this.estimado = estimado;
		this.dedicado = dedicado;
		this.restante = restante;
		this.estado = estado;
		this.responsable = responsable;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstimado() {
		return estimado;
	}
	public void setEstimado(int estimado) {
		this.estimado = estimado;
	}
	public int getDedicado() {
		return dedicado;
	}
	public void setDedicado(int dedicado) {
		this.dedicado = dedicado;
	}
	public int getRestante() {
		return restante;
	}
	public void setRestante(int restante) {
		this.restante = restante;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Usuario getResponsable() {
		return responsable;
	}
	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
}
