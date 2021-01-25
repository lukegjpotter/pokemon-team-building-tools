package com.lukegjpotter.pokemon.pokemonteambuildingtools.controller.utils;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RemoteConnectionUtils {

    public String getPokePasteUrlHtmlSource(String pokepasteUrlString) {
        try {
            return Jsoup.connect(pokepasteUrlString).get().outerHtml();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
