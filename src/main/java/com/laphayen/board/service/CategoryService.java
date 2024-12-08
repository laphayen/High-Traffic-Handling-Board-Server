package com.laphayen.board.service;

import com.laphayen.board.dto.CategoryDTO;

public interface CategoryService {

    void createCategory(CategoryDTO categoryDTO);

    void updateCategory(int categoryId, String categoryName);

    void deleteCategory(int categoryId);
}
