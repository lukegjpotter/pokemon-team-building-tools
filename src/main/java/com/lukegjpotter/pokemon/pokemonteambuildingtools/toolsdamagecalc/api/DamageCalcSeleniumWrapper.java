package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.api;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DamageCalcSeleniumWrapper {

    // todo Add Selenium/Headless here.

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
        String xPathToSetHpIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[2]/td[3]/input/@value";
        String xPathToSetHpEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[2]/td[4]/input/@value";
        String xPathToSetAtkIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[3]/td[3]/input/@value";
        String xPathToSetAtkEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[3]/td[4]/input/@value";
        String xPathToSetDefIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[4]/td[4]/input/@value";
        String xPathToSetDefEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[4]/td[4]/input/@value";
        String xPathToSetSpaIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[5]/td[3]/input/@value";
        String xPathToSetSpaEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[5]/td[4]/input/@value";
        String xPathToSetSpdIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[6]/td[3]/input/@value";
        String xPathToSetSpdEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[6]/td[4]/input/@value";
        String xPathToSetSpeIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[8]/td[3]/input/@value";
        String xPathToSetSpeEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[3]/table/tbody/tr[8]/td[4]/input/@value";
        String xPathToSetNature = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[4]/div[1]/select";
        String xPathToSetMove1 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[6]/div/input";
        String xPathToSetMove2 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[7]/div/input";
        String xPathToSetMove3 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[8]/div/input";
        String xPathToSetMove4 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p1']/div[2]/div[9]/div/input";

        // todo Use Selenium to populate box values.

    }

    private void deployValuesForOpposingPokemon(PokemonModel opposingPokemon) {
        String xPathToSetName = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[2]/div[2]/select/option[1]";
        String xPathToSetHpIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[2]/td[3]/input/@value";
        String xPathToSetHpEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[2]/td[4]/input/@value";
        String xPathToSetAtkIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[3]/td[3]/input/@value";
        String xPathToSetAtkEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[3]/td[4]/input/@value";
        String xPathToSetDefIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[4]/td[4]/input/@value";
        String xPathToSetDefEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[4]/td[4]/input/@value";
        String xPathToSetSpaIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[5]/td[3]/input/@value";
        String xPathToSetSpaEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[5]/td[4]/input/@value";
        String xPathToSetSpdIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[6]/td[3]/input/@value";
        String xPathToSetSpdEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[6]/td[4]/input/@value";
        String xPathToSetSpeIv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[8]/td[3]/input/@value";
        String xPathToSetSpeEv = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[3]/table/tbody/tr[8]/td[4]/input/@value";
        String xPathToSetNature = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[4]/div[1]/select";
        String xPathToSetMove1 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[6]/div/input";
        String xPathToSetMove2 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[7]/div/input";
        String xPathToSetMove3 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[8]/div/input";
        String xPathToSetMove4 = "/html/body/div[@id='outer_wrapper']/div[1]/div[@id='p2']/div[2]/div[9]/div/input";

        // todo Use Selenium to populate box values.

    }

    private List<String> retrievePokemonFromTeamOffensiveCalcs() {
        // XPath to buttons.
        String xPathToClickMove1 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[1]/div/div[2]/div[1]/input";
        String xPathToClickMove2 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[1]/div/div[2]/div[2]/input";
        String xPathToClickMove3 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[1]/div/div[2]/div[3]/input";
        String xPathToClickMove4 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[1]/div/div[2]/div[4]/input";
        // XPath to Result.
        String xPathToReadResult = "/html/body/div[@id='outer_wrapper']/div[1]/div[1]/div[1]/span";

        // Selenium Click buttons and Read Result.


        return Arrays.asList("", "", "", "");
    }

    private List<String> retrievePokemonFromTeamDefensiveCalcs() {
        // XPath to buttons.
        String xPathToClickMove1 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[3]/div/div[2]/div[1]/input";
        String xPathToClickMove2 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[3]/div/div[2]/div[2]/input";
        String xPathToClickMove3 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[3]/div/div[2]/div[3]/input";
        String xPathToClickMove4 = "/html/body/div[@id='outer_wrapper']/div[1]/table/tbody/tr/td[3]/div/div[2]/div[4]/input";
        // XPath to Result.
        String xPathToReadResult = "/html/body/div[@id='outer_wrapper']/div[1]/div[1]/div[1]/span";

        // Selenium Click buttons and Read Result.


        return Arrays.asList("", "", "", "");
    }
}
