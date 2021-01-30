package com.lukegjpotter.pokemon.pokemonteambuildingtools.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.Move;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.StatSpread;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
class TestUtils {

    public static String pokePasteString() {
        return "Charizard-Gmax @ Focus Sash  \n" +
                "Ability: Solar Power  \n" +
                "Level: 50  \n" +
                "EVs: 4 HP / 252 SpA / 252 Spe  \n" +
                "Timid Nature  \n" +
                "IVs: 0 Atk  \n" +
                "- Protect  \n" +
                "- Heat Wave  \n" +
                "- Air Slash  \n" +
                "- Solar Beam  \n" +
                "\n" +
                "Venusaur-Gmax @ Life Orb  \n" +
                "Ability: Chlorophyll  \n" +
                "Level: 50  \n" +
                "EVs: 4 HP / 4 Def / 244 SpA / 4 SpD / 252 Spe  \n" +
                "Timid Nature  \n" +
                "IVs: 0 Atk  \n" +
                "- Sleep Powder  \n" +
                "- Leaf Storm  \n" +
                "- Sludge Bomb  \n" +
                "- Earth Power  \n" +
                "\n" +
                "Torkoal @ Sitrus Berry  \n" +
                "Ability: Drought  \n" +
                "Level: 50  \n" +
                "EVs: 188 HP / 196 SpA / 124 SpD  \n" +
                "Quiet Nature  \n" +
                "IVs: 0 Atk / 0 Spe  \n" +
                "- Protect  \n" +
                "- Heat Wave  \n" +
                "- Will-O-Wisp  \n" +
                "- Yawn  \n" +
                "\n" +
                "Indeedee-F @ Psychic Seed  \n" +
                "Ability: Psychic Surge  \n" +
                "Level: 50  \n" +
                "EVs: 244 HP / 228 Def / 36 SpD  \n" +
                "Sassy Nature  \n" +
                "IVs: 0 Atk / 0 Spe  \n" +
                "- Protect  \n" +
                "- Follow Me  \n" +
                "- Expanding Force  \n" +
                "- Dazzling Gleam  \n" +
                "\n" +
                "Glastrier @ Weakness Policy  \n" +
                "Ability: Chilling Neigh  \n" +
                "Level: 50  \n" +
                "EVs: 252 HP / 252 Atk / 4 SpD  \n" +
                "Brave Nature  \n" +
                "IVs: 0 Spe  \n" +
                "- Protect  \n" +
                "- Icicle Crash  \n" +
                "- Smart Strike  \n" +
                "- High Horsepower  \n" +
                "\n" +
                "Dusclops @ Eviolite  \n" +
                "Ability: Frisk  \n" +
                "Level: 50  \n" +
                "EVs: 252 HP / 68 Def / 188 SpD  \n" +
                "Impish Nature  \n" +
                "IVs: 0 Spe  \n" +
                "- Helping Hand  \n" +
                "- Brick Break  \n" +
                "- Trick Room  \n" +
                "- Haze  \n";
    }

    public static TeamModel pokePasteStringTeam() {
        TeamModel teamModel = new TeamModel();

        PokemonModel charizardGmax = new PokemonModel();
        charizardGmax.setName("Charizard-Gmax");
        charizardGmax.setItem("Focus Sash");
        charizardGmax.setAbility("Solar Power");
        charizardGmax.setNature("Timid");
        charizardGmax.setGender("");
        charizardGmax.setEvSpread(new StatSpread(4, 0, 0, 252, 0, 252));
        charizardGmax.setIvSpread(StatSpread.IVSPREAD_FAST_SPECIAL_ATTACKER());
        charizardGmax.addMoveToMoveset(new Move("Protect"));
        charizardGmax.addMoveToMoveset(new Move("Heat Wave"));
        charizardGmax.addMoveToMoveset(new Move("Air Slash"));
        charizardGmax.addMoveToMoveset(new Move("Solar Beam"));
        teamModel.addPokemonToTeam(charizardGmax);

        PokemonModel venusaurGmax = new PokemonModel();
        venusaurGmax.setName("Venusaur-Gmax");
        venusaurGmax.setItem("Life Orb");
        venusaurGmax.setAbility("Chlorophyll");
        venusaurGmax.setNature("Timid");
        venusaurGmax.setGender("");
        venusaurGmax.setEvSpread(new StatSpread(4, 0, 4, 244, 4, 252));
        venusaurGmax.setIvSpread(StatSpread.IVSPREAD_FAST_SPECIAL_ATTACKER());
        venusaurGmax.addMoveToMoveset(new Move("Sleep Powder"));
        venusaurGmax.addMoveToMoveset(new Move("Leaf Storm"));
        venusaurGmax.addMoveToMoveset(new Move("Sludge Bomb"));
        venusaurGmax.addMoveToMoveset(new Move("Earth Power"));
        teamModel.addPokemonToTeam(venusaurGmax);

        return teamModel;
    }

    public static String pokePaste1HtmlSource() {
        try {
            return Files.readString(Path.of("src/test/resources/PokePaste1.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static TeamModel pokePaste1HtmlTeam() {
        // TODO Implement This if HTML switches from being the same team as the PokePasteString
        return pokePasteStringTeam();
    }

}
