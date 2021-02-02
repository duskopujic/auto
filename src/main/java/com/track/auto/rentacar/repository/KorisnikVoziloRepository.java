package com.track.auto.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.auto.rentacar.model.KorisnikVozilo;

public interface KorisnikVoziloRepository extends JpaRepository<KorisnikVozilo, Long>{
	
	List <KorisnikVozilo> findAllByOrderByKorisnikVoziloId();

}
