package com.example.demo.domain.post;

import com.example.demo.domain.post.Dto.PostRequestDto;
import com.example.demo.domain.post.Dto.PostResponseDto;
import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @PostMapping("/posts")
    public ResponseEntity<?> createPosts(@RequestBody PostRequestDto.PostDto postDto) {
        Long id = service.createPosts(postDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/posts")
    public ResponseEntity<?> readPosts() {
        PostResponseDto.PostListDto readPosts = service.readPosts();
        return ResponseEntity.ok(readPosts);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> readPost(@PathVariable Long postId) {
        PostResponseDto.PostDto postDto = service.readPost(postId);
        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId, @RequestBody PostRequestDto.PostDeleteDto postDeleteDto) {
        service.deletePost(postId, postDeleteDto);
        return ResponseEntity.ok("삭제에 성공하였습니다.");
    }
}
