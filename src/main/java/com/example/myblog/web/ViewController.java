package com.example.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

	@GetMapping({"/posts", "/"})
	public String postsView() {
		return "posts";
	}

	@GetMapping("/posts/write")
	public String postsWrite() {
		return "postsWrite";
	}

	@GetMapping("/posts/{id}")
	public String post(@PathVariable Long id) {
		return "post";
	}
}
