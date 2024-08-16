package com.springboot.api.service;

import com.springboot.api.entity.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City findById(int theId);

    City save(City theCity);

    void deleteById(int theId);

}
