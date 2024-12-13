package com.laphayen.board.mapper;

import com.laphayen.board.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {

    int createTag(TagDTO tagDTO);  // 태그 생성

    TagDTO getTagById(int id);     // 태그 ID로 조회

    List<TagDTO> getTagsByPostId(@Param("postId") int postId); // 게시글 ID로 태그 조회

    List<TagDTO> getAllTags();     // 모든 태그 조회

    int updateTag(TagDTO tagDTO);     // 태그 수정 메서드 추가

    int deleteTag(int id);         // 태그 삭제

    int addTagToPost(@Param("postId") int postId, @Param("tagId") int tagId);

    TagDTO getTagByName(@Param("tagName") String tagName);

}
