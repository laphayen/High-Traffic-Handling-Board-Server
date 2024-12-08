package com.laphayen.board.controller;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO) {
        postService.createPost(postDTO);
        return ResponseEntity.ok("게시글이 작성되었습니다!");
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable int postId) {
        return postService.getPostById(postId);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable int postId, @RequestBody PostDTO postDTO) {
        postDTO.setId(postId);
        postService.updatePost(postDTO);
        return ResponseEntity.ok("게시글이 수정되었습니다!");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok("게시글이 삭제되었습니다!");
    }

}
