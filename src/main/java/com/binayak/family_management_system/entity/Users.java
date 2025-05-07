package com.binayak.family_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String fullName;
//    private String phone;
//    private String address;
//    private String gender;
//    private Date dob;
//    private String image;


    @Enumerated(EnumType.STRING)
    private Role relation;

    @OneToMany
    private List<FamilyMembers> families = new ArrayList<>();


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
