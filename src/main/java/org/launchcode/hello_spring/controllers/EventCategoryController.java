package org.launchcode.hello_spring.controllers;

import jakarta.validation.Valid;
import org.launchcode.hello_spring.data.EventCategoryRepository;
import org.launchcode.hello_spring.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("eventcategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventcategories/index";
    }

    @GetMapping("create")
    public String displayCreateCategoryForm(Model model) {
        model.addAttribute("title", "Create New Category");
        model.addAttribute(new EventCategory());
        return "eventcategories/create";
    }

    @PostMapping("create")
    public String processCreateCategoryForm(@ModelAttribute @Valid EventCategory newCategory, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create New Category");
            return "eventcategories/create";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:/eventcategories";
    }
}