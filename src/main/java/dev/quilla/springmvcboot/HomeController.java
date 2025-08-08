package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlienRepo repo;

    @ModelAttribute
    public void modelData(Model model) {

        model.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model) {

        model.addAttribute("result", repo.findAll());

        return "showAliens";
    }

    // Dynamically change what gets passed to the results page by using the ModelAttribute annotation in the method
    // definition, rather than manually adding the attribute to the model within the method body.
    @PostMapping(value = "addAlien")
    public String addAlien(@ModelAttribute("alien1") Alien alien) {

        return "result";
    }
}
