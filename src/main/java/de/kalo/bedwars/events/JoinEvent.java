package de.kalo.bedwars.events;

import de.kalo.bedwars.BedWars;
import de.kalo.bedwars.game.countdowns.LobbyCountdown;
import de.kalo.bedwars.game.states.LobbyState;
import de.kalo.bedwars.utils.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class JoinEvent implements Listener {

    private BedWars plugin;

    public JoinEvent(BedWars plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(!(plugin.getGameStateManager().getCurrentState() instanceof LobbyState)) return;
        plugin.getPlayers().add(player);
        event.setJoinMessage(Data.getPrefix() + "Der Spieler §3" + player.getDisplayName() + " §7ist dem Spiel beigetreten§8! §8[§3" +
                plugin.getPlayers().size() + "§8/§b" + LobbyState.MAX_PLAYERS + "§8]");

        ArrayList<String> perks = new ArrayList<>();
        perks.add("§7");
        perks.add("§7Kaufe dir hier mit deinen Coins §3§lPerks");
        perks.add("§7um einen leichten Vorteil gegenüber anderen zu haben§8!");
        perks.add("§7");

        ArrayList<String> team = new ArrayList<>();
        team.add("§7");
        team.add("§7In welches §bTeam§7 möchtest du gehen?");
        team.add("§7Wähle dir hier dein §bTeam §7aus§8.");
        team.add("§7");

        ArrayList<String> bookLore = new ArrayList<>();
        bookLore.add("§7");
        bookLore.add("§7Hier bekommst du Hilfe!");
        bookLore.add("§7So das du verstehst wie dieser Modus funktioniert.");
        bookLore.add("§7");

        ItemStack hopper = new ItemStack(Material.HOPPER);
        ItemMeta hopperMeta = hopper.getItemMeta();
        hopperMeta.setDisplayName("§8› §3Perks");
        hopperMeta.setLore(perks);
        hopper.setItemMeta(hopperMeta);

        ItemStack stand = new ItemStack(Material.ARMOR_STAND);
        ItemMeta standMeta = stand.getItemMeta();
        standMeta.setDisplayName("§8› §cTeam Auswahl");
        standMeta.setLore(team);
        stand.setItemMeta(standMeta);

        ItemStack book = new ItemStack(Material.BOOK);
        ItemMeta bookMeta = book.getItemMeta();
        bookMeta.setDisplayName("§8› §3Infos zu Bedwars");
        bookMeta.setLore(bookLore);
        book.setItemMeta(bookMeta);

        player.getInventory().setItem(2, hopper);
        player.getInventory().setItem(4, stand);
        player.getInventory().setItem(6, book);

        LobbyState lobbyState = (LobbyState) plugin.getGameStateManager().getCurrentState();
        LobbyCountdown lobbyCountdown = lobbyState.getLobbyCountdown();
        if(plugin.getPlayers().size() >= LobbyState.MIN_PLAYERS){
               if(!lobbyCountdown.isRunning()){
                   lobbyCountdown.stopIdle();
                   lobbyCountdown.start(player);
               }
        }
    }
}
