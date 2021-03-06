package com.thiago.clientes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thiago.clientes.dto.ClientDto;
import com.thiago.clientes.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<ClientDto>> findAllPaginated(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<ClientDto> pages = this.service.findAllPaginated(pageRequest);
		
		return ResponseEntity.ok(pages);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> findOne(@PathVariable Long id){
		
		return ResponseEntity.ok().body(this.service.findOne(id));
		
	}
	
	@PostMapping
	public ResponseEntity<ClientDto> insertOne(@RequestBody ClientDto dto){

		ClientDto clientDto = this.service.insertOne(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(clientDto);	
		
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDto> udpateOne(@RequestBody ClientDto dto, @PathVariable Long id){
		
		ClientDto clientDto = this.service.updateOne(dto, id);
		
		return ResponseEntity.ok(clientDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDto> deleteOne(@PathVariable Long id){
		
		this.service.deleteOne(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
}
