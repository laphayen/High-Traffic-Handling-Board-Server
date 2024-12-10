package com.laphayen.board.service;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {

    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);

}
