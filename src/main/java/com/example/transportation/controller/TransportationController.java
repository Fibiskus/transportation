package com.example.transportation.controller;

import com.example.transportation.entity.Transportation;
import com.example.transportation.repository.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TransportationController {
    @Autowired
    private TransportationRepository transportationRepository;

    @GetMapping("/transportation")
    public String listTransportations(Model model) {
        List<Transportation> transportationList = (List<Transportation>) transportationRepository.findAll();
        model.addAttribute("transportationList", transportationList);
        return "transportation";
    }

    @GetMapping("/transportation/add")
    public String addTransportation(Model model) {
        model.addAttribute("transportation", new Transportation());
        return "transportation-form";
    }

    @PostMapping("/transportation/save")
    public String saveTransportation(Transportation transportation) {
        transportationRepository.save(transportation);
        return "redirect:/transportation";
    }

    @GetMapping("/transportation/edit/{transportationID}")
    public String editTransportation(@PathVariable("transportationID") Long transportationID, Model model) {
        if (transportationRepository.findById(transportationID).isPresent()) {
            Transportation transportation = transportationRepository.findById(transportationID).get();
            model.addAttribute("transportation", transportation);
            return "transportation-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/transportation/delete/{transportationID}")
    public String deleteTransportation(@PathVariable("transportationID") Long transportationID, Model model) {
        if (transportationRepository.findById(transportationID).isPresent()) {
            transportationRepository.deleteById(transportationID);
            List<Transportation> transportationList = (List<Transportation>) transportationRepository.findAll();
            model.addAttribute("transportationList", transportationList);
            return "transportation";
        } else {
            return "error";
        }
    }
}