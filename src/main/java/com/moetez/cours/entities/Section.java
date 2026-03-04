package com.moetez.cours.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Data

@AllArgsConstructor

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSection;

    private String nomSection;
    private String descriptionSection;

    @JsonIgnore
    @OneToMany(mappedBy = "section")
    private List<Cours> cours;

    public Section() {}

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public String getDescriptionSection() {
        return descriptionSection;
    }

    public void setDescriptionSection(String descriptionSection) {
        this.descriptionSection = descriptionSection;
    }


    public void setNomSection(String nomSection) {
        this.nomSection = nomSection;
    }
}