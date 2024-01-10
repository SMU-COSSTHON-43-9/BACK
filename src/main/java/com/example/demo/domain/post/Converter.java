package com.example.demo.domain.post;

import com.example.demo.domain.post.Dto.PostRequestDto;
import com.example.demo.domain.post.Dto.PostResponseDto;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Post toPost (PostRequestDto.PostRDto postRDto){
        return Post.builder()
                .title(postRDto.getTitle())
                .content(postRDto.getContent())
                .name(postRDto.getName())
                .password(postRDto.getPassword())
                .build();
    }
    public static PostResponseDto.PostDto toPostDto(Post post) {
        return PostResponseDto.PostDto.builder()
                .name(post.getName())
                .content(post.getContent())
                .title(post.getTitle())
                .name(post.getName())
                .build();
    }

    public static PostResponseDto.PostListDto toPostListDto(List<Post> post) {
        List<PostResponseDto.PostDto> postList = new ArrayList<>();
        for(Post p : post) {
            postList.add(toPostDto(p));
        }


        return PostResponseDto.PostListDto.builder()
                .count(postList.size())
                .Posts(postList)
                .build();
    }

}

