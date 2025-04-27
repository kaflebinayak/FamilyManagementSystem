package com.binayak.family_management_system.dto.Response;

import com.binayak.family_management_system.entity.Family;
import lombok.Data;

@Data

public class FamilyResponse {
    private Long id;
    private String colonyName;
    private String familyName;
    private Integer numberOfFamily;

    public FamilyResponse (Family family){
        this.id= family.getId();
        this.familyName=family.getFamilyName();
        this.colonyName=family.getColonyName();
        this.numberOfFamily=family.getNumberOfFamily();

    }

}
