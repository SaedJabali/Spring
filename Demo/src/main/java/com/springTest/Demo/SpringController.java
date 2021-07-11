package com.springTest.Demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpringController {
    @GetMapping("/")
    public String host() {
        return "landing";
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello-World";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase());
        return "Captialize";
    }

//        @ResponseBody
    @GetMapping("/albums")
    public String album(Model model) {
        Album album1 = new Album("25", "Adele", "11", "48 min 25 sec", "https://media.kidozi.com/unsafe/600x600/img.kidozi.com/art/3/600/600/0a0909/6422/1476073135-Adele25.png.jpg");
        Album album2 = new Album("Deluxe", "Ed Sheeran", "16", "59 min 33 sec", "https://www.londondrugs.com/on/demandware.static/-/Sites-londondrugs-master/default/dw9454fa74/products/L7502537/large/L7502537.JPG");
        Album album3 = new Album("24k Magic", "Bruno Mars", "9", "33 min 32 sec", "https://i1.sndcdn.com/artworks-000509638275-sam717-t500x500.jpg");
        Object[] albums = new Object[]{album1, album2, album3};
        model.addAttribute("albums", albums);
        return "albums";
    }

}