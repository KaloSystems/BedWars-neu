package de.kalo.bedwars.game.states;

import de.kalo.bedwars.utils.Data;
import org.bukkit.Bukkit;

public class InGameState extends GameState {

    @Override
    public void start() {
        Bukkit.broadcastMessage(Data.getPrefix() + "Das Spiel beginnt!");
    }

    @Override
    public void stop() {

    }
}
