package com.laphayen.board.service;

import com.laphayen.board.dto.PostDTO;

import java.util.List;

public interface PostService {

    void createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(int postId);

    void updatePost(PostDTO postDTO);

    void deletePost(int postId);

    void createPostWithTags(PostDTO postDTO);

}