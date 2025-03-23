package br.com.project.springjpa2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springjpa2.models.City;
import br.com.project.springjpa2.repositories.CityRepository;
import br.com.project.springjpa2.services.exceptions.EntityNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        Optional<City> cityById = cityRepository.findById(id);
        return cityById.orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada."));
    }
}
