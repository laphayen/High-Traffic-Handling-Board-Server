package com.laphayen.board.controller;

import com.laphayen.board.dto.CategoryDTO;
import com.laphayen.board.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("카테고리가 등록되었습니다!");
    }

    @PatchMapping("/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable int categoryId, @RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryId, categoryDTO.getCategoryName());
        return ResponseEntity.ok("카테고리가 수정되었습니다!");
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("카테고리가 삭제되었습니다!");
    }
}