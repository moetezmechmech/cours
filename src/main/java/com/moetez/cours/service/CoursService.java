package com.moetez.cours.service;
import org.springframework.data.domain.Page;
import java.util.List;
import com.moetez.cours.entities.Cours;

public interface CoursService {
    Page<Cours> getAllCoursParPage(int page, int size);
    Cours saveCours(Cours c);
    Cours updateCours(Cours c);
    void deleteCours(Cours c);
    void deleteCoursById(Long id);
    Cours getCours(Long id);
    List<Cours> getAllCours();
}