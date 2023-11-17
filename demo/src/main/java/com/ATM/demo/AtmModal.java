package com.ATM.demo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity

@Table(name ="ATM")
public class AtmModal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
     
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    
    @Column(name = "ACCOUNT_PIN" )
    private String accountPin;
    
    @Column(name = "FIRST_NAME")
    private String firstName ;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column( name = "STATUS")
    private String status;
    
    @Column(name = "ACCOUNT_BALANCE")
    private Long accountBalance;
    
    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public AtmModal(Long id, String accountNumber, String accountPin, String firstName,Long accountBalance, String lastName, String status,LocalDate createdDate) {
        Id = id;
        this.accountNumber = accountNumber;
        this.accountPin = accountPin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.createdDate = createdDate;
        this.accountBalance = accountBalance;
    }

    public AtmModal() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(String pin) {
        this.accountPin = pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    

}
