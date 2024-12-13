package com.laphayen.board.controller;

import com.laphayen.board.dto.TagDTO;
import com.laphayen.board.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    // 태그 생성
    @PostMapping
    public ResponseEntity<String> createTag(@RequestBody TagDTO tagDTO) {
        tagService.createTag(tagDTO);
        return ResponseEntity.ok("태그가 생성되었습니다!");
    }

    // 태그 ID로 조회
    @GetMapping("/{id}")
    public TagDTO getTagById(@PathVariable int id) {
        return tagService.getTagById(id);
    }

    // 게시글 ID로 태그 조회
    @GetMapping("/post/{postId}")
    public List<TagDTO> getTagsByPostId(@PathVariable int postId) {
        return tagService.getTagsByPostId(postId);
    }

    // 모든 태그 조회
    @GetMapping
    public List<TagDTO> getAllTags() {
        return tagService.getAllTags();
    }

    // 태그 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTag(@PathVariable int id, @RequestBody TagDTO tagDTO) {
        tagDTO.setId(id);
        tagService.updateTag(tagDTO);
        return ResponseEntity.ok("태그가 성공적으로 수정되었습니다.");
    }

    // 태그 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable int id) {
        tagService.deleteTag(id);
        return ResponseEntity.ok("태그가 삭제되었습니다!");
    }

}
