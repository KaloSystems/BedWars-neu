package de.kalo.bedwars.game.manager;

import de.kalo.bedwars.BedWars;
import de.kalo.bedwars.game.teams.GameTeams;

public class TeamManager {

    private BedWars plugin;
    private GameTeams gameTeam;

    public TeamManager(BedWars plugin){
        this.plugin = plugin;
    }

    public void setTeam(GameTeams gameTeam){
        this.gameTeam = gameTeam;

    }

    public GameTeams getGameTeam() {
        return gameTeam;
    }
}
