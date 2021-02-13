package com.thiago.clientes.resources;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.clientes.dto.ClientDto;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<Page<ClientDto>> findAllPaginated(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		return null;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> findOne(@PathVariable Long id){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<ClientDto> insertOne(@RequestBody ClientDto dto){
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDto> udpateOne(@RequestBody ClientDto dto, @PathVariable Long id){
		return null;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDto> deleteOne(@PathVariable Long id){
		return null;
	}
	
}
