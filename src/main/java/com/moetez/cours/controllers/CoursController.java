package com.moetez.cours.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moetez.cours.entities.Cours;
import com.moetez.cours.service.CoursService;

@Controller
public class CoursController {

    @Autowired
    private CoursService coursService;

    @RequestMapping("/ListeCours")
    public String listeCours(ModelMap modelMap,
                             @RequestParam(name="page", defaultValue="1") int page,
                             @RequestParam(name="size", defaultValue="2") int size) {

        Page<Cours> coursPage = coursService.getAllCoursParPage(page, size);

        modelMap.addAttribute("cours", coursPage);
        modelMap.addAttribute("pages", new int[coursPage.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeCours";
    }




    @RequestMapping("/saveCours")
    public String saveCours(@ModelAttribute("cours") Cours cours,
                            @RequestParam("date") String date,
                            ModelMap modelMap) throws ParseException {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        cours.setDateCreation(dateCreation);

        coursService.saveCours(cours);

        return "redirect:/ListeCours?page=0&size=2";
    }

    @RequestMapping("/supprimerCours")
    public String supprimerCours(@RequestParam("id") Long id,
                                 ModelMap modelMap,
                                 @RequestParam(name="page", defaultValue="0") int page,
                                 @RequestParam(name="size", defaultValue="2") int size) {

        coursService.deleteCoursById(id);
        return "redirect:/ListeCours?page=" + page + "&size=" + size;
    }
}