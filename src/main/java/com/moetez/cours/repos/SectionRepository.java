package com.moetez.cours.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import com.moetez.cours.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {}