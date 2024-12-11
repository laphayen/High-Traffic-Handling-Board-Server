package com.laphayen.board.mapper;

import com.laphayen.board.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    int createComment(CommentDTO commentDTO);

    List<CommentDTO> getCommentsByPostId(@Param("postId") int postId);

    int updateComment(CommentDTO commentDTO);

    int deleteComment(@Param("id") int id);

}
