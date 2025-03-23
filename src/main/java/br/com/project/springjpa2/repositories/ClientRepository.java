package br.com.project.springjpa2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.springjpa2.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
