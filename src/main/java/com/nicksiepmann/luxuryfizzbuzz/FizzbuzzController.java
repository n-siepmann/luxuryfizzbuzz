/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz;

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
        FizzBundle bundle = new FizzBundle();
        model.addAttribute("syllables", this.service.getSyllables());
        model.addAttribute("fizzbundle", bundle);
        session.setAttribute("fizzbundle", bundle);
        return "index";
    }

    @PostMapping("/addpredicate")
    public String addPredicate(@ModelAttribute("fizzbundle") FizzBundle fizzbundle, Model model, HttpSession session) {
        FizzBundle saved = (FizzBundle) session.getAttribute("fizzbundle");
        if (saved == null) {
            saved = new FizzBundle();
        }
        saved.getPredicatelist().add(fizzbundle.getNewPredicate());
        saved.setNewPredicate(new PredicateDTO());

        model.addAttribute("fizzbundle", saved);
        session.setAttribute("fizzbundle", saved);
        model.addAttribute("syllables", this.service.getSyllables());
        return "index";
    }

    @PostMapping("/submit")
    public String submitPredicates(Model model, HttpSession session) {
        FizzBundle fizzbundle = (FizzBundle) session.getAttribute("fizzbundle");
        fizzbundle.setResults(this.service.process(this.service.parse(fizzbundle.getPredicatelist())));
        fizzbundle.setNewPredicate(new PredicateDTO());

        model.addAttribute("syllables", this.service.getSyllables());
        session.setAttribute("fizzbundle", fizzbundle);
        model.addAttribute("fizzbundle", fizzbundle);
        return "index";
    }

}
