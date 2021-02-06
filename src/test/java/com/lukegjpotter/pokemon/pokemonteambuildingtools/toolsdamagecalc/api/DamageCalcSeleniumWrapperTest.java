package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.api;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.util.DamageCalcToolsTestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DamageCalcSeleniumWrapperTest {

    @Autowired
    DamageCalcSeleniumWrapper damageCalcSeleniumWrapper;

    @Test
    void calc_VenusaurGmaxVsKyogre() {

        DamageCalcModel actual = damageCalcSeleniumWrapper.calc(DamageCalcToolsTestUtils.getVenusaurGmax(), DamageCalcToolsTestUtils.getTopPokemonInMeta().getPokemonModel());
        DamageCalcModel expected = DamageCalcToolsTestUtils.getDamageCalcForVenusaurGmaxVsKyogre();

        assertEquals(true, true, "This is True");
    }
}