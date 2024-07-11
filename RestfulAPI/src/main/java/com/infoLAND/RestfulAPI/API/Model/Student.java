package com.infoLAND.RestfulAPI.API.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student", schema = "restfulapi_study")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Please enter the Student Name.")
    private String name;

    @Column(name = "age")
    @NotNull(message = "Please enter the Student Age.")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Please enter the Email.")
    @Email(message = "Please enter the valid Email.")
    private String email;

    @Column(name = "phone")
    @NotBlank(message = "Please enter the Phone number.")
    private String phone;

    public Student() {}

//    Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
