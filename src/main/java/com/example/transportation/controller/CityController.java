package com.example.transportation.controller;


import com.example.transportation.entity.City;
import com.example.transportation.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public String listCities(Model model) {
        List<City> citiesList = (List<City>) cityRepository.findAll();
        model.addAttribute("citiesList", citiesList);
        return "cities";
    }

    @GetMapping("/cities/add")
    public String addCity(Model model) {
        model.addAttribute("city", new City());
        return "cities-form";
    }

    @PostMapping("/cities/save")
    public String saveCity(City city) {
        cityRepository.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/cities/edit/{cityID}")
    public String editCity(@PathVariable("cityID") Long cityID, Model model) {
        if (cityRepository.findById(cityID).isPresent()) {
            City city = cityRepository.findById(cityID).get();
            model.addAttribute("city", city);
            return "cities-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/cities/delete/{cityID}")
    public String deleteCity(@PathVariable("cityID") Long cityID, Model model) {
        if (cityRepository.findById(cityID).isPresent()) {
            cityRepository.deleteById(cityID);
            List<City> citiesList = (List<City>) cityRepository.findAll();
            model.addAttribute("citiesList", citiesList);
            return "cities";
        } else {
            return "error";
        }
    }
}