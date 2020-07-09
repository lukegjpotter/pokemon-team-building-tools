package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Pokemon {

    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;

    private String name, item, ability, nature, gender;
    private StatSpread evSpread, ivSpread;
    private List<Move> moveset;

    public Pokemon(String name, String item, String ability, String nature, String gender, StatSpread evSpread, StatSpread ivSpread, List<Move> moveset) {
        this.name = name;
        this.item = item;
        this.ability = ability;
        this.nature = nature;
        this.gender = gender;
        this.evSpread = evSpread;
        this.ivSpread = ivSpread;
        this.moveset = moveset;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StatSpread getEvSpread() {
        return evSpread;
    }

    public void setEvSpread(StatSpread evSpread) {
        this.evSpread = evSpread;
    }

    public StatSpread getIvSpread() {
        return ivSpread;
    }

    public void setIvSpread(StatSpread ivSpread) {
        this.ivSpread = ivSpread;
    }

    public List<Move> getMoveset() {
        return moveset;
    }

    public void setMoveset(List<Move> moveset) {
        this.moveset = moveset;
    }

    public boolean addMoveToMoveset(Move move) {
        return this.getMoveset().add(move);
    }

    public boolean removeMoveFromMoveset(Move move) {
        return this.getMoveset().remove(move);
    }
}
