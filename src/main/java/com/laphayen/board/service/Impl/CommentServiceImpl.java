package com.laphayen.board.service.Impl;


import com.laphayen.board.dto.CommentDTO;
import com.laphayen.board.mapper.CommentMapper;
import com.laphayen.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void createComment(CommentDTO commentDTO) {
        LocalDateTime now = LocalDateTime.now();
        commentDTO.setCreateTime(now);
        commentDTO.setUpdateTime(now);
        commentMapper.createComment(commentDTO);
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(int postId) {
        return commentMapper.getCommentsByPostId(postId);
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        commentDTO.setUpdateTime(LocalDateTime.now());
        commentMapper.updateComment(commentDTO);
    }

    @Override
    public void deleteComment(int id) {
        commentMapper.deleteComment(id);
    }

}
