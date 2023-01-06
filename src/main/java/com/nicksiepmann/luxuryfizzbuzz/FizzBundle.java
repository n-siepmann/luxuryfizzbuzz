/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nick.Siepmann
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FizzBundle {
    
    private ArrayList<PredicateDTO> predicatelist;
    private String[] results;
    private PredicateDTO newPredicate;

    public FizzBundle() {
        this.predicatelist = new ArrayList<>();
        this.results = new String[100];
        this.newPredicate = new PredicateDTO();
    }
    
}
