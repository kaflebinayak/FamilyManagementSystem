package com.binayak.family_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FamilyMembersRequest {

    private int userId;
    private String fristName;
    private String lastName;
    public String gender;
    private Long age;
    private String address;
    private String phone;


//    private String time;

}

