package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Carreras")
public class Carrera {

	@Id
	private int codigocar;
	
	private String carrera;

	@Override
	public String toString() {
		return "Carrera [codigocar=" + codigocar + ", carrera=" + carrera + "]";
	}

	public int getCodigocar() {
		return codigocar;
	}

	public void setCodigocar(int codigocar) {
		this.codigocar = codigocar;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
}
