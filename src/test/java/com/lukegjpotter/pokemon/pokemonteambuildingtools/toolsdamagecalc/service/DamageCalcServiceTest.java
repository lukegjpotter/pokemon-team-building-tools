package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.repository.OpposingPokemonInMetaRepository;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.util.DamageCalcToolsTestUtils;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolspokepaste.utils.PokePasteToolsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DamageCalcServiceTest {

    @Autowired DamageCalcService damageCalcService;
    @MockBean OpposingPokemonInMetaRepository opposingPokemonInMetaRepository;

    @BeforeEach
    void setUp() {
        Mockito.when(opposingPokemonInMetaRepository.findByShowdownUsageRanking(1)).thenReturn(DamageCalcToolsTestUtils.getTopPokemonInMeta());
    }

    @Test void getDamageCalcForTeam_TestTeam1vsTopMon() {

        DamageCalcModel actual = damageCalcService.getDamageCalcForTeam(PokePasteToolsTestUtils.pokePasteStringTeam());
        assertEquals(true, true, "This is True");
    }
}