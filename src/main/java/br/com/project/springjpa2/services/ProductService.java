package br.com.project.springjpa2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springjpa2.models.Product;
import br.com.project.springjpa2.repositories.ProductRepository;
import br.com.project.springjpa2.services.exceptions.EntityNotFoundException;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> productById = productRepository.findById(id);
        return productById.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
    }
}
