package com.hotel.va3.HotelProjeto.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.va3.HotelProjeto.exceptions.ReservaSalvarException;
import com.hotel.va3.HotelProjeto.model.domain.Reserva;
import com.hotel.va3.HotelProjeto.model.repository.ReservaRepository;
import com.hotel.va3.HotelProjeto.model.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public Reserva salvar(Reserva reserva) throws ReservaSalvarException {
		return reservaRepository.save(reserva);
	}

	@Override
	public List<Reserva> listar() {
		return reservaRepository.findAll();
	}

	@Override
	public void deletar(Reserva reserva) {
		reservaRepository.delete(reserva);
	}

}
