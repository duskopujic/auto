package com.track.auto.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.track.auto.rentacar.model.Korisnik;
import com.track.auto.rentacar.repository.KorisnikRepository;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

	@Autowired
	private KorisnikRepository korisnikRepository;

	/** vraca listu svih krisnika */
	@GetMapping("/svi")
	public List<Korisnik> getAll() {
		return korisnikRepository.findAll();
	}

	/*
	 * vraca listu korisnika prema prosljedjenom parametru - prema prosljedjenom
	 * stringu - ime ili prezime
	 */
	@GetMapping("/{value}")
	public List<Korisnik> getByIme(@PathVariable("value") String value) {
		return korisnikRepository.findAllByImeIgnoreCaseOrPrezimeIgnoreCase(value, value);
	}

	@PostMapping("/dodaj")
	public Korisnik addKorisnik(@RequestBody Korisnik novi) {
		
		Korisnik korisnik = new Korisnik();
		
		korisnik.setIme(novi.getIme());
		korisnik.setPrezime(novi.getPrezime());
		korisnik.setAdresa(novi.getAdresa());
		korisnik.setTelefon(novi.getTelefon());

		return korisnikRepository.save(korisnik);
	}

	/*  http://localhost:8080/korisnik/izmjeni/5
	 
	  {
	    "ime":"Duško",
	    "prezime":"Pujić- Pujica",
	    "telefon":"065330989",
	    "adresa":""
	  }
	 * */
	@PutMapping("/izmjeni/{korisnikId}")
	public Korisnik editKorisnik(@PathVariable("korisnikId") Long korisnikId, @RequestBody Korisnik value) {
		
		Korisnik korisnik = korisnikRepository.getOne(korisnikId);
		
		korisnik.setIme(value.getIme());
		korisnik.setPrezime(value.getPrezime());
		korisnik.setAdresa(value.getAdresa());
		korisnik.setTelefon(value.getTelefon());
		
		return korisnikRepository.save(korisnik);
	}
	
	/*http://localhost:8080/korisnik/izmjeni?id=5&adresa=Nikole Tesle&telefon=065065065*/
	@PutMapping("/izmjeni")
	public Korisnik editAdressAndPhone(@RequestParam Long id, @RequestParam String adresa, @RequestParam Long telefon) {
		
		Korisnik korisnik = korisnikRepository.getOne(id);
		korisnik.setAdresa(adresa);
		korisnik.setTelefon(telefon);
		
		return korisnikRepository.save(korisnik);
	}
}
