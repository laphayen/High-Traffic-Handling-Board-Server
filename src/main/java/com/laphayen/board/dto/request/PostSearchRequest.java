package com.laphayen.board.dto.request;

import com.laphayen.board.dto.CategoryDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostSearchRequest {

    private int id;
    private String title;
    private String contents;
    private int views;
    private int categoryId;
    private int userId;
    private CategoryDTO.SortStatus sortStatus;

}
