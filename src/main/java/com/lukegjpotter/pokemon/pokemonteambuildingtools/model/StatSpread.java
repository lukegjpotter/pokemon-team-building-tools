package com.lukegjpotter.pokemon.pokemonteambuildingtools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StatSpread {

    private static final int IV_MAX = 31, MIN = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private int hp, atk, def, spa, spd, spe;

    public static StatSpread IVSPREAD_FAST_PHYSICAL_ATTACKER() {
        return new StatSpread(IV_MAX, IV_MAX, IV_MAX, IV_MAX, IV_MAX, IV_MAX);
    }

    public static StatSpread IVSPREAD_SLOW_PHYSICAL_ATTACKER() {
        return new StatSpread(IV_MAX, IV_MAX, IV_MAX, IV_MAX, IV_MAX, MIN);
    }

    public static StatSpread IVSPREAD_FAST_SPECIAL_ATTACKER() {
        return new StatSpread(IV_MAX, MIN, IV_MAX, IV_MAX, IV_MAX, IV_MAX);
    }

    public static StatSpread IVSPREAD_SLOW_SPECIAL_ATTACKER() {
        return new StatSpread(IV_MAX, MIN, IV_MAX, IV_MAX, IV_MAX, MIN);
    }

    public static StatSpread EVSPREAD_BLANK() {
        return new StatSpread(MIN, MIN, MIN, MIN, MIN, MIN);
    }

    public StatSpread(int hp, int atk, int def, int spa, int spd, int spe) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spa = spa;
        this.spd = spd;
        this.spe = spe;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatSpread that = (StatSpread) o;
        return id == that.id && hp == that.hp && atk == that.atk && def == that.def && spa == that.spa && spd == that.spd && spe == that.spe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hp, atk, def, spa, spd, spe);
    }
}
