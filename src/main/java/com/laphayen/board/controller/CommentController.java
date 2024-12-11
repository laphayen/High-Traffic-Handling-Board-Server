package com.laphayen.board.controller;

import com.laphayen.board.dto.CommentDTO;
import com.laphayen.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentDTO commentDTO) {
        commentService.createComment(commentDTO);
        return ResponseEntity.ok("댓글이 작성되었습니다!");
    }

    @GetMapping("/post/{postId}")
    public List<CommentDTO> getCommentsByPostId(@PathVariable int postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateComment(@PathVariable int id, @RequestBody CommentDTO commentDTO) {
        commentDTO.setId(id);
        commentService.updateComment(commentDTO);
        return ResponseEntity.ok("댓글이 수정되었습니다!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("댓글이 삭제되었습니다!");
    }

}