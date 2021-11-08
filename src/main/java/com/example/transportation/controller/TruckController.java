package com.example.transportation.controller;


import com.example.transportation.entity.Truck;
import com.example.transportation.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TruckController {
    @Autowired
    private TruckRepository truckRepository;

    @GetMapping("/trucks")
    public String listTrucks(Model model) {
        List<Truck> trucksList = (List<Truck>) truckRepository.findAll();
        model.addAttribute("trucksList", trucksList);
        return "trucks";
    }

    @GetMapping("/trucks/add")
    public String addTruck(Model model) {
        model.addAttribute("truck", new Truck());
        return "trucks-form";
    }

    @PostMapping("/trucks/save")
    public String saveTruck(Truck truck) {
        truckRepository.save(truck);
        return "redirect:/trucks";
    }

    @GetMapping("/trucks/edit/{truckID}")
    public String editTruck(@PathVariable("truckID") Long truckID, Model model) {
        if (truckRepository.findById(truckID).isPresent()) {
            Truck truck = truckRepository.findById(truckID).get();
            model.addAttribute("truck", truck);
            return "trucks-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/trucks/delete/{truckID}")
    public String deleteTruck(@PathVariable("truckID") Long truckID, Model model) {
        if (truckRepository.findById(truckID).isPresent()) {
            truckRepository.deleteById(truckID);
            List<Truck> trucksList = (List<Truck>) truckRepository.findAll();
            model.addAttribute("trucksList", trucksList);
            return "trucks";
        } else {
            return "error";
        }
    }
}
