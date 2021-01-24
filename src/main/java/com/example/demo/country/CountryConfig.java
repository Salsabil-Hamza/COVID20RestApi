package com.example.demo.country;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CountryConfig {
@Bean
    CommandLineRunner commandLineRunner (CountryRepository repository) {
        return args -> {
            Country  Germany = new Country("Germany", Country.Status.SHUTDOWN,
                    LocalDate.of(2020, Month.DECEMBER,10),40000,700);

            Country  France = new Country("France", Country.Status.CURFEW,
                    LocalDate.of(2020, Month.SEPTEMBER,15),20000,400);

            Country  China = new Country("China", Country.Status.SOCIAL_DISTANCING,
                    LocalDate.of(2020, Month.APRIL,22),1200,40);

            repository.saveAll(List.of(Germany, France,China));
        };


    }

}
