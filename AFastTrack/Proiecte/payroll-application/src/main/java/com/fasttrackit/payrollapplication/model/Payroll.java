package com.fasttrackit.payrollapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Payroll {
    public Payroll(int luna, int an, long venitBaza, long sporuri, long retineri, Employee employee,
                   long venitBrut) {
        this.luna = luna;
        this.an = an;
        this.venitBaza = venitBaza;
        this.sporuri = sporuri;
        this.retineri = retineri;
        this.employee =  employee;
        this.venitBrut = venitBrut;
    }

    @Id
    @GeneratedValue
    long id;
    @Column
    int luna;
    @Column
    int an;
    @Column
    long venitBaza;
    @Column
    long sporuri;
    @Column
    long retineri;
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;
    @Column
    long venitBrut;
    /*@Column
    long CAS;
    @Column
    long CASS;
    @Column
    long venitImpozabil;
    @Column
    long impozit;
    @Column
    long venitNet;
    @Column
    long restPlata;
    */

}
