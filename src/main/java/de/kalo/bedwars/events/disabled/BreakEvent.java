package de.kalo.bedwars.events.disabled;

import de.kalo.bedwars.BedWars;
import de.kalo.bedwars.game.manager.GameStateManager;
import de.kalo.bedwars.game.states.GameState;
import de.kalo.bedwars.game.states.InGameState;
import de.kalo.bedwars.game.states.LobbyState;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {

    private BedWars plugin;

    public BreakEvent(BedWars plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();

        if(plugin.getGameStateManager().getCurrentState() instanceof LobbyState){
            event.setCancelled(true);
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§c⚠ §7Du kannst diesen Block nicht abbauen§8!"));
        }else if(plugin.getGameStateManager().getCurrentState() instanceof InGameState){
            if(!(event.getBlock().getType() != Material.SANDSTONE)) {
                event.setCancelled(false);
            }else{
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§c⚠ §7Du kannst diesen Block nicht abbauen§8!"));
                event.setCancelled(true);
            }
        }
    }
}
