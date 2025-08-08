package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    Object getAlienById(int id);

    List<Alien> findByName(String name);
}
