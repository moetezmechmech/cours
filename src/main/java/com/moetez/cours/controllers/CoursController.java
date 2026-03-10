package com.moetez.cours.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moetez.cours.entities.Cours;
import com.moetez.cours.entities.Section;
import com.moetez.cours.service.CoursService;

import jakarta.validation.Valid;

@Controller
public class CoursController {

    @Autowired
    private CoursService coursService;

    @RequestMapping("/ListeCours")
    public String listeCours(ModelMap modelMap,
                             @RequestParam(name="page", defaultValue="0") int page,
                             @RequestParam(name="size", defaultValue="2") int size) {

        Page<Cours> coursPage = coursService.getAllCoursParPage(page, size);

        modelMap.addAttribute("cours", coursPage);
        modelMap.addAttribute("pages", new int[coursPage.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeCours";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap,
                             @RequestParam(name="page", defaultValue="0") int page,
                             @RequestParam(name="size", defaultValue="2") int size) {

        List<Section> secs = coursService.getAllSections();
        modelMap.addAttribute("cours", new Cours());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("sections", secs);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        return "formCours";
    }

    @RequestMapping("/modifierCours")
    public String editerCours(@RequestParam("id") Long id,
                              ModelMap modelMap,
                              @RequestParam(name="page", defaultValue="0") int page,
                              @RequestParam(name="size", defaultValue="2") int size) {

        Cours c = coursService.getCours(id);
        List<Section> secs = coursService.getAllSections();

        modelMap.addAttribute("cours", c);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("sections", secs);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        return "formCours";
    }

    @RequestMapping("/saveCours")
    public String saveCours(@Valid @ModelAttribute("cours") Cours cours,
                            BindingResult bindingResult,
                            @RequestParam(name="page", defaultValue="0") int page,
                            @RequestParam(name="size", defaultValue="2") int size,
                            ModelMap modelMap) {

        int currentPage;
        boolean isNew = false;

        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("mode", (cours.getIdCours() == null) ? "new" : "edit");
            modelMap.addAttribute("sections", coursService.getAllSections());
            modelMap.addAttribute("page", page);
            modelMap.addAttribute("size", size);
            return "formCours";
        }

        if (cours.getIdCours() == null) isNew = true;

        coursService.saveCours(cours);

        if (isNew) {
            Page<Cours> coursPage = coursService.getAllCoursParPage(page, size);
            currentPage = coursPage.getTotalPages() - 1;
        } else {
            currentPage = page;
        }

        return "redirect:/ListeCours?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerCours")
    public String supprimerCours(@RequestParam("id") Long id,
                                 @RequestParam(name="page", defaultValue="0") int page,
                                 @RequestParam(name="size", defaultValue="2") int size) {

        coursService.deleteCoursById(id);
        return "redirect:/ListeCours?page=" + page + "&size=" + size;
    }
}