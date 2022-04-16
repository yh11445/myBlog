package com.example.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping({"/posts", "/"})
	public String postsView() {
		return "posts";
	}
}
