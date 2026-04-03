package com.example.myapp;

import com.example.myapp.board.model.Board;
import com.example.myapp.board.model.BoardCategory;
import com.example.myapp.board.service.IBoardCategoryService;
import com.example.myapp.board.service.IBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	IBoardCategoryService categoryService;
	@Autowired
	IBoardService boardService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Welcome");

		List<BoardCategory> categoryList = categoryService.selectAllCategory();
		model.addAttribute("categoryList", categoryList);

		return "home";
	}
}
