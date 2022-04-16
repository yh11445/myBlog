package com.example.myblog.service;

import com.example.myblog.domain.Posts;
import com.example.myblog.repository.PostsRepository;
import com.example.myblog.web.dto.PostsResponseDto;
import com.example.myblog.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository repository;

	public Page<Posts> getPosts(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Long savePost(PostsSaveRequestDto dto) {
		return repository.save(dto.toEntity()).getId();
	}

	public PostsResponseDto getPost(Long id) {
		Posts post = repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
		);

		return new PostsResponseDto(post);
	}
}
