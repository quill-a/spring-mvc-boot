package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    Object getAlienById(int id);

//    List<Alien> findByName(String name);  // Query DSL

    // Uses HQL.
    // References the Spring Entity (the class 'Alien' in this case), not the database/table.
    // Good for complex queries that would make the implicit method names in this interface too long.
    @Query("from Alien where name= :alienName")
    List<Alien> find(@Param("alienName") String name);
}
