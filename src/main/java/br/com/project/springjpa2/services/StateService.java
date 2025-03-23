package br.com.project.springjpa2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springjpa2.models.State;
import br.com.project.springjpa2.repositories.StateRepository;
import br.com.project.springjpa2.services.exceptions.EntityNotFoundException;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public State findById(Long id) {
        Optional<State> stateById = stateRepository.findById(id);
        return stateById.orElseThrow(() -> new EntityNotFoundException("Estado não encontrado."));
    }
}
