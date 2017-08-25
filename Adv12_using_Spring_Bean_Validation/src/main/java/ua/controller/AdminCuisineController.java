package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CuisineRequest;
import ua.service.CuisineService;

@Controller
@RequestMapping("/admin/cuisine")
@SessionAttributes("cuisine")
public class AdminCuisineController {

	private final CuisineService service;

	@Autowired
	public AdminCuisineController(CuisineService service) {
		this.service = service;
	}

	@ModelAttribute("cuisine")
	public CuisineRequest getForm() {
		return new CuisineRequest();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("cuisines", service.findAllView());
		return "cuisine";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/cuisine";
	}

	@PostMapping
	public String save(@ModelAttribute("cuisine") CuisineRequest request, SessionStatus status) {
		service.save(request);
		return "redirect:/admin/cuisine";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("cuisine", service.findOneRequest(id));
		return show(model);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/cuisine";
	}
}