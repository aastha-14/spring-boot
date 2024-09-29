package com.aastha.springboot.entity;

import jakarta.persistence.*;

// marks this class to be mapped to DB table
@Entity
@Table(name="student")
public class Student {
    // Step 1 - define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;
//    Step 2 - define constructor
//    types -  no argument(required by JPA), argument constructor
//    No Argument Constructor
    public Student(){

    }
//    Argument Constructor
    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
//    define getter/setters
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getEmail() {
        return email;
    }
//     define toString method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
