package de.kalo.bedwars.game.countdowns;

import org.bukkit.entity.Player;

public abstract class Countdown {

    protected int taskID;

    public abstract void start(Player player);
    public abstract void stop();
}
