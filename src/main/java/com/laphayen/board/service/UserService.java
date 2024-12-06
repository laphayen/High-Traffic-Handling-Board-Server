package com.laphayen.board.service;

import com.laphayen.board.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerUser(UserDTO userDTO);

    UserDTO login(String userId, String password);

    boolean isDuplicatedId(String userId);

    UserDTO getUserInfo(String userId);

    void updatePassword(String userId, String beforePassword, String afterPassword);

    void deleteUser(String userId, String password);

    void updateUserProfile(UserDTO userDTO);


}
