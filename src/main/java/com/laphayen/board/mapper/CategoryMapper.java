package com.laphayen.board.mapper;

import com.laphayen.board.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {

    int createCategory(CategoryDTO categoryDTO);

    int updateCategory(@Param("categoryId") int categoryId, @Param("categoryName") String categoryName);

    int deleteCategory(@Param("categoryId") int categoryId);

}
