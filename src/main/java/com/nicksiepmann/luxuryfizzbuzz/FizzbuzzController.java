/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Nick.Siepmann
 */
@Controller
@RequiredArgsConstructor
public class FizzbuzzController {

    @Autowired
    final FizzbuzzService service;

    @GetMapping("/")
    public String getIndex(Model model, HttpSession session) {
        ArrayList<PredicateDTO> predicatelist = new ArrayList<>();
        model.addAttribute("syllables", this.service.getSyllables());
        model.addAttribute("predicatelist", predicatelist);
        model.addAttribute("predicatedto", new PredicateDTO());
        session.setAttribute("predicatelist", predicatelist);
        return "fizzbuzz";
    }

    @PostMapping("/addpredicate")
    public String addPredicate(@ModelAttribute("predicatedto") PredicateDTO predicatedto, Model model, HttpSession session) {
        ArrayList<PredicateDTO> predicatelist = (ArrayList<PredicateDTO>) session.getAttribute("predicatelist");
        if (predicatelist == null) {
            predicatelist = new ArrayList<>();
        }
        if (!predicatedto.getName().isBlank()){
        predicatelist.add(predicatedto);}

        model.addAttribute("syllables", this.service.getSyllables());
        model.addAttribute("predicatelist", predicatelist);
        model.addAttribute("predicatedto", new PredicateDTO());
        session.setAttribute("predicatelist", predicatelist);
        return "fizzbuzz";
    }

    @PostMapping("/submit")
    public String submitPredicates(Model model, HttpSession session) {
        ArrayList<PredicateDTO> predicatelist = (ArrayList<PredicateDTO>) session.getAttribute("predicatelist");
        if (predicatelist == null) {
            return "redirect:/";
        }
        model.addAttribute("syllables", this.service.getSyllables());
        model.addAttribute("predicatelist", predicatelist);
        model.addAttribute("predicatedto", new PredicateDTO());
        session.setAttribute("predicatelist", predicatelist);
        model.addAttribute("results", this.service.process(this.service.parse(predicatelist)));
        return "fizzbuzz";
    }

}
