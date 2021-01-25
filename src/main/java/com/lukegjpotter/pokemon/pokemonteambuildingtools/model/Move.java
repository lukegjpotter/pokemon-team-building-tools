package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Move {

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private String name, effect, detailedEffect;
    private int damage, accuracy, secondaryEffectChance;

    public Move(String name, String effect, String detailedEffect, int damage, int accuracy, int secondaryEffectChance) {
        this.name = name;
        this.effect = effect;
        this.detailedEffect = detailedEffect;
        this.damage = damage;
        this.accuracy = accuracy;
        this.secondaryEffectChance = secondaryEffectChance;
    }

    public Move(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
