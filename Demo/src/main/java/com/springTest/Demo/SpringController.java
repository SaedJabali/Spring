package com.springTest.Demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpringController {
//    @GetMapping("/")
//    public String host() {
//        return "landing";
//    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello-World";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase());
        return "Captialize";
    }

}