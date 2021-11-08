package com.example.transportation.controller;

import com.example.transportation.entity.Cargo;
import com.example.transportation.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/cargoes")
    public String listCargoes(Model model) {
        List<Cargo> cargoesList = (List<Cargo>) cargoRepository.findAll();
        model.addAttribute("cargoesList", cargoesList);
        return "cargoes";
    }

    @GetMapping("/cargoes/add")
    public String addCargo(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargoes-form";
    }

    @PostMapping("/cargoes/save")
    public String saveCargo(Cargo cargo) {
        cargoRepository.save(cargo);
        return "redirect:/cargoes";
    }

    @GetMapping("/cargoes/edit/{cargoID}")
    public String editCargo(@PathVariable("cargoID") Long cargoID, Model model) {
        if (cargoRepository.findById(cargoID).isPresent()) {
            Cargo cargo = cargoRepository.findById(cargoID).get();
            model.addAttribute("cargo", cargo);
            return "cargoes-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/cargoes/delete/{cargoID}")
    public String deleteCargo(@PathVariable("cargoID") Long cargoID, Model model) {
        if (cargoRepository.findById(cargoID).isPresent()) {
            cargoRepository.deleteById(cargoID);
            List<Cargo> cargoesList = (List<Cargo>) cargoRepository.findAll();
            model.addAttribute("cargoesList", cargoesList);
            return "cargoes";
        } else {
            return "error";
        }
    }
}
