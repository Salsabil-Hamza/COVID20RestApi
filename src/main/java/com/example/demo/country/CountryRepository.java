package com.example.demo.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

//@Query("SELECT c FROM Country c where s.Cases =?1")
    Optional<Country> findCountryCases(Integer cases);
}
