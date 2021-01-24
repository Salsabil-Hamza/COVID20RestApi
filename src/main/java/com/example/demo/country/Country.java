package com.example.demo.country;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Country {


@Id
@SequenceGenerator(
        name = "country_sequence",
        sequenceName = "country_sequence",
        allocationSize = 1

)

@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "country_sequence"
)
    private Long id;
    private String name;
    private Status status;
    private LocalDate startDate;
    private Integer cases;
    private Integer deaths;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }




    public Country(Long id, String name, Status status, LocalDate startDate, Integer cases, Integer deaths) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.cases = cases;
        this.deaths = deaths;
    }

    public Country(String name, Status status, LocalDate startDate, Integer cases, Integer deaths) {
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.cases = cases;
        this.deaths = deaths;
    }

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", startDate=" + startDate +
                ", cases=" + cases +
                ", deaths=" + deaths +
                '}';
    }

    enum Status {
        SOCIAL_DISTANCING, CURFEW, SHUTDOWN
    }
}
