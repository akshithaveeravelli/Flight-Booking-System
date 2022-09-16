package com.capg.dto;

import com.capg.entity.UserData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDataDTO {
	
	private int userId; 
	
    private String username; 
    
    private String phoneNo; 
    
    private String email;
     
    private String userPassword;

    public UserDataDTO(UserData userData) {
        this.userId = userData.getUserId();
        this.username = userData.getUsername();
        this.phoneNo = userData.getPhoneNo();
        this.email = userData.getEmail();
        this.userPassword = userData.getUserPassword();
    }
	

}
