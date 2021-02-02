package com.track.auto.rentacar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "korisnik", schema = "renta_car")
public class Korisnik {
	
	@Id
	@Column(name="korisnik_id")
	@SequenceGenerator(name = "KorisnikGenerator", sequenceName = "korisnik_seq", schema = "renta_car", allocationSize = 1)
	@GeneratedValue(generator = "KorisnikGenerator")
	private long korisnikId;

	private String ime;
	private String prezime;
	private Long telefon;
	private String adresa;
	
	public long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(long korisnikId) {
		this.korisnikId = korisnikId;
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
	public long getTelefon() {
		return telefon;
	}
	public void setTelefon(long telefon) {
		this.telefon = telefon;
	} 
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
}
