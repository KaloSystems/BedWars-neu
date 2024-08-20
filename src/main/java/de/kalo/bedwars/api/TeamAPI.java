package de.kalo.bedwars.api;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeamAPI {

    private ArrayList<String> red = new ArrayList<>();
    private ArrayList<String> blue = new ArrayList<>();
    private ArrayList<String> yellow = new ArrayList<>();
    private ArrayList<String> green = new ArrayList<>();

    public ArrayList<String> getRed() {
        return red;
    }

    public ArrayList<String> getBlue() {
        return blue;
    }

    public ArrayList<String> getYellow() {
        return yellow;
    }

    public ArrayList<String> getGreen() {
        return green;
    }

    public boolean setBlue(Player player) {
        return blue.add(player.getName());
    }
    public boolean setRed(Player player) {
        return red.add(player.getName());
    }
    public boolean setYellow(Player player) {
        return yellow.add(player.getName());
    }

    public boolean setGreen(Player player) {
        return yellow.add(player.getName());
    }

    public boolean removeRed(Player player){
        return red.remove(player.getName());
    }
    public boolean removeBlue(Player player){
        return blue.remove(player.getName());
    }
    public boolean removeYellow(Player player){
        return yellow.remove(player.getName());
    }
    public boolean removeGreen(Player player){
        return green.remove(player.getName());
    }
}
