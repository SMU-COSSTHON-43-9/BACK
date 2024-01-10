package com.example.demo.domain.post;

import com.example.demo.domain.post.Dto.PostRequestDto;
import com.example.demo.domain.post.Dto.PostResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "취미 게시판", description = "취미 게시판 컨트롤러 입니다.")
public class Controller {

    private final Service service;

    @Operation(summary = "취미 게시판 작성", description = "취미 게시판 작성")
    @ApiResponse(responseCode = "200", description = "취미 게시판 작성 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
    })
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @PostMapping("/posts")
    public ResponseEntity<?> createPosts(@Valid @RequestBody PostRequestDto.PostRDto postRDto) {
        Long id = service.createPosts(postRDto);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "취미 게시판 전체 조회", description = "취미 게시판 전체 조회")
    @ApiResponse(responseCode = "200", description = "취미 게시판 전체 조회 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = PostResponseDto.PostListDto.class))
    })
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @GetMapping("/posts")
    public ResponseEntity<?> readPosts() {
        PostResponseDto.PostListDto readPosts = service.readPosts();
        return ResponseEntity.ok(readPosts);
    }

    @Operation(summary = "취미 게시판 조회", description = "취미 게시판 전체 조회")
    @ApiResponse(responseCode = "200", description = "취미 게시판 조회 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = PostResponseDto.PostDto.class))
    })
    @ApiResponse(responseCode = "403", description = "존재하지 않는 post입니다.")
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> readPost(@PathVariable Long postId) {
        PostResponseDto.PostDto postDto = service.readPost(postId);
        return ResponseEntity.ok(postDto);
    }

    @Operation(summary = "취미 게시판 삭제", description = "취미 게시판 삭제")
    @ApiResponse(responseCode = "200", description = "취미 게시판 삭제 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    })
    @ApiResponse(responseCode = "403", description = "존재하지 않는 post입니다.")
    @ApiResponse(responseCode = "403", description = "비밀번호가 다릅니다.")
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId, @Valid @RequestBody PostRequestDto.PostDeleteDto postDeleteDto) {
        service.deletePost(postId, postDeleteDto);
        return ResponseEntity.ok("삭제에 성공하였습니다.");
    }
}
