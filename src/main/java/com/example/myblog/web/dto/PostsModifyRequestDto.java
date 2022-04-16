package com.example.myblog.web.dto;

import com.example.myblog.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsModifyRequestDto {
	private String title;
	private String content;

	@Builder
	public PostsModifyRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
