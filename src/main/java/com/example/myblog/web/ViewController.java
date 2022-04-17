package com.example.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String post(Model model, @PathVariable Long id) {
		model.addAttribute("id", id);
		return "post";
	}

	@GetMapping("/posts/modify/{id}")
	public String postModify(Model model, @PathVariable Long id) {
		model.addAttribute("id", id);
		return "postsModify";
	}
}
