package ru.kpfu.itis.genatulin.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.genatulin.entities.Calculation;

@Controller
@RequestMapping(value = "/add")
public class AddController {
    @GetMapping
    @ResponseBody
    public String addValues(@RequestParam Integer a, @RequestParam Integer b) {
        Integer result = a + b;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(new Calculation(a, b, "+", result).getResult());
        } catch (JsonProcessingException e) {
            return "There was a problem with parsing";
        }
    }
}
