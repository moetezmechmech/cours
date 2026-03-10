package com.moetez.cours.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data


@ToString(exclude = "cours")
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