package de.kalo.bedwars;

import de.kalo.bedwars.api.TeamAPI;
import de.kalo.bedwars.events.InteractEvents;
import de.kalo.bedwars.events.JoinEvent;
import de.kalo.bedwars.events.QuitEvent;
import de.kalo.bedwars.events.disabled.BreakEvent;
import de.kalo.bedwars.events.disabled.WeatherEvent;
import de.kalo.bedwars.game.manager.GameStateManager;
import de.kalo.bedwars.game.teams.GameTeams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class BedWars extends JavaPlugin {

    private static BedWars instance;
    private GameStateManager gameStateManager;
    private ArrayList<Player> players;
    private TeamAPI teamAPI;
    private ArrayList<String> playerteam;

    @Override
    public void onEnable() {
        instance = this;
        gameStateManager = new GameStateManager(this);
        players = new ArrayList<>();
        teamAPI = new TeamAPI();
        playerteam = new ArrayList<>();
        gameStateManager.setGameState(0);


        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(this), this);
        getServer().getPluginManager().registerEvents(new BreakEvent(this), this);
        getServer().getPluginManager().registerEvents(new InteractEvents(this), this);
        getServer().getPluginManager().registerEvents(new WeatherEvent(), this);

    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static BedWars getInstance() {
        return instance;
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public TeamAPI getTeamAPI() {
        return teamAPI;
    }

    public ArrayList<String> getPlayerteam() {
        return playerteam;
    }
}
