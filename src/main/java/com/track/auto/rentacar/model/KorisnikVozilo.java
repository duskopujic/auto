package com.track.auto.rentacar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "korisnik_vozilo", schema = "renta_car")
public class KorisnikVozilo {
	
	@Id
	private long korisnikVoziloId;
	
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private Korisnik korisnik;
	@ManyToOne
	@JoinColumn(name="vozilo_id")
	private Vozilo vozilo;
	
	private LocalDate datumOd;
	private LocalDate datumDo;
	
	public long getKorisnikVoziloId() {
		return korisnikVoziloId;
	}
	public void setKorisnikVoziloId(long korisnikVoziloId) {
		this.korisnikVoziloId = korisnikVoziloId;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Vozilo getVozilo() {
		return vozilo;
	}
	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
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
	
	
	

}
