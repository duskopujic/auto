package com.track.auto.rentacar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "proizvodjac", schema = "renta_car")

public class Proizvodjac {	
	
	@Id
	@SequenceGenerator(name = "ProizvodjacGenerator", sequenceName = "proizvodjac_seq", schema = "renta_car", allocationSize = 1)
	@GeneratedValue(generator = "ProizvodjacGenerator")
	private long proizvodjacId;
	
	private String naziv;
	
	public long getProizvodjacId() {
		return proizvodjacId;
	}
	public void setProizvodjacId(long proizvodjacId) {
		this.proizvodjacId=proizvodjacId;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv=naziv;
	}
}
