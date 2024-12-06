package com.laphayen.board.mapper;

import com.laphayen.board.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProfileMapper {

    UserDTO getUserProfile(@Param("userId") String userId);

    int updateUserProfile(UserDTO userDTO);

    int deleteUserProfile(@Param("userId") String userId);

    int register(UserDTO userDTO);

    UserDTO findByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    int idCheck(String userId);

    int updatePassword(UserDTO userDTO);

}
