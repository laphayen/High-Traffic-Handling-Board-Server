package com.laphayen.board.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
