package com.track.auto.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.auto.rentacar.model.Vozilo;

public interface VoziloRepository extends JpaRepository<Vozilo, Long> {

	List<Vozilo> findAllByOrderByVoziloId();

	List<Vozilo> findAllByGodiste(Integer godiste);
}
