package com.track.auto.rentacar.payload;

import java.math.BigDecimal;

public class VoziloRequest {

	private String model;
	private int godiste;
	private int snaga;
	private String gorivo;
	private long proizvodjacId;
	private BigDecimal cijena;
	private String registracija;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public int getSnaga() {
		return snaga;
	}

	public void setSnaga(int snaga) {
		this.snaga = snaga;
	}

	public String getGorivo() {
		return gorivo;
	}

	public void setGorivo(String gorivo) {
		this.gorivo = gorivo;
	}

	public long getProizvodjacId() {
		return proizvodjacId;
	}

	public void setProizvodjacId(long proizvodjacId) {
		this.proizvodjacId = proizvodjacId;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

}
