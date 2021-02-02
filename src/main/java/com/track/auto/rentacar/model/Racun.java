package com.track.auto.rentacar.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "racun", schema = "renta_car")
public class Racun {

	@Id
	@Column(name = "racun_id")
	@SequenceGenerator(name = "RacunGenerator", sequenceName = "racun_seq", schema = "renta_car", allocationSize = 1)
	@GeneratedValue(generator = "RacunGenerator")
	private long racunId;
	
	private int brojDana;
	private BigDecimal cijena;
	private BigDecimal iznos;

	@ManyToOne
	@JoinColumn(name = "korisnik_vozilo_id")
	private KorisnikVozilo korisnikVozilo;

	private BigDecimal pdv;
	private BigDecimal ukupno;

	public long getRacunId() {
		return racunId;
	}

	public void setRacunId(long racunId) {
		this.racunId = racunId;
	}

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

	public BigDecimal getIznos() {
		return iznos;
	}

	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}

	public KorisnikVozilo getKorisnikVozilo() {
		return korisnikVozilo;
	}

	public void setKorisnikVozilo(KorisnikVozilo korisnikVozilo) {
		this.korisnikVozilo = korisnikVozilo;
	}

	public BigDecimal getPdv() {
		return pdv;
	}

	public void setPdv(BigDecimal pdv) {
		this.pdv = pdv;
	}

	public BigDecimal getUkupno() {
		return ukupno;
	}

	public void setUkupno(BigDecimal ukupno) {
		this.ukupno = ukupno;
	}

}
