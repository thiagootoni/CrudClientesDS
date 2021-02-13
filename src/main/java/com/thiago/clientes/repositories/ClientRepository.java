package com.thiago.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiago.clientes.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
