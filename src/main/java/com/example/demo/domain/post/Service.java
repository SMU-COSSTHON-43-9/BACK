package com.example.demo.domain.post;

import com.example.demo.domain.post.Dto.PostRequestDto;
import com.example.demo.domain.post.Dto.PostResponseDto;
import com.example.demo.exception.errorCode.UserErrorCode;
import com.example.demo.exception.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional
public class Service {

    private final Repository repository;

    public Long createPosts(PostRequestDto.PostRDto postRDto) {
        Post post = Converter.toPost(postRDto);
        Post savePost = repository.save(post);
        return savePost.getId();
    }

    @Transactional(readOnly = true)
    public PostResponseDto.PostListDto readPosts() {
        List<Post> posts = repository.findAll();
        PostResponseDto.PostListDto postListDto = Converter.toPostListDto(posts);
        return postListDto;
    }

    @Transactional(readOnly = true)
    public PostResponseDto.PostDto readPost(Long postId) {
        Post post = repository.findById(postId).orElseThrow(() -> {
            throw new RestApiException(UserErrorCode.INACTIVE_POST);
        });
        PostResponseDto.PostDto postListDto = Converter.toPostDto(post);
        return postListDto;
    }

    public void deletePost(Long postId, PostRequestDto.PostDeleteDto postDeleteDto) {
        Post post = repository.findById(postId).orElseThrow(() -> {
            throw new RestApiException(UserErrorCode.INACTIVE_POST);
        });
        if (postDeleteDto.getPassword() != post.getPassword()) {
            throw new RestApiException(UserErrorCode.INCORRECTING_PASSWORD);
        }
        repository.delete(post);
    }

}
