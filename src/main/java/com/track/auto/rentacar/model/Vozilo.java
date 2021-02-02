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
@Table(name = "vozilo", schema = "renta_car")
public class Vozilo {

	@Id
	@Column(name = "vozilo_id")
	@SequenceGenerator(name = "VoziloGenerator", sequenceName = "vozilo_seq", schema = "renta_car", allocationSize = 1)
	@GeneratedValue(generator = "VoziloGenerator")
	private long voziloId;

	private String model;
	private int godiste;
	private int snaga;
	private String gorivo;
	@ManyToOne
	@JoinColumn(name = "proizvodjac_id")
	private Proizvodjac proizvodjac;
	private BigDecimal cijena;
	private String registracija;

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public long getVoziloId() {
		return voziloId;
	}

	public void setVoziloId(long voziloId) {
		this.voziloId = voziloId;
	}

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
