package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.service;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.PokemonModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.model.TeamModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.DamageCalcModel;
import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.repository.OpposingPokemonInMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DamageCalcService {

    @Autowired private OpposingPokemonInMetaRepository opposingPokemonInMetaRepository;

    public DamageCalcModel getDamageCalcForTeam(TeamModel team) {

        PokemonModel opposingPokemon = opposingPokemonInMetaRepository.findByShowdownUsageRanking(1).getPokemonModel();
        DamageCalcModel damageCalcModel = new DamageCalcModel();

        return damageCalcModel;
    }
}
