package br.com.project.springjpa2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springjpa2.models.Order;
import br.com.project.springjpa2.repositories.OrderRepository;
import br.com.project.springjpa2.services.exceptions.EntityNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> orderById = orderRepository.findById(id);
        return orderById.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }
}
