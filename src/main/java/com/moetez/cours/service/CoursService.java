package com.moetez.cours.service;
import org.springframework.data.domain.Page;
import java.util.List;
import com.moetez.cours.entities.Cours;
import com.moetez.cours.entities.Section;

public interface CoursService {
    Page<Cours> getAllCoursParPage(int page, int size);
    Cours saveCours(Cours c);
    Cours updateCours(Cours c);
    void deleteCours(Cours c);
    void deleteCoursById(Long id);
    Cours getCours(Long id);
    List<Cours> getAllCours();
    List<Cours> findByNomCours(String nom);
    List<Cours> findByNomCoursContains(String nom);
    List<Cours> findByNomPrix(String nom, Double prix);
    List<Cours> findBySection(Section section);
    List<Cours> findBySectionIdSection(Long id);
    List<Cours> findByOrderByNomCoursAsc();
    List<Cours> trierCoursNomsPrix();
}