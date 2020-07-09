package com.lukegjpotter.pokemon.pokemonteambuildingtools.controller;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.service.PokePasteParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokepaste")
public class PokePasteController {

    @Autowired private PokePasteParserService pokePasteParserService;

    @GetMapping("{pokepaste}")
    public boolean getTeamFromPokePaste(@PathVariable("pokepaste") String pokepaste) {
        return pokePasteParserService.parsePokePasteToTeam(pokepaste);
    }
}
