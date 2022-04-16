package com.example.myblog.web;

import com.example.myblog.service.PostsService;
import com.example.myblog.web.dto.PostsResponseDto;
import com.example.myblog.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

	private final PostsService postsService;

	@PostMapping("/api/v1/post")
	public Long savePost(@RequestBody PostsSaveRequestDto dto) {
		return postsService.savePost(dto);
	}

	@GetMapping("/api/v1/post/{id}")
	public PostsResponseDto getPost(@PathVariable Long id) {
		return postsService.getPost(id);
	}
}
