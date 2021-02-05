package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PokemonInMetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private PokemonModel pokemonModel;
    private int showdownUsageRanking;

    public PokemonInMetaModel() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PokemonModel getPokemonModel() {
        return pokemonModel;
    }

    public void setPokemonModel(PokemonModel pokemonModel) {
        this.pokemonModel = pokemonModel;
    }

    public int getShowdownUsageRanking() {
        return showdownUsageRanking;
    }

    public void setShowdownUsageRanking(int showdownUsageRanking) {
        this.showdownUsageRanking = showdownUsageRanking;
    }
}
