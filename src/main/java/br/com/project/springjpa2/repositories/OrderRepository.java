package br.com.project.springjpa2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.springjpa2.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
