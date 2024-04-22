package com.example.testapi.controllers;

import com.example.testapi.model.Candidat;
import com.example.testapi.repository.CandidatRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/candidat")
public class CandidatController {
    private final CandidatRepository candidatRepository;

    public CandidatController(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    //hello world

    @GetMapping("/hello")
    public String hello() {
        return "hello world !";
    }

    //getAll
    @GetMapping("/all")
    public ResponseEntity<List<Candidat>> getAllCandidat() {
        return ResponseEntity.ok(
                candidatRepository.findAll()
        );
    }

    //getById
    @GetMapping("/{candidat}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable(name = "candidat", required = false) Candidat candidat) {
        if (candidat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "candidat introuvable");
        }
        return ResponseEntity.ok(
                candidat
        );
    }

    //save
    @PostMapping("/save")
    public ResponseEntity<Candidat> saveCandidat(@Valid @RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatRepository.save(candidat), HttpStatus.CREATED);
    }

    //update
    @PutMapping("/update/{candidat}")
    public ResponseEntity<Candidat> updateCandidat (@PathVariable(name = "candidat", required = false) Candidat candidat,
                                                    @Valid @RequestBody Candidat candidatUpdate) {
        if (candidat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "candidat introuvable");
        } else {
            candidatUpdate.setId(candidat.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    candidatRepository.save(candidatUpdate)
            );
        }
    }

    //delete
    @DeleteMapping("/{candidat}")
    public void deleteCandidatById(@PathVariable(name = "candidat", required = false) Candidat candidat) {
        if (candidat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "candidat introuvable");
        } else {
            candidatRepository.delete(candidat);
        }
    }
}
