package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Le champ nom ne peut pas être null")
    @NotBlank(message = "Le champ nom ne peut pas être vide")
    public String nom;
    @NotNull(message = "Le champ prenom ne peut pas être null")
    @NotBlank(message = "Le champ prenom ne peut pas être vide")
    public String prenom;
    @NotNull(message = "Le champ dateNaissance ne peut pas être null")
    @Temporal(value= TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate dateNaissance;
    @NotNull(message = "Le champ adresse ne peut pas être null")
    @NotBlank(message = "Le champ adresse ne peut pas être vide")
    public String adresse;
    @NotNull(message = "Le champ ville ne peut pas être null")
    @NotBlank(message = "Le champ ville ne peut pas être vide")
    public String ville;
    @NotNull(message = "Le champ codePostal ne peut pas être null")
    @NotBlank(message = "Le champ codePostal ne peut pas être vide")
    public String codePostal;

    public Candidat() {
    }

    public Candidat(String nom, String prenom, LocalDate dateNaissance, String adresse, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
