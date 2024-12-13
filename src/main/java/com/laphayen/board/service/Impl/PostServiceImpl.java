package com.laphayen.board.service.Impl;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.dto.TagDTO;
import com.laphayen.board.mapper.PostMapper;
import com.laphayen.board.mapper.TagMapper;
import com.laphayen.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final TagMapper tagMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper, TagMapper tagMapper) {
        this.postMapper = postMapper;
        this.tagMapper = tagMapper;
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

    @Override
    public void createPostWithTags(PostDTO postDTO) {
        // 게시글 생성
        LocalDateTime now = LocalDateTime.now();
        postDTO.setCreateTime(now);
        postDTO.setUpdateTime(now);
        postDTO.setViews(0);
        postMapper.createPost(postDTO);

        // 게시글 ID 가져오기
        Integer postId = postDTO.getId();

        // 태그 생성 및 연결
        if (postDTO.getTags() != null) {
            for (TagDTO tag : postDTO.getTags()) {
                TagDTO existingTag = tagMapper.getTagByName(tag.getTagName());
                if (existingTag != null) {
                    tag.setId(existingTag.getId());
                } else {
                    tagMapper.createTag(tag);
                }
                tagMapper.addTagToPost(postId, tag.getId());
            }
        }
    }

}
