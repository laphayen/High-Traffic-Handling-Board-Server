package com.laphayen.board.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    public enum Status {
        DEFAULT, ADMIN, DELETED;
    }

    private int id;
    private String userId;
    private String password;
    private String nickname;
    private boolean isAdmin;
    private Date createTime;
    private boolean isWithDraw;
    private Status status;

    // 사용자 등록 전 필수 데이터 확인
    public boolean isNullDataBeforeRegister() {
        return userId == null || userId.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || nickname == null || nickname.trim().isEmpty();
    }

}
