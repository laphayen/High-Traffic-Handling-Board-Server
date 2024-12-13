package com.laphayen.board.service;

import com.laphayen.board.dto.TagDTO;
import com.laphayen.board.dto.PostDTO;

import java.util.List;

public interface TagService {

    void createTag(TagDTO tagDTO);         // 태그 생성

    TagDTO getTagById(int id);             // 태그 ID로 조회

    List<TagDTO> getTagsByPostId(int postId); // 게시글 ID로 태그 조회

    List<TagDTO> getAllTags();             // 모든 태그 조회

    void updateTag(TagDTO tagDTO);         // 태그 수정 메서드 추가

    void deleteTag(int id);                // 태그 삭제

}
