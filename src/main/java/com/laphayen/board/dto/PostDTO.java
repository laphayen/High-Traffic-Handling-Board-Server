package com.laphayen.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PostDTO {

    private Integer id;
    private String title;
    private String contents;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer views;
    private Integer categoryId;
    private Integer userId;
    private boolean isAdmin;
    private List<TagDTO> tags;

}
