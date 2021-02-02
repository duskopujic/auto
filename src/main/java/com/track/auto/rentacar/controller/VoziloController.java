package com.track.auto.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.auto.rentacar.model.Proizvodjac;
import com.track.auto.rentacar.model.Vozilo;
import com.track.auto.rentacar.payload.VoziloRequest;
import com.track.auto.rentacar.payload.VoziloResponse;
import com.track.auto.rentacar.repository.ProizvodjacRepository;
import com.track.auto.rentacar.repository.VoziloRepository;

@RestController
@RequestMapping("/vozilo")
public class VoziloController {

	@Autowired
	private VoziloRepository voziloRepository;
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;

	@GetMapping("/svi")
	public List<Vozilo> getAll() {
		return voziloRepository.findAll();
	}

	// primjer konvertovanja liste i vracanja uredjenog prikaza
	@GetMapping("/{godiste}")
	public List<VoziloResponse> getByGodiste(@PathVariable("godiste") Integer godiste) {
		List<Vozilo> listVozilo = voziloRepository.findAllByGodiste(godiste);
		// dohvatimo listu vozila po prosljedjenom godistu
		// nakon toga tu listu Vozila knvertujemo u listu VoziloResponse
		return listVozilo.stream().map(e->convertToVoziloResponse(e)).collect(Collectors.toList());
	}

	@PostMapping("/dodaj")
	public VoziloResponse addVozilo(@RequestBody VoziloRequest requestValue) {

		Vozilo vozilo = new Vozilo();

		vozilo.setModel(requestValue.getModel());
		vozilo.setGodiste(requestValue.getGodiste());
		vozilo.setSnaga(requestValue.getSnaga());
		vozilo.setGorivo(requestValue.getGorivo());
		Proizvodjac proizvodjac = proizvodjacRepository.getOne(requestValue.getProizvodjacId());
		vozilo.setProizvodjac(proizvodjac);
		vozilo.setCijena(requestValue.getCijena());
		vozilo.setRegistracija(requestValue.getRegistracija());

		vozilo = voziloRepository.save(vozilo);
		return convertToVoziloResponse(vozilo);
	}
	
	
	private VoziloResponse convertToVoziloResponse(Vozilo vozilo) {
		
		VoziloResponse response = new VoziloResponse();
		
		response.setModel(vozilo.getModel());
		response.setGodiste(vozilo.getGodiste());
		response.setTipGoriva(vozilo.getGorivo());
		response.setProizvodjacNaziv(vozilo.getProizvodjac().getNaziv());
		response.setCijena(vozilo.getCijena());
		response.setRegistracija(vozilo.getRegistracija());
		
		return response;
	}
}
