package com.laphayen.board.service;

import com.laphayen.board.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    void createComment(CommentDTO commentDTO);

    List<CommentDTO> getCommentsByPostId(int postId);

    void updateComment(CommentDTO commentDTO);

    void deleteComment(int id);

}
