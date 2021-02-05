package com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.repository;

import com.lukegjpotter.pokemon.pokemonteambuildingtools.toolsdamagecalc.model.PokemonInMetaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpposingPokemonInMetaRepository extends CrudRepository<PokemonInMetaModel, Long> {

    PokemonInMetaModel findByShowdownUsageRanking(int showdownUsageRanking);
}
