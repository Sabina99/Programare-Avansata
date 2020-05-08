package com.example.lab11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Player class is initially automatically generated with the setters and getters and the override of equals and hashcode
 * Player class also communicates with the database, showing, updating and deleting items from the table players
 */

@Entity
@Table(name = "players", schema = "games")
public class Players {

    private int id;
    private String nume;

    @Autowired
    private PlayerCRUDRep repository;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nume")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return id == players.id &&
                Objects.equals(nume, players.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume);
    }

    /**
     * getAllPlayers shows all the existent in the table players
     *
     * @return
     */
    @GetMapping("/players")
    public List getAllPlayers() {
        return (List) repository.findAll();
    }

    /**
     * delete method deletes a player from the database
     *
     * @param id
     * @return
     */
    @DeleteMapping("/players/{id}")
    public boolean delete(@PathVariable String id){
        int PlayerID = Integer.parseInt(id);
        repository.deleteById(PlayerID);
        return true;
    }

    /**
     * show method shows a specific player, given by his id
     * @param id
     * @return
     */
    @GetMapping("/players/{id}")
    public Optional<Players> show(@PathVariable Integer id){
        return repository.findById(id);
    }

    /**
     *
     * create method creates a new player in the database
     *
     * @param body
     * @return
     */
    @PostMapping("/players")
    public Players create(@RequestBody Map<String, String> body){
        String nume = body.get("nume");
        Players p = new Players();
        p.setNume(nume);
        return repository.save(p);
    }

    /**
     *
     * updateUser updates a player in the database
     *
     * @param body
     * @param id
     * @return
     */
    @PutMapping("/players/{id}")
    public Players updateUser(@RequestBody Map<String, String> body, @PathVariable Integer id) {
        String nume = body.get("nume");
        Players p = new Players();
        p.setNume(nume);
        p.setId(id);
        return repository.save(p);
    }//la ce a

}