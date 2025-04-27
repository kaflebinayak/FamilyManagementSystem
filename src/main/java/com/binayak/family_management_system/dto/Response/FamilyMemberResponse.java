package com.binayak.family_management_system.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMemberResponse {
    private Long id;
    private String memberName;
    private Long age;
    private String phone;
    private String address;

}
