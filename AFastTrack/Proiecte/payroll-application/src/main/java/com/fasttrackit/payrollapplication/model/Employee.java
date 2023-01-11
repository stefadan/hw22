package com.fasttrackit.payrollapplication.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String nume;
    @Column
    String prenume;

    public Employee(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    //@Column
    //Date dataAngajare;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payroll> payroll;

}
