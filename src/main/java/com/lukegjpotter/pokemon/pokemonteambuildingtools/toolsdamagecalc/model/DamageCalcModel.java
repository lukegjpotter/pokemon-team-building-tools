package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DamageCalcModel that = (DamageCalcModel) o;
        return Objects.equals(pokemonFromTeam, that.pokemonFromTeam) && Objects.equals(opposingPokemon, that.opposingPokemon) && Objects.equals(offensiveCalcs, that.offensiveCalcs) && Objects.equals(defensiveCalcs, that.defensiveCalcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonFromTeam, opposingPokemon, offensiveCalcs, defensiveCalcs);
    }
}
