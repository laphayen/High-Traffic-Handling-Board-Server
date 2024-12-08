package com.laphayen.board.mapper;

import com.laphayen.board.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    int createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(@Param("postId") int postId);

    int updatePost(PostDTO postDTO);

    int deletePost(@Param("postId") int postId);

}
