package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatSpread {

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private static final int MAX = 31, MIN = 0;
    private int hp, atk, def, spa, spd, spe;

    public StatSpread(int hp, int atk, int def, int spa, int spd, int spe) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spa = spa;
        this.spd = spd;
        this.spe = spe;
    }

    public StatSpread fastPhysicalAttacker() {
        return new StatSpread(MAX, MAX, MAX, MAX, MAX, MAX);
    }

    public StatSpread slowPhysicalAttacker() {
        return new StatSpread(MAX, MAX, MAX, MAX, MAX, MIN);
    }

    public StatSpread fastSpecialAttacker() {
        return new StatSpread(MAX, MIN, MAX, MAX, MAX, MAX);
    }

    public StatSpread slowSpecialAttacker() {
        return new StatSpread(MAX, MIN, MAX, MAX, MAX, MIN);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpa() {
        return spa;
    }

    public void setSpa(int spa) {
        this.spa = spa;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getSpe() {
        return spe;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }
}
