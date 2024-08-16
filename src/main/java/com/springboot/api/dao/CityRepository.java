package com.springboot.api.dao;

import com.springboot.api.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {


}
