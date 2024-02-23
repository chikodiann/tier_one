package com.mtb.tier_one;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FormDataController {
    private final FormDataRepository formDataRepository;

    public FormDataController(FormDataRepository formDataRepository) {
        this.formDataRepository = formDataRepository;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formData", new FormData());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute FormData formData) {
        formDataRepository.save(formData);
        return "redirect:/form/success";
    }

    @GetMapping("/form/success")
    public String showSuccessPage() {
        return "success";
    }

}

