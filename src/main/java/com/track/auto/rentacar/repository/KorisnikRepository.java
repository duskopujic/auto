package com.track.auto.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.auto.rentacar.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	List<Korisnik> findAllByOrderByKorisnikId();
	
	List<Korisnik>  findAllByImeIgnoreCaseOrPrezimeIgnoreCase(String ime, String prezime);
	
}
