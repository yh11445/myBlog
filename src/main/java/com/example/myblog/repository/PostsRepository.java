package com.example.myblog.repository;

import com.example.myblog.domain.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
	Page<Posts> findAll(Pageable pageable);
}
