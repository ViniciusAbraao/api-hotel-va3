package com.hotel.va3.HotelProjeto.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.va3.HotelProjeto.exceptions.HospedeSalvarException;
import com.hotel.va3.HotelProjeto.model.domain.Hospede;
import com.hotel.va3.HotelProjeto.model.repository.HospedeRepository;
import com.hotel.va3.HotelProjeto.model.service.HospedeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HospedeServiceImpl implements HospedeService {

	@Autowired
	private HospedeRepository hospedeRepository;

	@Override
	public Hospede salvar(Hospede hospede) throws HospedeSalvarException {
		return hospedeRepository.save(hospede);
	}

	@Override
	public List<Hospede> listar() {
		return hospedeRepository.findAll();
	}

	@Override
	public void deletar(Long id) {
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		if (hospede.isPresent()) {
			hospedeRepository.delete(hospede.get());
		} else {
			throw new EntityNotFoundException("Hóspede com ID " + id + " não encontrado.");
		}

	}

}
