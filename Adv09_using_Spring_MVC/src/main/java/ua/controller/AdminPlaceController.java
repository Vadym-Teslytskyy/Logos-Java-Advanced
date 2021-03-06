package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.PlaceService;

@Controller
@RequestMapping("/admin/place")
public class AdminPlaceController {

	private final PlaceService service;

	@Autowired
	public AdminPlaceController(PlaceService service) {
		this.service = service;
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("places", service.findAll());
		return "place";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/place";
	}
}