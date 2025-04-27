package com.binayak.family_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FamilyRequest {

    private String colonyName;
    private String familyName;
    private Integer numberOfFamily;



}
