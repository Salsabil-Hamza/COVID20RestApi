package com.example.demo.country;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path = "api/v2/country")
public class CountryController {

    private final CountryService countryService;
@Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getInfectedCountries() {

        return countryService.getInfectedCountries();
    }
    @PostMapping
    public void addNewCountry(@RequestBody Country country){
    countryService.addNewCountry(country);
    }

    @DeleteMapping(path = "countryId")
    public void deleteCountry(@PathVariable("countryId") Long countryId ){
        countryService.deleteCountry(countryId);
    }

}
