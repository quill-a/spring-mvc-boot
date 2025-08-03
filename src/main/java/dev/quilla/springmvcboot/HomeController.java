package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
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

        // Return a short list of "aliens" for prototyping purposes.
        List<Alien> aliens = Arrays.asList(new Alien(111, "David"), new Alien(222, "Julia"));
        model.addAttribute("result", aliens);
        
        return "showAliens";
    }

    // Dynamically change what gets passed to the results page by using the ModelAttribute annotation in the method
    // definition, rather than manually adding the attribute to the model within the method body.
    @PostMapping(value = "addAlien")
    public String addAlien(@ModelAttribute("alien1") Alien alien) {

        return "result";
    }
}
