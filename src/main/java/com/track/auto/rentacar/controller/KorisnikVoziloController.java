package com.track.auto.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.auto.rentacar.model.KorisnikVozilo;
import com.track.auto.rentacar.repository.KorisnikVoziloRepository;

@RestController
@RequestMapping("/korisnik_vozilo")

public class KorisnikVoziloController {

	@Autowired
	private KorisnikVoziloRepository korisnikVoziloRepository;

	@GetMapping("/svi")
	public List<KorisnikVozilo> getAll() {
		return korisnikVoziloRepository.findAll();
	}

	
	// vratiti response 
	@GetMapping("/{id}")
	public KorisnikVozilo getOne(@PathVariable("id") Long korisnikVoziloId) {
		KorisnikVozilo korisnikVozilo = korisnikVoziloRepository.getOne(korisnikVoziloId);
		return korisnikVozilo;
	}
	
	// insert -post
	// korisnik, vozilo, datumOd
	
	
	// update - put
	// datumDo
}
