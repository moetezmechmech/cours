package com.moetez.cours.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moetez.cours.entities.Cours;
import com.moetez.cours.repos.CoursRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public
class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Cours saveCours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public void deleteCours(Cours c) {
        coursRepository.delete(c);
    }

    @Override
    public void deleteCoursById(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public Cours getCours(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Page<Cours> getAllCoursParPage(int page, int size) {
        return coursRepository.findAll(PageRequest.of(page, size));
    }
}