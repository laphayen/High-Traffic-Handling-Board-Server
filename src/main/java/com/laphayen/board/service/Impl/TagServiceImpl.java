package com.laphayen.board.service.Impl;

import com.laphayen.board.dto.TagDTO;
import com.laphayen.board.mapper.TagMapper;
import com.laphayen.board.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public void createTag(TagDTO tagDTO) {
        TagDTO existingTag = tagMapper.getTagByName(tagDTO.getTagName());
        if (existingTag != null) {
            throw new IllegalArgumentException("이미 존재하는 태그입니다!: " + tagDTO.getTagName());
        }
        tagMapper.createTag(tagDTO);
    }

    @Override
    public TagDTO getTagById(int id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public List<TagDTO> getTagsByPostId(int postId) {
        return tagMapper.getTagsByPostId(postId);
    }

    @Override
    public List<TagDTO> getAllTags() {
        return tagMapper.getAllTags();
    }

    @Override
    public void updateTag(TagDTO tagDTO) {
        tagMapper.updateTag(tagDTO);
    }

    @Override
    public void deleteTag(int id) {
        tagMapper.deleteTag(id);
    }

}
