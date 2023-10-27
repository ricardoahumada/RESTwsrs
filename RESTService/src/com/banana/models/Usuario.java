package com.banana.models;

import java.io.Serializable;

public class Usuario implements Serializable{
	public long uid;
	public String nombre;
	public String apellido;
	public String email;
	public String password;

	public Usuario() {}
	
	public Usuario(int uid, String nombre, String apellido, String email, String password) {
		this.uid = uid;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	
	public long getUid() {
		return uid;
	}

	public void setUid(long l) {
		this.uid = l;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
