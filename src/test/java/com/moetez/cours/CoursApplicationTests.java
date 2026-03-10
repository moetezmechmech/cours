package com.moetez.cours;
import com.moetez.cours.entities.Section;
import com.moetez.cours.entities.Cours;
import com.moetez.cours.repos.CoursRepository;
import com.moetez.cours.service.CoursService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import com.moetez.cours.repos.SectionRepository;

import java.util.Date;

@SpringBootTest
class CoursApplicationTests {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private CoursService CoursService ;

    @Test
    public void testCreateCours() {
        Section s = sectionRepository.findById(1L).orElse(null);
        Cours c = new Cours();
        c.setNomCours("Spring Boot");
        c.setPrixCours(300.0);
        c.setDateCreation(new Date());
        c.setSection(s);

        coursRepository.save(c);
        c.setSection(s);
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




    @Test
    void testFindByNomCours() {
        coursRepository.findByNomCours("Spring Boot").forEach(System.out::println);
    }

    @Test
    void testFindByNomCoursContains() {
        coursRepository.findByNomCoursContains("Spring").forEach(System.out::println);
    }

    @Test
    void testFindByNomPrix() {
        coursRepository.findByNomPrix("Spring", 200.0).forEach(System.out::println);
    }

    @Test
    void testFindBySection() {
        Section s = new Section();
        s.setIdSection(1L);
        coursRepository.findBySection(s).forEach(System.out::println);
    }

    @Test
    void testFindBySectionIdSection() {
        coursRepository.findBySectionIdSection(3L).forEach(System.out::println);
    }

    @Test
    void testTriNomAsc() {
        coursRepository.findByOrderByNomCoursAsc().forEach(System.out::println);
    }

    @Test
    void testTriNomPrix() {
        coursRepository.trierCoursNomsPrix().forEach(System.out::println);
    }

    @Autowired SectionRepository sectionRepository;

    @Test
    void testCreateSection() {
        Section s = new Section();
        s.setNomSection("frontend");
        s.setDescriptionSection("Cours frontend");
        sectionRepository.save(s);
    }

}
