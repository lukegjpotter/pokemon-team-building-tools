package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;

import java.util.ArrayList;
import java.util.List;

public class DamageCalcModel {

    private PokemonModel pokemonFromTeam, opposingPokemon;
    private List<String> offensiveCalcs, defensiveCalcs;

    public DamageCalcModel() {
        offensiveCalcs = new ArrayList<>();
        defensiveCalcs = new ArrayList<>();
    }

    public PokemonModel getPokemonFromTeam() {
        return pokemonFromTeam;
    }

    public void setPokemonFromTeam(PokemonModel pokemonFromTeam) {
        this.pokemonFromTeam = pokemonFromTeam;
    }

    public PokemonModel getOpposingPokemon() {
        return opposingPokemon;
    }

    public void setOpposingPokemon(PokemonModel opposingPokemon) {
        this.opposingPokemon = opposingPokemon;
    }

    public List<String> getOffensiveCalcs() {
        return offensiveCalcs;
    }

    public void setOffensiveCalcs(List<String> offensiveCalcs) {
        this.offensiveCalcs = offensiveCalcs;
    }

    public List<String> getDefensiveCalcs() {
        return defensiveCalcs;
    }

    public void setDefensiveCalcs(List<String> defensiveCalcs) {
        this.defensiveCalcs = defensiveCalcs;
    }

    public void addOffensiveCalc(String offensiveCalc) {
        this.offensiveCalcs.add(offensiveCalc);
    }

    public void addDefensiveCalc(String defensiveCalc) {
        this.defensiveCalcs.add(defensiveCalc);
    }
}
