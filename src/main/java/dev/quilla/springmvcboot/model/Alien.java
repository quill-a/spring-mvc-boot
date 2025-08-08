package dev.quilla.springmvcboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aliens")
public class Alien {

    @Id
    private int id;
    private String name;

    public Alien() {

    }

    public Alien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alien{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
