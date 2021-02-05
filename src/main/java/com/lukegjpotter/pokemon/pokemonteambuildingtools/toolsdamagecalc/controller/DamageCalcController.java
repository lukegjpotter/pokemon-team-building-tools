package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.controller;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.service.DamageCalcService;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolspokepaste.controller.PokePasteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/damagecalc")
public class DamageCalcController {

    @Autowired private DamageCalcService damageCalcService;
    @Autowired private PokePasteController pokePasteController;

    /**
     * A Test Method.
     *
     * @return A Blank DamageCalcModel
     */
    @GetMapping("/test")
    public DamageCalcModel getTestDamageCalc() {
        return new DamageCalcModel();
    }

    /**
     *
     * @param pokepasteString
     * @return
     */
    @GetMapping("pokepastestring")
    public DamageCalcModel getDamageCalcForPokePasteString(@RequestBody String pokepasteString) {
        TeamModel team = pokePasteController.getTeamFromPokePasteString(pokepasteString);
        return damageCalcService.getDamageCalcForTeam(team);
    }

    /**
     *
     * @param pokepasteUrlString
     * @return
     */
    @GetMapping("pokepasteurl")
    public DamageCalcModel getDamageCalcForPokePasteUrl(@RequestBody String pokepasteUrlString) {
        TeamModel team = pokePasteController.getTeamFromPokePasteUrl(pokepasteUrlString);
        return damageCalcService.getDamageCalcForTeam(team);
    }
}
