package com.track.auto.rentacar.payload;

import java.math.BigDecimal;
import java.time.LocalDate;


public class RacunResponse {

	private int brojDana;
	private BigDecimal cijena;
	private LocalDate datumOd;
	private LocalDate datumDo;
	private BigDecimal iznos;
	private BigDecimal pdv;
	private String ime;
	private String prezime;
	private String proizvodjac;
	private String model;
	private BigDecimal ukupno;
	public int getBrojDana() {
		return brojDana;
	}
	public void setBrojDana(int brojDana) {
		this.brojDana = brojDana;
	}
	public BigDecimal getCijena() {
		return cijena;
	}
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	public LocalDate getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(LocalDate datumOd) {
		this.datumOd = datumOd;
	}
	public LocalDate getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(LocalDate datumDo) {
		this.datumDo = datumDo;
	}
	public BigDecimal getIznos() {
		return iznos;
	}
	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}
	public BigDecimal getPdv() {
		return pdv;
	}
	public void setPdv(BigDecimal pdv) {
		this.pdv = pdv;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public BigDecimal getUkupno() {
		return ukupno;
	}
	public void setUkupno(BigDecimal ukupno) {
		this.ukupno = ukupno;
	}
	

}
