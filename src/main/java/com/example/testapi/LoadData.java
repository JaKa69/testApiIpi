package com.example.testapi;

import com.example.testapi.model.Candidat;
import com.example.testapi.repository.CandidatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadData {
    private final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(CandidatRepository repository) {
        log.info("Chargement des données");
        if (repository.count() == 0) {
            LocalDate dateNaissance = LocalDate.parse("1974-06-05");
            Candidat candidat = new Candidat("Chevalier", "Nicolas", dateNaissance, "Place Charles Hernu", "Villeurbanne", "69100");
            return args -> log.info("Chargement de " + repository.save(candidat));
        } else {
            return args -> log.info("Données déjà chargées");
        }
    }
}