package com.track.auto.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.auto.rentacar.model.Racun;

public interface RacunRepository extends JpaRepository<Racun, Long> {

	List<Racun> findAllByOrderByRacunId();

}
