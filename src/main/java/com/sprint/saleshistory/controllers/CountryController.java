package com.sprint.saleshistory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.models.CountryPojo;
import com.sprint.saleshistory.service.CountryService;


@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    // http://localhost:8080/api/v1/countries
    @GetMapping
    List<CountryPojo> getAllCountries() {
        return countryService.getAllCountries();
    }

    // http://localhost:8080/api/v1/countries/1
    @GetMapping("/{countryId}")
    ResponseEntity<CountryPojo> getCountryById(@PathVariable("countryId") int countryId) {
        Optional<CountryPojo> country = countryService.getCountryById(countryId);
        return country != null ? ResponseEntity.ok(country.get()) : ResponseEntity.notFound().build();
    }

    // http://localhost:8080/api/v1/countries
    @PostMapping
    CountryPojo createCountry(@RequestBody CountryPojo newCountryPojo) {
        return countryService.createCountry(newCountryPojo);
    }

    // http://localhost:8080/api/v1/countries/1
    @PutMapping("/{countryId}")
    CountryPojo updateCountry(@PathVariable("countryId") int countryId, @RequestBody CountryPojo updateCountryPojo) {
        updateCountryPojo.setCountryId(countryId);
        return countryService.updateCountry(updateCountryPojo);
    }

    // http://localhost:8080/api/v1/countries/1
    @DeleteMapping("/{countryId}")
    void deleteCountry(@PathVariable("countryId") int countryId) {
        countryService.deleteCountry(countryId);
    }

}