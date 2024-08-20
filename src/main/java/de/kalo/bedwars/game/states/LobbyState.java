package de.kalo.bedwars.game.states;

import de.kalo.bedwars.game.countdowns.LobbyCountdown;
import de.kalo.bedwars.game.manager.GameStateManager;

public class LobbyState extends GameState {

    public static final int MIN_PLAYERS = 1,
                            MAX_PLAYERS = 4;

    private LobbyCountdown lobbyCountdown;
    public LobbyState(GameStateManager gameStateManager){
        lobbyCountdown = new LobbyCountdown(gameStateManager);
    }

    @Override
    public void start() {
        System.out.println("[BedWars] Lobby State was started.");

        lobbyCountdown.startIdle();
    }

    @Override
    public void stop() {
        System.out.println("[BedWars] Lobby State was changed to Ingame State.");
    }

    public LobbyCountdown getLobbyCountdown() {
        return lobbyCountdown;
    }
}
