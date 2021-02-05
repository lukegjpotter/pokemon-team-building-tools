package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolspokepaste.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolspokepaste.utils.PokePasteToolsTestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PokePasteParserServiceTests {

    @Autowired
    PokePasteParserService pokePasteParserService;

    @Test
    void parsePokePasteToTeam_String() {
        TeamModel actual = pokePasteParserService.parsePokePasteToTeam(PokePasteToolsTestUtils.pokePasteString());
        assertEquals(PokePasteToolsTestUtils.pokePasteStringTeam().getTeam().size(), actual.getTeam().size(), "Comparing Team Size");

        for (int i = 0; i < actual.getTeam().size(); i++) {
            assertEquals(PokePasteToolsTestUtils.pokePasteStringTeam().getTeam().get(i), actual.getTeam().get(i), "Pokemon at position " + i);
        }
    }

    @Test
    void parsePokePasteUrlToTeam_PokePaste1Html() {
        TeamModel actual = pokePasteParserService.parsePokePasteUrlToTeam(PokePasteToolsTestUtils.pokePaste1HtmlSource());
        assertEquals(PokePasteToolsTestUtils.pokePaste1HtmlTeam().getTeam().size(), actual.getTeam().size(), "Comparing Team Size");

        for (int i = 0; i < actual.getTeam().size(); i++) {
            assertEquals(PokePasteToolsTestUtils.pokePaste1HtmlTeam().getTeam().get(i), actual.getTeam().get(i), "Pokemon at position " + i);
        }
    }
}
