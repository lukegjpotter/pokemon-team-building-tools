package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamModel {

    private static final int TEAM_SIZE = 6;

    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;

    private List<Pokemon> team;

    public TeamModel() {
        this.team = new ArrayList<>(TEAM_SIZE);
    }

    public TeamModel(List<Pokemon> team) {
        this.team = new ArrayList<>(TEAM_SIZE);

        for(int i = 0; i < TEAM_SIZE; i++) {
            addPokemonToTeam(team.get(i));
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public boolean addPokemonToTeam(Pokemon pokemon) {
        return getTeam().add(pokemon);
    }

    public boolean removePokemonFromTeam(Pokemon pokemon){
        return getTeam().remove(pokemon);
    }
}
