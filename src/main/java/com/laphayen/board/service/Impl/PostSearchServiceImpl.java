package com.laphayen.board.service.Impl;

import com.laphayen.board.dto.PostDTO;
import com.laphayen.board.dto.request.PostSearchRequest;
import com.laphayen.board.mapper.PostSearchMapper;
import com.laphayen.board.service.PostSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PostSearchServiceImpl implements PostSearchService {

    @Autowired
    private PostSearchMapper postSearchMapper;

    @Async
    @Cacheable(value = "getPosts", key = "'getPosts' + #postSearchRequest.getTitle() + #postSearchRequest.getCategoryId()")
    @Override
    public List<PostDTO> getPosts(PostSearchRequest postSearchRequest) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.getPostsByUserId(postSearchRequest);
        } catch (RuntimeException e) {
            log.error("getPostsByUserId 에러!");
        }
        return postDTOList;
    }
}
