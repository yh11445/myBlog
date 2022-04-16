package com.example.myblog.service;

import com.example.myblog.domain.Posts;
import com.example.myblog.web.dto.PostsModifyRequestDto;
import com.example.myblog.web.dto.PostsResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsServiceTest {

	@Autowired
	PostsService postsService;

	@Test
	public void 게시글_수정하기() {
		// given
		String title = "수정된 제목";
		String content = "수정된 내용";
		Long id = 9L;

		PostsModifyRequestDto dto = new PostsModifyRequestDto(title, content);

		// when
		postsService.modifyPost(id, dto);

		// then
		PostsResponseDto resDto = postsService.getPost(id);
		assertThat(resDto.getTitle()).isEqualTo(title);
		assertThat(resDto.getContent()).isEqualTo(content);
	}

}
