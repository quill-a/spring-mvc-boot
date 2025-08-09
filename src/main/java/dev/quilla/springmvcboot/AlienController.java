package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @GetMapping("aliens")
    //@ResponseBody  // Can simply annotate the class as being a RestController to avoid having this on every method.
    public List<Alien> getAliens() {

        List<Alien> aliens = repo.findAll();

        return aliens;
    }

    @GetMapping("alien/{id}")
    public Alien getAlien(@PathVariable int id) {

        Alien alien = repo.findById(id).orElse(new Alien(0, ""));

        return alien;
    }

    @PostMapping("alien")
    public Alien addAlien(Alien alien) {

        repo.save(alien);

        return alien;
    }
}
