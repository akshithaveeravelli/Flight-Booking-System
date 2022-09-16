package com.capg.service;

import java.util.List;

import com.capg.dto.UserDataDTO;

public interface UserDataService {
	List<UserDataDTO> getUserData();
    UserDataDTO getUser(Integer id);
    UserDataDTO newUser(UserDataDTO userDataDTO);
    UserDataDTO updateUser(Integer id, UserDataDTO userDataDTO);
    void deleteUser(Integer id);
    void deleteAll();

}
