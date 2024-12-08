package com.laphayen.board.service.Impl;

import com.laphayen.board.dto.CategoryDTO;
import com.laphayen.board.mapper.CategoryMapper;
import com.laphayen.board.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        categoryMapper.createCategory(categoryDTO);
    }

    @Override
    public void updateCategory(int categoryId, String categoryName) {
        categoryMapper.updateCategory(categoryId, categoryName);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryMapper.deleteCategory(categoryId);
    }

}
