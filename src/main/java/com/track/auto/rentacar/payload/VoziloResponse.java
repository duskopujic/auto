package com.track.auto.rentacar.payload;

import java.math.BigDecimal;

public class VoziloResponse {

	private String model;
	private int godiste;
	private int snaga;
	private String tipGoriva;
	private String proizvodjacNaziv;
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

	public String getTipGoriva() {
		return tipGoriva;
	}

	public void setTipGoriva(String tipGoriva) {
		this.tipGoriva = tipGoriva;
	}

	public String getProizvodjacNaziv() {
		return proizvodjacNaziv;
	}

	public void setProizvodjacNaziv(String proizvodjacNaziv) {
		this.proizvodjacNaziv = proizvodjacNaziv;
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
