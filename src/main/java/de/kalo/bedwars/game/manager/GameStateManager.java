package de.kalo.bedwars.game.manager;

import de.kalo.bedwars.BedWars;
import de.kalo.bedwars.game.states.GameState;
import de.kalo.bedwars.game.states.EndingState;
import de.kalo.bedwars.game.states.InGameState;
import de.kalo.bedwars.game.states.LobbyState;

public class GameStateManager {

    private BedWars plugin;
    private GameState[] gameStates;
    private GameState currentState;

    public GameStateManager(BedWars plugin){
        this.plugin = plugin;
        gameStates = new GameState[3];

        gameStates[GameState.LOBBY] = new LobbyState(this);
        gameStates[GameState.INGAME] = new InGameState();
        gameStates[GameState.ENDING] = new EndingState();
    }

    public void setGameState(int gameStateID){
        if(currentState != null)
            currentState.stop();
        currentState = gameStates[gameStateID];
        currentState.start();
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void stopCurrentState(){
        if(currentState != null){
            currentState.stop();
            currentState = null;
        }
    }

    public BedWars getPlugin() {
        return plugin;
    }
}
