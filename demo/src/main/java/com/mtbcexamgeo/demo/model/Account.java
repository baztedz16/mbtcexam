package com.mtbcexamgeo.demo.model;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    
    private Double availableBalance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Getters and Setters
}

enum AccountType {
    SAVINGS, CHECKING
}
