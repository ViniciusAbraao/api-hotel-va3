package com.hotel.va3.HotelProjeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.va3.HotelProjeto.exceptions.HospedeSalvarException;
import com.hotel.va3.HotelProjeto.model.domain.Hospede;
import com.hotel.va3.HotelProjeto.model.repository.HospedeRepository;
import com.hotel.va3.HotelProjeto.model.service.HospedeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

	@Autowired
	private HospedeService hospedeService;

	@Autowired
	private HospedeRepository hospedeRepository;

	@PostMapping
	public Hospede salvar(@Valid @RequestBody Hospede hospede) throws HospedeSalvarException {
		return hospedeService.salvar(hospede);
	}

	@GetMapping
	public List<Hospede> listar() {
		return hospedeService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hospede> buscarPorId(@PathVariable("id") Long id) {
		var hosp = hospedeRepository.findById(id);
		if (!hosp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(hosp.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity editar(@PathVariable Long id, @Valid @RequestBody Hospede novoHospede) {
		var hosp = hospedeRepository.findById(id);
		if (!hosp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		novoHospede.setId(id);
		Hospede hospede = hospedeRepository.save(novoHospede);
		return ResponseEntity.ok(hospede);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		hospedeService.deletar(id);
		return ResponseEntity.ok("Hóspede deletado com sucesso");
	}

}
