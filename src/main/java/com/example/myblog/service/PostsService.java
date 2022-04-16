package com.example.myblog.service;

import com.example.myblog.domain.Posts;
import com.example.myblog.repository.PostsRepository;
import com.example.myblog.web.dto.PostsModifyRequestDto;
import com.example.myblog.web.dto.PostsResponseDto;
import com.example.myblog.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository repository;

	public Page<Posts> getPosts(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public Long savePost(PostsSaveRequestDto dto) {
		return repository.save(dto.toEntity()).getId();
	}

	@Transactional
	public Long modifyPost(Long id, PostsModifyRequestDto dto) {
		Posts post = repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

		post.update(dto.getTitle(), dto.getContent());

		return id;
	}

	public PostsResponseDto getPost(Long id) {
		Posts post = repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
		);

		return new PostsResponseDto(post);
	}

	public void deletePost(Long id) {
		Posts post = repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
		);

		repository.delete(post);
	}
}
