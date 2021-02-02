package com.track.auto.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.track.auto.rentacar.model.Proizvodjac;
import com.track.auto.rentacar.repository.ProizvodjacRepository;

@RestController
@RequestMapping("/proizvodjac")
public class ProizvodjacController {

	@Autowired
	private ProizvodjacRepository proizvodjacRepository;

	@GetMapping("/svi")
	public List<Proizvodjac> getAll() {
		return proizvodjacRepository.findAll();
	}

	@PostMapping("/dodaj")
	public Proizvodjac addProizvodjac(@RequestBody Proizvodjac novi) throws Exception {

		if (novi.getNaziv() == null || novi.getNaziv() == "") {
			throw new Exception("Morate unijeti naziv proizvodjaca");
		}

		Proizvodjac proizvodjac = new Proizvodjac();

		proizvodjac.setNaziv(novi.getNaziv());

		return proizvodjacRepository.save(proizvodjac);
	}

	/* Brisanje kolone */
	@DeleteMapping("/obrisi/{id}")
	public void obrisiProizvodjaca(@PathVariable("id") long proizvodjacId) {
		proizvodjacRepository.deleteById(proizvodjacId);		
	}

	@PutMapping("/izmjeni/{proizvodjacId}")
	public Proizvodjac editProizvodjac(@PathVariable("proizvodjacId") Long proizvodjacId, @RequestParam String naziv) {
		Proizvodjac proizvodjac = proizvodjacRepository.getOne(proizvodjacId);
		proizvodjac.setNaziv(naziv);
		return proizvodjacRepository.save(proizvodjac);
	}
}
