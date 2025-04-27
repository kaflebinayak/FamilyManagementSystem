package com.binayak.family_management_system.dto.request;

import com.binayak.family_management_system.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private String address;
    private String gender;
    private Date dob;
    private Role role;
//    private MultipartFile profilePhoto;
}
