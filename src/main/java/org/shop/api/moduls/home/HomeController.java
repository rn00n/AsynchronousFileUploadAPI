package org.shop.api.moduls.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/board")
	public String board() {
		return "board";
	}

	@GetMapping("/image")
	public String image() {
		return "image";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
}
