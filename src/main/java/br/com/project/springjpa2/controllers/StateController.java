package br.com.project.springjpa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.springjpa2.models.State;
import br.com.project.springjpa2.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<State>> findAll() {
        List<State> stateList = stateService.findAll();
        return ResponseEntity.ok().body(stateList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        State stateById = stateService.findById(id);
        return ResponseEntity.ok().body(stateById);
    }
}
