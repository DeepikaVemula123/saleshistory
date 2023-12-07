package com.sprint.saleshistory.service;
 
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprint.saleshistory.models.CountryPojo;
 
@Service
public interface CountryService {
    List<CountryPojo> getAllCountries();
    Optional<CountryPojo> getCountryById(int countryId);
    CountryPojo createCountry(CountryPojo newCountry);
    CountryPojo updateCountry(CountryPojo updateCountry);
    void deleteCountry(int countryId);
}

