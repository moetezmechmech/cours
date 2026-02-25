package com.moetez.cours.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moetez.cours.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {

}