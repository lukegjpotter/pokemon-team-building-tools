package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.api.DamageCalcSeleniumWrapper;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.repository.OpposingPokemonInMetaRepository;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.util.DamageCalcToolsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DamageCalcServiceTest {

    @Autowired
    DamageCalcService damageCalcService;
    @MockBean
    OpposingPokemonInMetaRepository mockOpposingPokemonInMetaRepository;
    @MockBean
    DamageCalcSeleniumWrapper mockDamageCalcSeleniumWrapper;

    @BeforeEach
    void setUp() {
        Mockito.when(mockOpposingPokemonInMetaRepository.findByShowdownUsageRanking(Mockito.any(Integer.class)))
                .thenReturn(DamageCalcToolsTestUtils.getTopPokemonInMeta());
        Mockito.when(mockDamageCalcSeleniumWrapper.calc(Mockito.any(PokemonModel.class), Mockito.any(PokemonModel.class)))
                .thenReturn(DamageCalcToolsTestUtils.getDamageCalcForVenusaurGmaxVsKyogre());
    }

    @Test
    void getDamageCalcForTeam_TestTeam1vsTopMon() {

        TeamModel team = new TeamModel();
        team.setTeam(Arrays.asList(DamageCalcToolsTestUtils.getVenusaurGmax()));
        List<DamageCalcModel> actual = damageCalcService.getDamageCalcForTeam(team);
        List<DamageCalcModel> expected = Arrays.asList(DamageCalcToolsTestUtils.getDamageCalcForVenusaurGmaxVsKyogre());

        assertEquals(expected, actual, "Team Damage Calc Failing");
    }

    @Test
    void getDamageCalcForPokemon_VenusaurGmaxVsTopMon() {

        DamageCalcModel actual = damageCalcService.getDamageCalcForPokemon(
                DamageCalcToolsTestUtils.getVenusaurGmax(),
                DamageCalcToolsTestUtils.getTopPokemonInMeta().getPokemonModel());
        DamageCalcModel expected = DamageCalcToolsTestUtils.getDamageCalcForVenusaurGmaxVsKyogre();

        assertEquals(expected, actual, "Single Damage Calc Failing");
    }
}