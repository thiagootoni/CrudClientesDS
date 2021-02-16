package com.thiago.clientes.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thiago.clientes.dto.ClientDto;
import com.thiago.clientes.entities.Client;
import com.thiago.clientes.repositories.ClientRepository;
import com.thiago.clientes.services.exceptions.DataBaseException;
import com.thiago.clientes.services.exceptions.ElementNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDto> findAllPaginated(PageRequest pageRequest) {
		
		Page<Client> pageEntity = this.repository.findAll(pageRequest);
		
		Page<ClientDto> pageDto = pageEntity.map(x -> new ClientDto(x));
		
		return pageDto;
		
	}

	@Transactional(readOnly = true)
	public ClientDto findOne(Long id) {
		
		Client client = this.repository.findById(id)
				.orElseThrow(() -> new ElementNotFoundException("Elemento não econtrado"));
		
		return new ClientDto(client);
	}

	@Transactional
	public ClientDto insertOne(ClientDto dto) {
		
		Client client = new Client(dto);
		client = this.repository.save(client);
		
		return new ClientDto(client);
		
	}

	@Transactional
	public ClientDto updateOne(ClientDto dto, Long id) {
		
		try {
			
			Client client = this.repository.getOne(id);
	
			client.setName(dto.getName());
			client.setChildren(dto.getChildren());
			client.setBirthDate(dto.getBirthDate());
			client.setCpf(dto.getCpf());
			client.setIncome(dto.getIncome());
			
			client = this.repository.save(client);
			return new ClientDto(client);
			
		} catch (EntityNotFoundException e) {
			throw new ElementNotFoundException("Elemento não encontrado");
		}
	}

	public void deleteOne(Long id) {
		
		try {
			this.repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ElementNotFoundException("Elemento não encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integridade de BD violada");
		}
	}
}
