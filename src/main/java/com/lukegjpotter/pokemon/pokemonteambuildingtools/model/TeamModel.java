package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TeamModel {

    private static final int TEAM_SIZE = 6;

    @Id @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;

    @OneToMany()
    private List<PokemonModel> team;

    public TeamModel() {
        this.team = new ArrayList<>(TEAM_SIZE);
    }

    public TeamModel(List<PokemonModel> team) {
        this.team = new ArrayList<>(TEAM_SIZE);

        for (int i = 0; i < TEAM_SIZE; i++) {
            addPokemonToTeam(team.get(i));
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PokemonModel> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonModel> team) {
        this.team = team;
    }

    public boolean addPokemonToTeam(PokemonModel pokemon) {
        return getTeam().add(pokemon);
    }

    public boolean removePokemonFromTeam(PokemonModel pokemon) {
        return getTeam().remove(pokemon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamModel teamModel = (TeamModel) o;
        return id == teamModel.id && Objects.equals(team, teamModel.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team);
    }
}
