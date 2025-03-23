package br.com.project.springjpa2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.springjpa2.models.State;

public interface StateRepository extends JpaRepository<State, Long>{
}
