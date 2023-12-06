package nl.itvitae.companydemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int numberOfEmployees;

    public Company(String name, int numberOfEmployees) {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }
}
