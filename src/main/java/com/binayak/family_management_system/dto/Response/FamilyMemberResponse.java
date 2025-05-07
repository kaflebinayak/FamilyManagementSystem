package com.binayak.family_management_system.dto.Response;


import com.binayak.family_management_system.entity.Family;
import com.binayak.family_management_system.entity.FamilyMembers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMemberResponse {
    private Long id;
    private String fristName;
    private String lastName;
    private String gender;
    private Long age;
    private String phone;
    private String address;

    public FamilyMemberResponse(FamilyMembers family) {
        this.id = family.getId();
        this.fristName = family.getFristName();
        this.lastName = family.getLastName();
        this.gender = family.getGender();
        this.age = family.getAge();
        this.phone = family.getPhone();
        this.address = family.getAddress();
    }
//    private String time;
}
