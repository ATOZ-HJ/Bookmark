package com.book.superhero;

import java.util.*;

/**
 * @author: hj
 * @date: 2021-02-25 16:57
 * @description: GameCharacter
 **/
public final class GameCharacter {
    private String name;
    private Set<Power> powers;

    public GameCharacter(String name, int cost, Power... powers) {
        this.name = name;
        this.powers = new HashSet<>(Arrays.asList(powers));
    }

    /**
     * method getName
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * method getPowers
     * @return  powers
     */


    /**
     * method toString
     * @return
     */
    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", powers=" + powers +
                '}';
    }


    public Set<GameCharacter> chooseCharacters(Power... neededPowers) {
        List<Power> powerList = Arrays.asList(neededPowers);
        return null;
    }
}
