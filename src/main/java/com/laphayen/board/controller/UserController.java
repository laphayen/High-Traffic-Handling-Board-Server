package com.laphayen.board.controller;

import com.laphayen.board.dto.UserDTO;
import com.laphayen.board.service.UserService;
import com.laphayen.board.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Log4j2
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    // 회원가입
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserDTO userDTO) {
        if (userDTO.isNullDataBeforeRegister()) {
            throw new IllegalArgumentException("회원정보를 확인하세요!");
        }
        userService.registerUser(userDTO);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String userId = loginRequest.get("userId");
        String password = loginRequest.get("password");

        UserDTO userInfo = userService.login(userId, password);

        if (userInfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid credentials");
        }

        SessionUtil.setLoginMemberId(session, userId);
        return ResponseEntity.ok(userInfo);

    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        SessionUtil.clear(session);
        return ResponseEntity.ok("로그아웃 되었습니다!");
    }

    // 사용자 정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserInfo(@PathVariable String userId) {
        UserDTO userDTO = userService.getUserInfo(userId);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userDTO);

    }

    // 사용자 정보 수정
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody Map<String, String> updateRequest) {
        String nickname = updateRequest.get("nickname");
        if (nickname == null || nickname.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("닉네임을 입력해주세요.");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setNickname(nickname);

        userService.updateUserProfile(userDTO);
        return ResponseEntity.ok("닉네임이 성공적으로 수정되었습니다!");
    }


    // 비밀번호 변경
    @PatchMapping("/password")
    public ResponseEntity<?> updatePassword(@RequestBody Map<String, String> passwordRequest) {
        String userId = passwordRequest.get("userId");
        String oldPassword = passwordRequest.get("oldPassword");
        String newPassword = passwordRequest.get("newPassword");

        if (userId == null) {
            System.out.println("userId is null");
        } else if (oldPassword == null) {
            System.out.println("oldPassword is null");
        } else if (newPassword == null) {
            System.out.println("newPassword is null");
        }

        userService.updatePassword(userId, oldPassword, newPassword);
        return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다!");

    }

    // 사용자 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId, @RequestBody Map<String, String> deleteRequest) {
        String password = deleteRequest.get("password");
        userService.deleteUser(userId, password);
        return ResponseEntity.ok("사용자가 성공적으로 삭제되었습니다!");

    }

}
