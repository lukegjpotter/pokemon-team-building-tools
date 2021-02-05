package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.util;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.Move;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.StatSpread;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.PokemonInMetaModel;
import org.springframework.stereotype.Component;

@Component
public class DamageCalcToolsTestUtils {

    public static PokemonInMetaModel getTopPokemonInMeta() {

        PokemonModel kyogre = new PokemonModel();
        kyogre.setName("Kyogre");
        kyogre.setItem("Mystic Water");
        kyogre.setAbility("Drizzle");
        kyogre.setNature("Timid");
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
}
