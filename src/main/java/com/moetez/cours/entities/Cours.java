package com.moetez.cours.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@ToString
@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCours;

    private String nomCours;
    private Double prixCours;
    private Date dateCreation;

    public Cours() {
        super();
    }

    public Cours(String nomCours, Double prixCours, Date dateCreation) {
        this.nomCours = nomCours;
        this.prixCours = prixCours;
        this.dateCreation = dateCreation;
    }

    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Double getPrixCours() {
        return prixCours;
    }

    public void setPrixCours(Double prixCours) {
        this.prixCours = prixCours;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

}