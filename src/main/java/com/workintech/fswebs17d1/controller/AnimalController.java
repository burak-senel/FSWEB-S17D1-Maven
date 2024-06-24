package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    private Map<Integer, Animal> animals = new HashMap<>();
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }
    @PostMapping
    public String addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return "Animal added successfully!";
    }
    @PutMapping("/{id}")
    public String updateAnimal(@PathVariable Integer id, @RequestBody Animal newAnimal) {
        if (animals.containsKey(id)) {
            animals.put(id, newAnimal);
            return "Animal updated successfully!";
        } else {
            return "Animal not found!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        if (animals.containsKey(id)) {
            animals.remove(id);
            return "Animal deleted successfully!";
        } else {
            return "Animal not found!";
        }
    }
}
