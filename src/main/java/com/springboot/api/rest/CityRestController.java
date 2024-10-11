package com.springboot.api.rest;

import com.springboot.api.entity.City;
import com.springboot.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityRestController {

    private CityService cityService;

    @Autowired
    public CityRestController(CityService theCityService) {
        cityService = theCityService;
    }


    @GetMapping("/cities")
    public List<City> findAll() {
        return cityService.findAll();
    }



    @GetMapping("/cities/{cityId}")
    public City getCity(@PathVariable int cityId) {

        City theCity = cityService.findById(cityId);

        if (theCity == null) {
            throw new RuntimeException("City id not found - " + cityId);
        }

        return theCity;
    }


    @PostMapping("/cities")
    public City addCity(@RequestBody City theCity) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theCity.setId(0);

        City dbCity = cityService.save(theCity);

        return dbCity;
    }



    @PutMapping("/cities")
    public City updateCity(@RequestBody City theCity) {

        City dbCity = cityService.save(theCity);

        return dbCity;
    }



    @DeleteMapping("/cities/{cityId}")
    public String deleteCity(@PathVariable int cityId) {

        City tempCity = cityService.findById(cityId);

        // throw exception if null

        if (tempCity == null) {
            throw new RuntimeException("City id not found - " + tempCity);
        }

        cityService.deleteById(cityId);

        return "Deleted City id - " + cityId;
    }

}