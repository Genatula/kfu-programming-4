package ru.kpfu.itis.genatulin.hw4_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.genatulin.hw4_2.models.Group;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/group")
public class GroupController {

    @GetMapping
    public String getForm(ModelMap modelMap) {
        Group group = new Group(new String[]{});
        modelMap.put("group", group);
        return "group";
    }

    @PostMapping
    public String sendForm(
            RedirectAttributes attributes,
            @Valid @ModelAttribute("group") Group group,
            BindingResult result,
            ModelMap modelMap
    ) {
        if (result.hasErrors()) {
            return "group";
        }
        else {
            return "redirect:index";
        }
    }
}
