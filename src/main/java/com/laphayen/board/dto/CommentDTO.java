package com.laphayen.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer id; // 댓글 ID
    private Integer postId; // 게시글 ID
    private Integer userId; // 작성자 ID
    private Integer subCommentId; // 부모 댓글 ID (NULL이면 최상위 댓글)
    private String contents; // 댓글 내용
    private boolean isDeleted; // 삭제 여부
    private LocalDateTime createTime; // 작성 시간
    private LocalDateTime updateTime; // 수정 시간

}