package com.pizzashop.pizzabackend.customer;

import jakarta.persistence.*;
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String subdivision;
    private String address;
    private String city;
    private String state;
    private String country;
    private String majorIntersection;
    private String phoneNumber;

    public Customer() {

    }
    // Customer construct
    public Customer(String firstName, String lastName, String email, String password, String subdivision, String address, String city, String state, String country, String majorIntersection, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.subdivision = subdivision;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.majorIntersection = majorIntersection;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getSubdivision() {
        return subdivision;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getCountry() {
        return country;
    }
    public String getMajorIntersection() {
        return majorIntersection;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setMajorIntersection(String majorIntersection) {
        this.majorIntersection = majorIntersection;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
