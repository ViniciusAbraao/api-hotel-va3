package com.hotel.va3.HotelProjeto.model.service;

import java.util.List;
import java.util.Optional;

import com.hotel.va3.HotelProjeto.exceptions.HospedeSalvarException;
import com.hotel.va3.HotelProjeto.model.domain.Hospede;

public interface HospedeService {
			
	Hospede salvar(Hospede hospede) throws HospedeSalvarException;
	List<Hospede> listar();
	void deletar(Long id);
}
