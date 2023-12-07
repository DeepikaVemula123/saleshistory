package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.CountryRepository;
import com.sprint.saleshistory.dao.entities.Country;
import com.sprint.saleshistory.models.CountryPojo;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
    CountryRepository countryRepository;
	
	@Override
	public List<CountryPojo> getAllCountries() {
		List<Country> allCountries = countryRepository.findAll();
        List<CountryPojo> allCountriesPojo = new ArrayList<>();
        for (Country country : allCountries) {
            CountryPojo countryPojo = new CountryPojo();
            BeanUtils.copyProperties(country, countryPojo);
            allCountriesPojo.add(countryPojo);
        }
        return allCountriesPojo;
    }

	@Override
	public Optional<CountryPojo> getCountryById(int countryId) {
		Optional<Country> countryOptional = countryRepository.findById(countryId);

        if (countryOptional.isPresent()) {
            CountryPojo countryPojo = new CountryPojo();
            BeanUtils.copyProperties(countryOptional.get(), countryPojo);
            return Optional.of(countryPojo);
        } else {
            return Optional.empty();
        }
    }

	@Override
	public CountryPojo createCountry(CountryPojo newCountry) {
		Country country = new Country();
        BeanUtils.copyProperties(newCountry, country);
        Country savedCountry = countryRepository.save(country);
        CountryPojo savedCountryPojo = new CountryPojo();
        BeanUtils.copyProperties(savedCountry, savedCountryPojo);

        return savedCountryPojo;
    }

	@Override
	public CountryPojo updateCountry(CountryPojo updateCountry) {
		Optional<Country> existingCountryOptional = countryRepository.findById(updateCountry.getCountryId());

        if (existingCountryOptional.isPresent()) {
            Country existingCountry = existingCountryOptional.get();
            BeanUtils.copyProperties(updateCountry, existingCountry);
            Country updatedCountry = countryRepository.save(existingCountry);
            CountryPojo updatedCountryPojo = new CountryPojo();
            BeanUtils.copyProperties(updatedCountry, updatedCountryPojo);

            return updatedCountryPojo;
        } else {
            return null;
        }
    }


	@Override
	public void deleteCountry(int countryId) {
		Optional<Country> existingCountryOptional = countryRepository.findById(countryId);

        if (existingCountryOptional.isPresent()) {
            countryRepository.deleteById(countryId);
        } else {
            System.out.println("Country with ID " + countryId + " not found. Unable to delete.");
        }
		
		
	}

	

}
