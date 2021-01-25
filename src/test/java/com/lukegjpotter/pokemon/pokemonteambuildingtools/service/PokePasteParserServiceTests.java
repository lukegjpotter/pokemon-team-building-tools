package com.lukegjpotter.pokemon.pokemonteambuildingtools.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
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
        TeamModel actual = pokePasteParserService.parsePokePasteToTeam(TestUtils.pokePasteString());
        assertEquals(TestUtils.pokePasteStringTeam(), actual);
    }

    @Test
    void parsePokePasteUrlToTeam_PokePaste1Html() {
        TeamModel actual = pokePasteParserService.parsePokePasteUrlToTeam(TestUtils.pokePaste1HtmlSource());
        assertEquals(TestUtils.pokePaste1HtmlTeam(), actual);
    }
}
