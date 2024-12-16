package com.laphayen.board.controller;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.dto.UserDTO;
import com.laphayen.board.service.PostService;
import com.laphayen.board.service.UserService;
import com.laphayen.board.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO, HttpSession session) {
        // 세션에서 로그인한 사용자의 userId 가져오기
        String loginUserId = SessionUtil.getLoginMemberId(session);
        if (loginUserId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        // userId를 기반으로 user 테이블에서 id를 조회
        UserDTO userDTO = userService.getUserInfo(loginUserId);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 사용자입니다.");
        }

        // 게시글 DTO에 userId 설정
        postDTO.setUserId(userDTO.getId());

        // 게시글 생성
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

    @PostMapping("/with-tags")
    public ResponseEntity<?> createPostWithTags(@RequestBody PostDTO postDTO) {
        postService.createPostWithTags(postDTO);
        return ResponseEntity.ok().build();
    }

}
