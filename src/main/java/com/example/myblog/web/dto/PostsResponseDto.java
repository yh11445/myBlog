package com.example.myblog.web.dto;

import com.example.myblog.domain.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;

	public PostsResponseDto(Posts post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.author = post.getAuthor();
	}
}
