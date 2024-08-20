package de.kalo.bedwars.events;

import de.kalo.bedwars.BedWars;
import de.kalo.bedwars.interfaces.TeamGUI;
import de.kalo.bedwars.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvents implements Listener {

    private BedWars plugin;

    public InteractEvents(BedWars plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void handlepinteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(event.getAction() != null){

            if(event.getItem() != null){

                if(event.getItem().getItemMeta().getDisplayName().equals("§8› §cTeam Auswahl")){
                    new TeamGUI().open(player, plugin);
                }
            }else{
                return;
            }

        }else{
            return;
        }
    }

    @EventHandler
    public void handleInv(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equals("§8› §cTeam Auswahl")){
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§8› §cRot")){
                if(!plugin.getTeamAPI().getRed().contains(player.getName())) {
                    if(plugin.getTeamAPI().getRed().size() != 1) {
                        plugin.getTeamAPI().setRed(player);
                        player.sendMessage(Data.getPrefix() + "§7Du bist nun im §cRoten §7Team drin§8.");
                        new TeamGUI().open(player, plugin);
                    }else{
                        player.sendMessage(Data.getPrefix() + "§cDas Team ist schon voll§8!");
                    }
                }else{
                    player.sendMessage(Data.getPrefix() + "Du bist schon im §cRoten §7Team drinnen§8!");
                }
            }else if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§8› §9Blau")){
                if(!plugin.getTeamAPI().getBlue().contains(player.getName())) {
                    if(plugin.getTeamAPI().getBlue().size() != 1) {
                            plugin.getTeamAPI().setBlue(player);
                            player.sendMessage(Data.getPrefix() + "§7Du bist nun im §9Blauen §7Team drin§8.");
                            new TeamGUI().open(player, plugin);
                    }else{
                        player.sendMessage(Data.getPrefix() + "§cDas Team ist schon voll§8!");
                    }
                }else if(!plugin.getTeamAPI().getRed().contains(player.getName()) ||
                        plugin.getTeamAPI().getYellow().contains(player.getName()) || plugin.getTeamAPI()
                        .getGreen().contains(player.getName())) {
                    if(plugin.getTeamAPI().getRed().size() != 1) {
                        plugin.getTeamAPI().setBlue(player);
                        plugin.getTeamAPI().removeGreen(player);
                        plugin.getTeamAPI().removeYellow(player);
                        plugin.getTeamAPI().getRed().remove(player);
                        player.sendMessage(Data.getPrefix() + "§7Du bist nun im §9Blauen §7Team drin§8.");
                        new TeamGUI().open(player, plugin);
                    }else{
                        player.sendMessage(Data.getPrefix() + "§cDas Team ist schon voll§8!");
                    }
                }else{
                    player.sendMessage(Data.getPrefix() + "Du bist schon im §9Blauen §7Team drinnen§8!");
                }
            }
        }
    }
}
