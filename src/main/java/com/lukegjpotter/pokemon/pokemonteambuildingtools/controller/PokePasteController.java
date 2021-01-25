package com.lukegjpotter.pokemon.pokemonteambuildingtools.controller;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.controller.utils.RemoteConnectionUtils;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.service.PokePasteParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokepaste")
public class PokePasteController {

    @Autowired
    private PokePasteParserService pokePasteParserService;
    @Autowired
    private RemoteConnectionUtils remoteConnectionUtils;

    /**
     * To get a Team from a PokePaste Text String.
     *
     * @param pokepasteString
     * @return
     */
    @GetMapping("{pokepaste}")
    public TeamModel getTeamFromPokePasteString(@PathVariable("pokepasteString") String pokepasteString) {
        return pokePasteParserService.parsePokePasteToTeam(pokepasteString);
    }

    /**
     * To get a Team from a PokePaste URL.
     *
     * @param pokepasteUrlString
     * @return
     */
    @GetMapping("{pokepasteurl}")
    public TeamModel getTeamFromPokePasteUrl(@PathVariable("pokepasteUrlString") String pokepasteUrlString) {
        String pokepasteHtmlSource = remoteConnectionUtils.getPokePasteUrlHtmlSource(pokepasteUrlString);
        return pokePasteParserService.parsePokePasteUrlToTeam(pokepasteHtmlSource);
    }
}
