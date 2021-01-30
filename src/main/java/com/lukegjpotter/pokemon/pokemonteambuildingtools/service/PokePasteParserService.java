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
            String nameItemDividerString = "@", abilityString = "Ability:", levelString = "Level:", evsString = "EVs:", natureString = "Nature";
            int indexEndOfName = fullTextBlock.indexOf(nameItemDividerString);
            int indexEndOfItem = fullTextBlock.indexOf(abilityString);
            int indexEndOfAbility = fullTextBlock.indexOf(levelString);
            int indexEndOfLevel = fullTextBlock.indexOf(evsString);
            int indexEndOfNature = fullTextBlock.indexOf(natureString);

            // Extract Name and Item
            String name = fullTextBlock.substring(0, indexEndOfName).trim();
            String item = fullTextBlock.substring(indexEndOfName + nameItemDividerString.length(), indexEndOfItem).trim();
            pokemonModel.setName(name);
            pokemonModel.setItem(item);

            // Extract Ability
            String ability = fullTextBlock.substring(indexEndOfItem + abilityString.length(), indexEndOfAbility).trim();
            pokemonModel.setAbility(ability);

            // Extract EVs
            String evSpread = fullTextBlock.substring(indexEndOfLevel + evsString.length(), indexEndOfNature);
            StringTokenizer evSpreadTokenizer = new StringTokenizer(evSpread, "/");
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
            pokemonModel.setEvSpread(evStatSpread);


            teamModel.addPokemonToTeam(pokemonModel);
        }

        return teamModel;
    }
}
