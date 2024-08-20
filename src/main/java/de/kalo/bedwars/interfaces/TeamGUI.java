package de.kalo.bedwars.interfaces;

import de.kalo.bedwars.BedWars;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TeamGUI {

    public void open(Player player, BedWars plugin){
        Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "§8› §cTeam Auswahl");

        ArrayList<String> playerLore1 = new ArrayList<>();
        if(plugin.getTeamAPI().getRed().contains(player.getName())) {
            for(String redS : plugin.getTeamAPI().getRed()) {
                playerLore1.add("§8› §c" + redS);
            }
        }else{
            playerLore1.add("§8› §cNoch niemand");
        }

        ArrayList<String> playerLore2 = new ArrayList<>();
        if(plugin.getTeamAPI().getBlue().contains(player.getName())) {
            for(String blueS : plugin.getTeamAPI().getBlue()) {
                playerLore2.add("§8› §9" + blueS);
            }
        }else{
            playerLore2.add("§8› §cNoch niemand");
        }

        ArrayList<String> playerLore3 = new ArrayList<>();
        if(plugin.getTeamAPI().getYellow().contains(player)) {
            playerLore3.add("§8› §e" + plugin.getTeamAPI().getYellow().equals(player.getName()));
        }else{
            playerLore3.add("§8› §cNoch niemand");
        }

        ArrayList<String> playerLore4 = new ArrayList<>();
        if(plugin.getTeamAPI().getGreen().contains(player)) {
            playerLore4.add("§8› §a" + plugin.getTeamAPI().getGreen().contains(player));
        }else{
            playerLore4.add("§8› §cNoch niemand");
        }

        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(" ");
        glass.setItemMeta(glassMeta);

        ItemStack red = new ItemStack(Material.RED_DYE);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName("§8› §cRot");
        redMeta.setLore(playerLore1);
        red.setItemMeta(redMeta);

        ItemStack blue = new ItemStack(Material.BLUE_DYE);
        ItemMeta blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName("§8› §9Blau");
        blueMeta.setLore(playerLore2);
        blue.setItemMeta(blueMeta);

        ItemStack yellow = new ItemStack(Material.YELLOW_DYE);
        ItemMeta yellowMeta = yellow.getItemMeta();
        yellowMeta.setDisplayName("§8› §eGelb");
        yellowMeta.setLore(playerLore3);
        yellow.setItemMeta(yellowMeta);

        ItemStack green = new ItemStack(Material.LIME_DYE);
        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.setDisplayName("§8› §aGrün");
        greenMeta.setLore(playerLore4);
        green.setItemMeta(greenMeta);

        inventory.setItem(0, glass);
        inventory.setItem(1, glass);
        inventory.setItem(2, glass);
        inventory.setItem(3, glass);
        inventory.setItem(4, glass);
        inventory.setItem(5, glass);
        inventory.setItem(6, glass);
        inventory.setItem(7, glass);
        inventory.setItem(8, glass);
        inventory.setItem(9, glass);
        inventory.setItem(10, red);
        inventory.setItem(11, glass);
        inventory.setItem(12, blue);
        inventory.setItem(13, glass);
        inventory.setItem(14, yellow);
        inventory.setItem(15, glass);
        inventory.setItem(16, green);
        inventory.setItem(17, glass);
        inventory.setItem(18, glass);
        inventory.setItem(19, glass);
        inventory.setItem(20, glass);
        inventory.setItem(21, glass);
        inventory.setItem(22, glass);
        inventory.setItem(23, glass);
        inventory.setItem(24, glass);
        inventory.setItem(25, glass);
        inventory.setItem(26, glass);

        player.openInventory(inventory);
    }
}
