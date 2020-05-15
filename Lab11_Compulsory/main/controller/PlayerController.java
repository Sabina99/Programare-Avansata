package main.controller;

import main.entity.Players;
import main.repo.PlayerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * PlayerController class communicates with the database, showing, updating and deleting items from the table players
 */

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepo repository;

    @GetMapping("/players")
    public List getAllPlayers() {
        return (List) repository.findAll();
    }

    @GetMapping("/players/{id}")
    public Optional<Players> show(@PathVariable Integer id){
        return repository.findById(id);
    }

    @PostMapping("/players")
    public Players create(@RequestBody Map<String, String> body){
        String nume = body.get("nume");
        Players p = new Players();
        p.setNume(nume);
        return repository.save(p);
    }

    @PutMapping("/players/{id}")
    public Players updateUser(@RequestBody Map<String, String> body, @PathVariable Integer id) {
        String nume = body.get("nume");

        Players p = new Players();
        p.setNume(nume);
        p.setId(id);
        return repository.save(p);
    }

    @DeleteMapping("/players/{id}")
    public boolean delete(@PathVariable String id){
        int PlayerID = Integer.parseInt(id);
        repository.deleteById(PlayerID);
        return true;
    }
}
