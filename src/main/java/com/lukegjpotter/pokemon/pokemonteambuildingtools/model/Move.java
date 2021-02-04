package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Move {" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return id == move.id && damage == move.damage && accuracy == move.accuracy && secondaryEffectChance == move.secondaryEffectChance && Objects.equals(name, move.name) && Objects.equals(effect, move.effect) && Objects.equals(detailedEffect, move.detailedEffect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, effect, detailedEffect, damage, accuracy, secondaryEffectChance);
    }
}
