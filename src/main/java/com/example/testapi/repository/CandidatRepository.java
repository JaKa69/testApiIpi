package com.example.testapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.testapi.model.Candidat;

import java.util.List;

@Repository
public interface CandidatRepository extends CrudRepository<Candidat, Long>{
    @Override
    List<Candidat> findAll();

}
