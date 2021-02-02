package com.track.auto.rentacar.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.auto.rentacar.model.KorisnikVozilo;
import com.track.auto.rentacar.model.Racun;
import com.track.auto.rentacar.payload.RacunResponse;
import com.track.auto.rentacar.repository.KorisnikVoziloRepository;
import com.track.auto.rentacar.repository.RacunRepository;

@RestController
@RequestMapping("/racun")
public class RacunController {

	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private KorisnikVoziloRepository korisnikVoziloRepository;
	
	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

	NumberFormat numberFormat = new DecimalFormat("#,##0.00");


	@GetMapping("/svi")
	public List<RacunResponse> getAll() {
		return racunRepository.findAll().stream().map(e->convertToRacunResponse(e)).collect(Collectors.toList());
	}

	@PostMapping("/dodaj/{id}")
	private RacunResponse addRacun(@PathVariable("id") Long korisnikVoziloId) {
		KorisnikVozilo korisnikVozilo = korisnikVoziloRepository.getOne(korisnikVoziloId);

		Racun racun = new Racun();
		
		racun.setKorisnikVozilo(korisnikVozilo);
		racun.setBrojDana(Period.between(korisnikVozilo.getDatumOd(), korisnikVozilo.getDatumDo()).getDays());
		racun.setCijena(korisnikVozilo.getVozilo().getCijena());
		
		racun.setIznos(racun.getCijena().multiply(new BigDecimal(racun.getBrojDana())));
		racun.setPdv(racun.getIznos().multiply(new BigDecimal(0.17)));
		racun.setUkupno(racun.getIznos().add(racun.getPdv()));

		racun = racunRepository.save(racun);
		return convertToRacunResponse(racun);
	}
	
	private RacunResponse convertToRacunResponse(Racun racun) {
		
		RacunResponse response = new RacunResponse();
		
		response.setBrojDana(racun.getBrojDana());
		response.setCijena(racun.getCijena());
		response.setDatumOd(racun.getKorisnikVozilo().getDatumOd());
		response.setDatumDo(racun.getKorisnikVozilo().getDatumDo());
		response.setIznos(new BigDecimal(decimalFormat.format(racun.getIznos())));
		response.setPdv(new BigDecimal(decimalFormat.format(racun.getPdv())));
		response.setIme(racun.getKorisnikVozilo().getKorisnik().getIme());
		response.setPrezime(racun.getKorisnikVozilo().getKorisnik().getPrezime());
		response.setProizvodjac(racun.getKorisnikVozilo().getVozilo().getProizvodjac().getNaziv());
		response.setModel(racun.getKorisnikVozilo().getVozilo().getModel());
		response.setUkupno(new BigDecimal(decimalFormat.format(racun.getUkupno())));
		
		return response;
		
	}
	
}
