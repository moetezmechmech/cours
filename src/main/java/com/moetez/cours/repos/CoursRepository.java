package com.moetez.cours.repos;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.moetez.cours.entities.Cours;
import com.moetez.cours.entities.Section;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    // 1) بحث بالاسم (exact + contains)
    List<Cours> findByNomCours(String nom);
    List<Cours> findByNomCoursContains(String nom);

    // 2) JPQL: الاسم يحتوي و السعر أكبر من قيمة
    @Query("select c from Cours c where c.nomCours like %:nom% and c.prixCours > :prix")
    List<Cours> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    // 3) بحث حسب Section entity
    @Query("select c from Cours c where c.section = ?1")
    List<Cours> findBySection(Section section);

    // 4) بحث حسب idSection
    List<Cours> findBySectionIdSection(Long id);

    // 5) Tri
    List<Cours> findByOrderByNomCoursAsc();

    @Query("select c from Cours c order by c.nomCours ASC, c.prixCours DESC")
    List<Cours> trierCoursNomsPrix();
}