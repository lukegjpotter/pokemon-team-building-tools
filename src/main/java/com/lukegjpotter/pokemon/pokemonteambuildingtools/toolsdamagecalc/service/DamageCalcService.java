package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.api.DamageCalcSeleniumWrapper;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.repository.OpposingPokemonInMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DamageCalcService {

    @Autowired
    private OpposingPokemonInMetaRepository opposingPokemonInMetaRepository;
    @Autowired
    private DamageCalcSeleniumWrapper damageCalcSeleniumWrapper;

    public List<DamageCalcModel> getDamageCalcForTeam(TeamModel team) {

        PokemonModel opposingPokemon = opposingPokemonInMetaRepository.findByShowdownUsageRanking(1).getPokemonModel();
        List<DamageCalcModel> damageCalcList = new ArrayList<>();

        team.getTeam().forEach(pokemonModel -> damageCalcList.add(getDamageCalcForPokemon(pokemonModel, opposingPokemon)));

        return damageCalcList;
    }

    public DamageCalcModel getDamageCalcForPokemon(PokemonModel pokemonFromTeam, PokemonModel opposingPokemon) {
        return damageCalcSeleniumWrapper.calc(pokemonFromTeam, opposingPokemon);
    }
}
