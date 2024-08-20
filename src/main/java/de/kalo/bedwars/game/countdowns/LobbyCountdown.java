package de.kalo.bedwars.game.countdowns;

import de.kalo.bedwars.game.states.GameState;
import de.kalo.bedwars.game.manager.GameStateManager;
import de.kalo.bedwars.game.states.LobbyState;
import de.kalo.bedwars.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LobbyCountdown extends Countdown{

    private static int COUNTDOWN_TIME = 60, IDLE_COUNT = 30;

    private GameStateManager gameStateManager;
    private int idleID;
    private int seconds;
    private boolean isIdling;
    private boolean isRunning;

    public LobbyCountdown(GameStateManager gameStateManager){
        this.gameStateManager = gameStateManager;
        seconds = COUNTDOWN_TIME;
    }

    @Override
    public void start(Player player) {
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(gameStateManager.getPlugin(), new Runnable() {
            @Override
            public void run() {
                switch(seconds){
                    case 60: case 45: case 30: case 15: case 10: case 5: case 4: case 3: case 2: case 1:
                        Bukkit.broadcastMessage(Data.getPrefix() + "Das Spiel startet in §b" + seconds + "§7 Sekunden...");
                        break;
                    case 0:
                        Bukkit.broadcastMessage(Data.getPrefix() + "Das Spiel startet nun!");
                        player.getInventory().clear();
                        player.setLevel(0);
                        stop();
                        gameStateManager.setGameState(GameState.INGAME);
                        break;
                    default:
                        break;
                }
                seconds--;

                player.setLevel(seconds);
            }
        }, 0, 20);


    }

    @Override
    public void stop() {
        if(isRunning){
            Bukkit.getScheduler().cancelTask(taskID);
            isRunning = false;
            seconds = COUNTDOWN_TIME;
        }
    }

    public void startIdle(){
        isIdling = true;
        idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(gameStateManager.getPlugin(), new Runnable() {
            @Override
            public void run() {

                Bukkit.broadcastMessage(Data.getPrefix() + "Es fehlen noch §3" + (LobbyState.MIN_PLAYERS - gameStateManager.getPlugin().getPlayers().size())
            + "§7 Spieler§8.");

            }
        }, 0, 20 * IDLE_COUNT);
    }

    public void stopIdle(){
        if(isIdling){
            Bukkit.getScheduler().cancelTask(idleID);
            isIdling = false;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}
