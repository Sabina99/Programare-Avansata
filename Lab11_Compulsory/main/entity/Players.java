package main.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Player class with the setters and getters and the override of equals and hashcode
 */
@Entity
public class Players {

    private int id;
    private String nume;

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
        Players player = (Players) o;
        return id == player.id &&
                Objects.equals(nume, player.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume);
    }
}
