package com.laphayen.board.service.Impl;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.mapper.PostMapper;
import com.laphayen.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public void createPost(PostDTO postDTO) {
        LocalDateTime now = LocalDateTime.now();
        postDTO.setCreateTime(now);
        postDTO.setUpdateTime(now);
        postDTO.setViews(0);
        postMapper.createPost(postDTO);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postMapper.getAllPosts();
    }

    @Override
    public PostDTO getPostById(int postId) {
        return postMapper.getPostById(postId);
    }

    @Override
    public void updatePost(PostDTO postDTO) {
        LocalDateTime now = LocalDateTime.now();
        postDTO.setUpdateTime(now);
        postMapper.updatePost(postDTO);
    }

    @Override
    public void deletePost(int postId) {
        postMapper.deletePost(postId);
    }

}
