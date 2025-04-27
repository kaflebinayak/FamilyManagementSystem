package com.binayak.family_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FamilyMembersRequest {
    private String memberName;
    private Long age;
    private String address;
    private String phone;

}

