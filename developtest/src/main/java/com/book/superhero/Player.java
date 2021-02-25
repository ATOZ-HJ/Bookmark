package com.book.superhero;

import java.util.List;

/**
 * @author: hj
 * @date: 2021-02-25 17:22
 * @description:
 **/
public class Player {
    private List<GameCharacter> gameCharacter;


    public Player(List<GameCharacter> gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public List<GameCharacter> getGameCharacter() {
        return gameCharacter;
    }

    /**
     * add character
     * @param gameCharacter
     */
    public void addCharacter(GameCharacter gameCharacter) {
        this.gameCharacter.add(gameCharacter);
    }
}
