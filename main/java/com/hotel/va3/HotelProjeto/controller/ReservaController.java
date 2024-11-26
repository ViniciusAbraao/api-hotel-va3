package com.hotel.va3.HotelProjeto.controller;

import java.util.List;

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

import com.hotel.va3.HotelProjeto.exceptions.ReservaSalvarException;

import com.hotel.va3.HotelProjeto.model.domain.Reserva;
import com.hotel.va3.HotelProjeto.model.repository.ReservaRepository;

import com.hotel.va3.HotelProjeto.model.service.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@Autowired
	private ReservaRepository reservaRepository;

	@PostMapping
	public Reserva salvar(@Valid @RequestBody Reserva reserva) throws ReservaSalvarException {
		return reservaService.salvar(reserva);
	}

	@GetMapping
	public List<Reserva> listar() {
		return reservaService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reserva> buscarPorId(@PathVariable("id") Long id) {
		var reserv = reservaRepository.findById(id);
		if (!reserv.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(reserv.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity editar(@PathVariable Long id, @Valid @RequestBody Reserva novaReserva) {
		var reserv = reservaRepository.findById(id);
		if (!reserv.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		novaReserva.setId(id);
		Reserva reserva = reservaRepository.save(novaReserva);
		return ResponseEntity.ok(reserva);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(Reserva reserva) {
		reservaService.deletar(reserva);
		return ResponseEntity.ok("Deletado");
	}

}
