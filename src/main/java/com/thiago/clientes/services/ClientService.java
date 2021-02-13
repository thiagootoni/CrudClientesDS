package com.thiago.clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thiago.clientes.dto.ClientDto;
import com.thiago.clientes.entities.Client;
import com.thiago.clientes.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	public Page<ClientDto> findAllPaginated(PageRequest pageRequest) {
		
		Page<Client> pageEntity = this.repository.findAll(pageRequest);
		
		Page<ClientDto> pageDto = pageEntity.map(x -> new ClientDto(x));
		
		return pageDto;
		
	}

}
