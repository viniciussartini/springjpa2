package br.com.project.springjpa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.springjpa2.models.City;
import br.com.project.springjpa2.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> findAll() {
        List<City> cityList = cityService.findAll();
        return ResponseEntity.ok().body(cityList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        City cityById = cityService.findById(id);
        return ResponseEntity.ok().body(cityById);
    }
}
