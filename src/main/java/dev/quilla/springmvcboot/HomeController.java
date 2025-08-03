package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @ModelAttribute
    public void modelData(Model model) {

        model.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    

    @PostMapping(value = "addAlien")
    public String addAlien(@ModelAttribute("alien1") Alien alien) {

        return "result";
    }
}
