package com.lukegjpotter.pokemon.pokemonteambuildingtools.controller;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.controller.utils.RemoteConnectionUtils;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.service.PokePasteParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * A Test Method.
     *
     * @return A Blank Test Team
     */
    @GetMapping("/test")
    public TeamModel getTestTeam() {
        return new TeamModel();
    }

    /**
     * To get a Team from a PokePaste Text String.
     *
     * @param pokepasteString Body Raw Text format. e.g. Charizard-Gmax @ Focus Sash \\n Ability: Solar Power
     * @return A TeamModel derived from the Paste in the Body.
     */
    @GetMapping("/string")
    public TeamModel getTeamFromPokePasteString(@RequestBody String pokepasteString) {
        return pokePasteParserService.parsePokePasteToTeam(pokepasteString);
    }

    /**
     * To get a Team from a PokePaste URL.
     *
     * @param pokepasteUrlString Body Raw Text format. e.g. https://pokepast.es/7773fa9f6619a549
     * @return A TeamModel derived from the PokePasteURL in the Body.
     */
    @GetMapping("/url")
    public TeamModel getTeamFromPokePasteUrl(@RequestBody String pokepasteUrlString) {
        String pokepasteHtmlSource = remoteConnectionUtils.getPokePasteUrlHtmlSource(pokepasteUrlString);
        return pokePasteParserService.parsePokePasteUrlToTeam(pokepasteHtmlSource);
    }
}
