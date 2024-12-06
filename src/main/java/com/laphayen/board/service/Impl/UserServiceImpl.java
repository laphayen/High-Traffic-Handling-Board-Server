package com.laphayen.board.service.Impl;

import com.laphayen.board.dto.UserDTO;
import com.laphayen.board.exception.DuplicateIdException;
import com.laphayen.board.mapper.UserProfileMapper;
import com.laphayen.board.service.UserService;
import com.laphayen.board.util.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserProfileMapper userProfileMapper;

    @Autowired
    public UserServiceImpl(UserProfileMapper userProfileMapper) {
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        if (isDuplicatedId(userDTO.getUserId())) {
            throw new DuplicateIdException("중복된 아이디입니다!");
        }
        userDTO.setCreateTime(new Date());
        userDTO.setPassword(SHA256Util.encryptSHA256(userDTO.getPassword()));
        userProfileMapper.register(userDTO);

        System.out.println("회원가입이 완료되었습니다! User ID: " + userDTO.getUserId());
    }

    @Override
    public UserDTO login(String userId, String password) {
        String encryptedPassword = SHA256Util.encryptSHA256(password);
        return userProfileMapper.findByUserIdAndPassword(userId, encryptedPassword);
    }

    @Override
    public void updateUserProfile(UserDTO userDTO) {
        UserDTO existingUser = userProfileMapper.getUserProfile(userDTO.getUserId());
        if (existingUser == null) {
            throw new RuntimeException("사용자를 찾을 수 없습니다!");
        }

        existingUser.setNickname(userDTO.getNickname());
        userProfileMapper.updateUserProfile(existingUser);
    }

    @Override
    public void updatePassword(String userId, String oldPassword, String newPassword) {
        // 데이터베이스에서 사용자 정보를 가져옴
        UserDTO user = userProfileMapper.getUserProfile(userId);
        if (user == null) {
            throw new RuntimeException("사용자가 존재하지 않습니다!");
        }

        // 기존 비밀번호가 null인지 확인
        if (user.getPassword() == null) {
            throw new RuntimeException("기존 비밀번호가 설정되지 않았습니다!");
        }

        // 기존 비밀번호 확인
        String encryptedOldPassword = SHA256Util.encryptSHA256(oldPassword);
        if (!user.getPassword().equals(encryptedOldPassword)) {
            throw new RuntimeException("기존 비밀번호가 일치하지 않습니다!");
        }

        // 새로운 비밀번호 암호화 및 업데이트
        String encryptedNewPassword = SHA256Util.encryptSHA256(newPassword);
        user.setPassword(encryptedNewPassword);
        userProfileMapper.updatePassword(user);
    }

    @Override
    public void deleteUser(String userId, String password) {
        UserDTO user = login(userId, password);
        if (user == null) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다!");
        }
        userProfileMapper.deleteUserProfile(userId);
    }

    @Override
    public boolean isDuplicatedId(String userId) {
        return userProfileMapper.idCheck(userId) > 0;
    }

    @Override
    public UserDTO getUserInfo(String userId) {
        return userProfileMapper.getUserProfile(userId);
    }

}