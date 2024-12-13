package com.laphayen.board.dto;

import lombok.Data;

@Data
public class TagDTO {
    private Integer id;       // 태그 ID
    private String tagName;   // 태그 이름
    private String url;       // 태그 URL
    private Integer postId;   // 게시글 ID (연관된 게시글)

}
