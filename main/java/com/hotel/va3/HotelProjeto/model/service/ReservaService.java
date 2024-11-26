package com.hotel.va3.HotelProjeto.model.service;

import java.util.List;

import com.hotel.va3.HotelProjeto.exceptions.ReservaSalvarException;
import com.hotel.va3.HotelProjeto.model.domain.Reserva;

public interface ReservaService {
	Reserva salvar(Reserva reserva) throws ReservaSalvarException;
	void deletar(Reserva reserva);
	List<Reserva>listar();
}
