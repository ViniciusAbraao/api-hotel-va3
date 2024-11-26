package com.hotel.va3.HotelProjeto.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.va3.HotelProjeto.model.domain.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long>{
	Optional<Hospede> findById(Long id);
}
