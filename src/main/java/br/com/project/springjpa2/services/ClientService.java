package br.com.project.springjpa2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springjpa2.models.Client;
import br.com.project.springjpa2.repositories.ClientRepository;
import br.com.project.springjpa2.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> clientById = clientRepository.findById(id);
        return clientById.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
    }
}
