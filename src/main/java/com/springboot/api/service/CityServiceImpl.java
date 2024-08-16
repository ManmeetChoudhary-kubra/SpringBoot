package com.springboot.api.service;

import com.springboot.api.dao.CityRepository;
import com.springboot.api.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository theCityRepository) {
        cityRepository = theCityRepository;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(int theId) {
        Optional<City> result = cityRepository.findById(theId);

        City theCity = null;

        if (result.isPresent()) {
            theCity = result.get();
        }
        else {

            throw new RuntimeException("Did not find city id - " + theId);
        }

        return theCity;
    }

    @Override
    public City save(City theCity) {
        return cityRepository.save(theCity);
    }

    @Override
    public void deleteById(int theId) {
        cityRepository.deleteById(theId);
    }
}






