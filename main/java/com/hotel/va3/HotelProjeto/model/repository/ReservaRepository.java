package com.hotel.va3.HotelProjeto.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.va3.HotelProjeto.model.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
