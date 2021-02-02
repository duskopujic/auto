package com.track.auto.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.auto.rentacar.model.Proizvodjac;

public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, Long> {

	List<Proizvodjac> findAllByOrderByProizvodjacId();

}
