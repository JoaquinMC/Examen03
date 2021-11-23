package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alumno")
public class Alumno {
	
	@Id
	private int codigoalu;
	
	private String nombre;
	
	private int codigocar;

	private int dni;

	private String email;
	

	
	@Override
	public String toString() {
		return "Alumno [codigoalu=" + codigoalu + ", nombre=" + nombre + ", codigocar=" + codigocar + ", dni=" + dni
				+ ", email=" + email + "]";
	}

	public int getCodigoalu() {
		return codigoalu;
	}

	public void setCodigoalu(int codigoalu) {
		this.codigoalu = codigoalu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigocar() {
		return codigocar;
	}

	public void setCodigocar(int codigocar) {
		this.codigocar = codigocar;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
