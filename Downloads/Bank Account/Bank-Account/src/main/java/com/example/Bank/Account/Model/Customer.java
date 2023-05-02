package com.example.Bank.Account.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="customer_name")
    String name;
    @Column(name="customer_age")
    Integer age;
    @Column(name="gender")
    String gender;
    @Column(name="phone_number")
    Integer phoneNumber;
    @Column(name="email")
    String email;




}
