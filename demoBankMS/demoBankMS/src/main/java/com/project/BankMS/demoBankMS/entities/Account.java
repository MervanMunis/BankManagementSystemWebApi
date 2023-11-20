// This is our account class
package com.project.BankMS.demoBankMS.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data   // By using this annotation from lombok we don't have to write getters and setter.
@Entity // We want this table to get map with the class. Therefor, for this mapping the annotation is used.
@Table(name="account")
public class Account {

    @Id // To define id as a primary key we use Id annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id is generated automatically there for thi annotation i used
    private final int id;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private double balance;

    // Write a constructor
    public Account() {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
}
