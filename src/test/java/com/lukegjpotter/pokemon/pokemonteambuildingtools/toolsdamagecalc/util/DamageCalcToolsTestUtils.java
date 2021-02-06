package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.util;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.Move;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.StatSpread;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.PokemonInMetaModel;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DamageCalcToolsTestUtils {

    public static PokemonInMetaModel getTopPokemonInMeta() {

        PokemonModel kyogre = new PokemonModel();
        kyogre.setName("Kyogre");
        kyogre.setItem("Mystic Water");
        kyogre.setAbility("Drizzle");
        kyogre.setNature("Modest");
        kyogre.setEvSpread(new StatSpread(4, 0, 0, 252, 0, 252));
        kyogre.setIvSpread(StatSpread.IVSPREAD_FAST_SPECIAL_ATTACKER());
        kyogre.addMoveToMoveset(new Move("Protect"));
        kyogre.addMoveToMoveset(new Move("Water Spout"));
        kyogre.addMoveToMoveset(new Move("Origin Pulse"));
        kyogre.addMoveToMoveset(new Move("Thunder"));

        PokemonInMetaModel pokemonInMetaModel = new PokemonInMetaModel();
        pokemonInMetaModel.setPokemonModel(kyogre);
        pokemonInMetaModel.setShowdownUsageRanking(1);

        return pokemonInMetaModel;
    }

    public static PokemonModel getVenusaurGmax() {

        PokemonModel venusaurGmax = new PokemonModel();
        venusaurGmax.setName("Venusaur-Gmax");
        venusaurGmax.setItem("Life Orb");
        venusaurGmax.setAbility("Chlorophyll");
        venusaurGmax.setNature("Timid");
        venusaurGmax.setEvSpread(new StatSpread(4, 0, 4, 244, 4, 252));
        venusaurGmax.setIvSpread(StatSpread.IVSPREAD_FAST_SPECIAL_ATTACKER());
        venusaurGmax.addMoveToMoveset(new Move("Sleep Powder"));
        venusaurGmax.addMoveToMoveset(new Move("Leaf Storm"));
        venusaurGmax.addMoveToMoveset(new Move("Sludge Bomb"));
        venusaurGmax.addMoveToMoveset(new Move("Earth Power"));

        return venusaurGmax;
    }

    public static DamageCalcModel getDamageCalcForVenusaurGmaxVsKyogre() {

        DamageCalcModel venusaurGmaxVsKyogreDamagaCalc = new DamageCalcModel();
        venusaurGmaxVsKyogreDamagaCalc.setPokemonFromTeam(getVenusaurGmax());
        venusaurGmaxVsKyogreDamagaCalc.setOpposingPokemon(getTopPokemonInMeta().getPokemonModel());
        venusaurGmaxVsKyogreDamagaCalc.setOffensiveCalcs(Arrays.asList(
                "Venusaur-Gmax (No Move) vs. Kyogre: 0 (0%) - 0 (0%)",
                "244 SpA Life Orb Venusaur-Gmax Leaf Storm vs. 4 HP / 0 SpD Kyogre: 179-213 (101.7 - 121%) -- guaranteed OHKO",
                "244 SpA Life Orb Venusaur-Gmax Sludge Bomb vs. 4 HP / 0 SpD Kyogre: 64-75 (36.3 - 42.6%) -- guaranteed 3HKO",
                "244 SpA Life Orb Venusaur-Gmax Earth Power vs. 4 HP / 0 SpD Kyogre: 43-51 (24.4 - 28.9%) -- 97.6% chance to 4HKO"));
        venusaurGmaxVsKyogreDamagaCalc.setDefensiveCalcs(Arrays.asList(
                "Kyogre (No Move) vs. Venusaur-Gmax: 0 (0%) - 0 (0%)",
                "252+ SpA Mystic Water Kyogre Water Spout (150 BP) vs. 4 HP / 4 SpD Venusaur-Gmax in Rain: 105-123 (67.3 - 78.8%) -- guaranteed 2HKO",
                "252+ SpA Mystic Water Kyogre Origin Pulse vs. 4 HP / 4 SpD Venusaur-Gmax in Rain: 76-90 (48.7 - 57.6%) -- 97.3% chance to 2HKO",
                "252+ SpA Kyogre Thunder vs. 4 HP / 4 SpD Venusaur-Gmax: 38-45 (24.3 - 28.8%) -- 99% chance to 4HKO"));

        return venusaurGmaxVsKyogreDamagaCalc;
    }
}
