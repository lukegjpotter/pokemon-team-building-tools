package com.lukegjpotter.pokemon.pokemonteambuildingtools.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.Move;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.StatSpread;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class PokePasteParserService {

    private final String nameItemDividerString = "@", abilityString = "Ability:", levelString = "Level:", evsString = "EVs:", natureString = "Nature", ivsString = "IVs:", movePrefix = "- ";

    public TeamModel parsePokePasteToTeam(String pokePaste) {

        // Loop Variables
        TeamModel teamModel = new TeamModel();
        List<Move> moveset = new ArrayList<>();
        PokemonModel pokemonModel = new PokemonModel();

        String[] linesOfPokePaste = pokePaste.split("\n");

        for (String line : linesOfPokePaste) {
            line = line.trim();

            // Extract Name And Item
            if (line.contains(nameItemDividerString)) {
                int indexEndOfName = line.indexOf(nameItemDividerString);
                pokemonModel.setName(line.substring(0, indexEndOfName).trim());
                pokemonModel.setItem(line.substring(indexEndOfName + nameItemDividerString.length()).trim());
            }

            // Extract Ability
            if (line.startsWith(abilityString)) pokemonModel.setAbility(line.split(":")[1].substring(1));

            // Extract EVs
            if (line.startsWith(evsString))
                pokemonModel.setEvSpread(determineEvSpread(line.substring(evsString.length())));

            // Extract Nature
            if (line.contains(natureString)) pokemonModel.setNature(line.split(" ")[0]);

            // Extract IVs
            if (line.startsWith(ivsString))
                pokemonModel.setIvSpread(determineIvSpread(line.substring(ivsString.length())));

            // Extract Move
            if (line.startsWith(movePrefix)) moveset.add(new Move(line.substring(movePrefix.length())));

            // End Loop, as 4th move has been added.
            if (moveset.size() == 4) {
                pokemonModel.setMoveset(moveset);
                teamModel.addPokemonToTeam(pokemonModel);
                // Reset Loop Variables
                pokemonModel = new PokemonModel();
                moveset = new ArrayList<>();
            }
        }

        return teamModel;
    }

    public TeamModel parsePokePasteUrlToTeam(String pokePasteHtmlSource) {

        Document pokePasteDocument = Jsoup.parse(pokePasteHtmlSource);
        TeamModel teamModel = new TeamModel();

        Elements pokemonElements = pokePasteDocument.getElementsByTag("article");
        for (Element pokemonElement : pokemonElements) {
            PokemonModel pokemonModel = new PokemonModel();

            String fullTextBlock = pokemonElement.getElementsByTag("pre").text();
            int indexEndOfName = fullTextBlock.indexOf(nameItemDividerString);
            int indexEndOfItem = fullTextBlock.indexOf(abilityString);
            int indexEndOfAbility = fullTextBlock.indexOf(levelString);
            int indexEndOfLevel = fullTextBlock.indexOf(evsString);
            int indexEndOfNature = fullTextBlock.indexOf(natureString);
            int indexEndOfIVs = fullTextBlock.indexOf(ivsString); // -1 if not found.

            // Extract Name and Item
            pokemonModel.setName(fullTextBlock.substring(0, indexEndOfName).trim());
            pokemonModel.setItem(fullTextBlock.substring(indexEndOfName + nameItemDividerString.length(), indexEndOfItem).trim());

            // Extract Ability
            pokemonModel.setAbility(fullTextBlock.substring(indexEndOfItem + abilityString.length(), indexEndOfAbility).trim());

            // Extract EVs
            String evSpread = fullTextBlock.substring(indexEndOfLevel + evsString.length(), indexEndOfNature).trim();
            pokemonModel.setEvSpread(determineEvSpread(evSpread));

            // Extract Nature
            String[] evsAndNature = evSpread.split("\n");
            pokemonModel.setNature(evsAndNature[evsAndNature.length - 1]);

            // Extract IVs
            // "IVs:" won't be present if it's a 6IV Pokemon.
            // indexEndOfIVs will be -1 if "IVs:" is not present.
            pokemonModel.setIvSpread(StatSpread.IVSPREAD_FAST_PHYSICAL_ATTACKER());
            if (indexEndOfIVs > 0)
                pokemonModel.mergeIvSpread(determineIvSpread(fullTextBlock.substring(indexEndOfIVs + ivsString.length())));

            // Extract Moves
            List<String> moves = new ArrayList<>(Arrays.asList(fullTextBlock.substring(indexEndOfNature + natureString.length()).split("\n")));
            moves.remove(0); // first element in list is ""
            // Check for IVs, if present remove it.
            if (indexEndOfIVs > 0) moves.remove(0); // new first element in list "Ivs: ..."
            // Remove the "- " at the start of the Moves.
            List<Move> moveset = new ArrayList<>();
            moves.forEach(s -> moveset.add(new Move(s.substring(movePrefix.length()).trim())));
            pokemonModel.setMoveset(moveset);

            teamModel.addPokemonToTeam(pokemonModel);
        }

        return teamModel;
    }

    private StatSpread determineEvSpread(String evString) {

        StringTokenizer evSpreadTokenizer = new StringTokenizer(evString, "/");
        StatSpread evStatSpread = StatSpread.EVSPREAD_BLANK();

        while (evSpreadTokenizer.hasMoreTokens()) {
            String ev = evSpreadTokenizer.nextToken();
            if (ev.contains("HP")) {
                evStatSpread.setHp(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("Atk")) {
                evStatSpread.setAtk(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("Def")) {
                evStatSpread.setDef(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("SpA")) {
                evStatSpread.setSpa(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("SpD")) {
                evStatSpread.setSpd(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("Spe")) {
                evStatSpread.setSpe(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
        }

        return evStatSpread;
    }

    private StatSpread determineIvSpread(String ivString) {

        StringTokenizer ivSpreadTokenizer = new StringTokenizer(ivString, "/");
        StatSpread ivStatSpread = StatSpread.IVSPREAD_FAST_PHYSICAL_ATTACKER();

        while (ivSpreadTokenizer.hasMoreTokens()) {
            String ev = ivSpreadTokenizer.nextToken();
            if (ev.contains("HP")) {
                ivStatSpread.setHp(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("Atk")) {
                ivStatSpread.setAtk(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("Def")) {
                ivStatSpread.setDef(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("SpA")) {
                ivStatSpread.setSpa(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("SpD")) {
                ivStatSpread.setSpd(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
            if (ev.contains("Spe")) {
                ivStatSpread.setSpe(Integer.parseInt(new StringTokenizer(ev, " ").nextToken()));
            }
        }

        return ivStatSpread;
    }
}
