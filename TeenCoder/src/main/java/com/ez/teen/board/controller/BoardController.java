package com.ez.teen.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("main")
	public String main() {
		return "main";
	}
}
