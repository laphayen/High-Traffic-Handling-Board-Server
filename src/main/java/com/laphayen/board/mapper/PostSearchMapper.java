package com.laphayen.board.mapper;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchMapper {

    List<PostDTO> getPostsByUserId(PostSearchRequest postSearchRequest);

}
