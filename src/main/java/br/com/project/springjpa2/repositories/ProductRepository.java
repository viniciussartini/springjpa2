package br.com.project.springjpa2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.springjpa2.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
