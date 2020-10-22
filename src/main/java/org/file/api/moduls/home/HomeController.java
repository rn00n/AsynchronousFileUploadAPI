package org.file.api.moduls.home;

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

	@GetMapping("/item")
	public String item() {
		return "item";
	}

}
