package com.moetez.cours;

import com.moetez.cours.entities.Cours;
import com.moetez.cours.repos.CoursRepository;
import com.moetez.cours.service.CoursService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;

@SpringBootTest
class CoursApplicationTests {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private CoursService CoursService ;

    @Test
    public void testCreateCours() {
        Cours c = new Cours("Spring Boot", 300.0, new Date());
        coursRepository.save(c);
    }

    @Test
    public void testFindCours() {
        Cours c = coursRepository.findById(1L).orElse(null);
        System.out.println(c);
    }

    @Test
    public void testUpdateCours() {
        Cours c = coursRepository.findById(1L).orElseThrow();
        c.setPrixCours(999.0);
        coursRepository.save(c);
    }

    @Test
    public void testDeleteCours() {
        coursRepository.deleteById(2L);
    }

    @Test
    public void testListerTousCours() {
        coursRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void testGetAllCoursParPage() {
        Page<Cours> cours = CoursService.getAllCoursParPage(0, 2);
        System.out.println(cours.getSize());
        System.out.println(cours.getTotalElements());
        System.out.println(cours.getTotalPages());
        cours.getContent().forEach(System.out::println);
    }
}