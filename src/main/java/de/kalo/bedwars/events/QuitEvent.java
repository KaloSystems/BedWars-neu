package de.kalo.bedwars.events;

import de.kalo.bedwars.BedWars;
import de.kalo.bedwars.game.countdowns.LobbyCountdown;
import de.kalo.bedwars.game.states.InGameState;
import de.kalo.bedwars.game.states.LobbyState;
import de.kalo.bedwars.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    private BedWars plugin;

    public QuitEvent(BedWars plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event){
        if(plugin.getGameStateManager().getCurrentState() instanceof LobbyState) {
            Player player = event.getPlayer();
            plugin.getPlayers().remove(player);
            event.setQuitMessage(Data.getPrefix() + "§c" + player.getDisplayName() + " §7hat das Spiel verlassen. §8[§3" +
                    plugin.getPlayers().size() + "§8/§b" + LobbyState.MAX_PLAYERS + "§8]");

            LobbyState lobbyState = (LobbyState) plugin.getGameStateManager().getCurrentState();
            LobbyCountdown lobbyCountdown = lobbyState.getLobbyCountdown();

            if (plugin.getPlayers().size() < LobbyState.MIN_PLAYERS) {
                if (lobbyCountdown.isRunning()) {
                    lobbyCountdown.stop();
                    lobbyCountdown.startIdle();
                }
            }
        }

        if(plugin.getGameStateManager().getCurrentState() instanceof InGameState){
            plugin.getPlayers().remove(event.getPlayer());
            if(plugin.getPlayers().size() < LobbyState.MIN_PLAYERS){
                    Bukkit.getServer().reload();
            }
        }
    }
}
