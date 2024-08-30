package com.springboot.api.controller;


import com.springboot.api.entity.City;
import com.springboot.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {



    private CityService cityService;

    @Autowired
    public CityController(CityService theCityService) {
        cityService = theCityService;
    }

    @GetMapping("/list")
    public String listCities(Model theModel){

        List<City> theCities = cityService.findAll();

        theModel.addAttribute("cities", theCities);

        return  "list-cities";

    }

    @GetMapping("/add")
    public String addCity(Model theModel){

        City city = new City();

        theModel.addAttribute("city", city);

        return  "add-cities";

    }

    @PostMapping("/save")
    public String addCity(@ModelAttribute("city") City city){

        cityService.save(city);

        return "redirect:/list";

    }

}
