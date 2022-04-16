package com.example.myblog.repository;

import com.example.myblog.domain.Posts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@Test
	public void 게시글_저장_불러오기() {
		// given
		String title = "제목";
		String content = "내용";
		String author = "작성자";

		Posts post = Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();

		postsRepository.save(post);

		// when
		List<Posts> posts = postsRepository.findAll();

		// then
		Posts post2 = posts.get(0);
		assertThat(post2.getTitle()).isEqualTo(title);
		assertThat(post2.getContent()).isEqualTo(content);
		assertThat(post2.getAuthor()).isEqualTo(author);
	}
}
