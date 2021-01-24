package com.example.demo.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;


@Service
public class CountryService {

    private final CountryRepository countryRepository;
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getInfectedCountries() {

        return countryRepository.findAll();
                //List.of(new Country("Germany", Country.Status.SHUTDOWN, LocalDate.of(2020 , Month.OCTOBER,10),20000,1000));
    }

    public void addNewCountry(Country country) {

        Optional<Country> countryOptional = countryRepository.findCountryCases(country.getCases());
        if (countryOptional.isPresent()) {
            throw new IllegalStateException("Cases have already been registered");

        }
        countryRepository.save(country);


    }


    public void deleteCountry(Long countryId) {
        boolean exists = countryRepository.existsById(countryId);
        if(!exists){
            throw new IllegalStateException("country with Id"+countryId+" does not exist");
        }
        countryRepository.deleteById(countryId);
    }
}
