package com.lukegjpotter.pokemon.pokemonteambuildingtools.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.StatSpread;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.StringTokenizer;

@Service
public class PokePasteParserService {

    public TeamModel parsePokePasteToTeam(String pokePaste) {
        // TODO Implement This.
        return new TeamModel();
    }

    public TeamModel parsePokePasteUrlToTeam(String pokePasteHtmlSource) {

        Document pokePasteDocument = Jsoup.parse(pokePasteHtmlSource);
        TeamModel teamModel = new TeamModel();

        Elements pokemonElements = pokePasteDocument.getElementsByTag("article");
        for (Element pokemonElement : pokemonElements) {
            PokemonModel pokemonModel = new PokemonModel();

            String fullTextBlock = pokemonElement.getElementsByTag("pre").text();
            String nameItemDividerString = "@", abilityString = "Ability:", levelString = "Level:", evsString = "EVs:", natureString = "Nature", ivsString = "IVs:";
            int indexEndOfName = fullTextBlock.indexOf(nameItemDividerString);
            int indexEndOfItem = fullTextBlock.indexOf(abilityString);
            int indexEndOfAbility = fullTextBlock.indexOf(levelString);
            int indexEndOfLevel = fullTextBlock.indexOf(evsString);
            int indexEndOfNature = fullTextBlock.indexOf(natureString);
            int indexEndOfIVs = fullTextBlock.indexOf(ivsString); // -1 if not found.

            // Extract Name and Item
            String name = fullTextBlock.substring(0, indexEndOfName).trim();
            String item = fullTextBlock.substring(indexEndOfName + nameItemDividerString.length(), indexEndOfItem).trim();
            pokemonModel.setName(name);
            pokemonModel.setItem(item);

            // Extract Ability
            String ability = fullTextBlock.substring(indexEndOfItem + abilityString.length(), indexEndOfAbility).trim();
            pokemonModel.setAbility(ability);

            // Extract EVs
            String evSpread = fullTextBlock.substring(indexEndOfLevel + evsString.length(), indexEndOfNature).trim();
            pokemonModel.setEvSpread(determineEvSpread(evSpread));

            // Extract Nature
            String[] evsAndNature = evSpread.split("\n");
            String nature = evsAndNature[evsAndNature.length - 1];
            pokemonModel.setNature(nature);

            // Extract IVs
            // "IVs:" won't be present if it's a 6IV Pokemon.
            // indexEndOfIVs will be -1 if "IVs:" is not present.
            pokemonModel.setIvSpread(StatSpread.IVSPREAD_FAST_PHYSICAL_ATTACKER());
            if (indexEndOfIVs > 0) {
                String ivSpread = fullTextBlock.substring(indexEndOfIVs + ivsString.length());
                StatSpread ivs = determineIvSpread(ivSpread);
                pokemonModel.mergeIvSpread(ivs);
            }

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
