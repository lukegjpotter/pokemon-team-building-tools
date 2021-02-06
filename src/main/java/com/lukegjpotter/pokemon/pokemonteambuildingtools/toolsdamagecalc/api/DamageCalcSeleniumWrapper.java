package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.api;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DamageCalcSeleniumWrapper {

    public DamageCalcModel calc(PokemonModel pokemonFromTeam, PokemonModel opposingPokemon) {
        DamageCalcModel damageCalcModel = new DamageCalcModel();
        damageCalcModel.setPokemonFromTeam(pokemonFromTeam);
        damageCalcModel.setOpposingPokemon(opposingPokemon);

        deployValuesForPokemonFromTeam(pokemonFromTeam);
        deployValuesForOpposingPokemon(opposingPokemon);
        damageCalcModel.setOffensiveCalcs(retrievePokemonFromTeamOffensiveCalcs());
        damageCalcModel.setDefensiveCalcs(retrievePokemonFromTeamDefensiveCalcs());

        return damageCalcModel;
    }

    private void deployValuesForPokemonFromTeam(PokemonModel pokemonFromTeam) {
        String xPathToSetName = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[2]/div[2]/select/option[1]";
    }

    private void deployValuesForOpposingPokemon(PokemonModel opposingPokemon) {
        String xPathToSetName = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[2]/div[2]/select/option[1]";
    }

    private List<String> retrievePokemonFromTeamOffensiveCalcs() {
        return Arrays.asList("", "", "", "");
    }

    private List<String> retrievePokemonFromTeamDefensiveCalcs() {
        return Arrays.asList("", "", "", "");
    }
}
