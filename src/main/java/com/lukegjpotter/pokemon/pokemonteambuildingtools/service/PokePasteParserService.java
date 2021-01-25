package com.lukegjpotter.pokemon.pokemonteambuildingtools.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

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
            int indexEndOfName = fullTextBlock.indexOf("@");
            int indexEndOfItem = fullTextBlock.indexOf("Ability:");
            int indexEndOfAbility = fullTextBlock.indexOf("Level:");

            // Extract Name and Item
            String name = fullTextBlock.substring(0, indexEndOfName).trim();
            String item = fullTextBlock.substring(indexEndOfName + 1, indexEndOfItem).trim();
            pokemonModel.setName(name);
            pokemonModel.setItem(item);

            // Extract Ability
            String ability = fullTextBlock.substring(indexEndOfItem + 1, indexEndOfAbility).trim();
            pokemonModel.setAbility(ability);

            teamModel.addPokemonToTeam(pokemonModel);
        }

        return teamModel;
    }
}
