package de.kalo.bedwars.utils;

public class Data {

    private static String prefix = "§b§lBedWars §8| §7";
    private static String noperms = prefix + "§cKeine Rechte§8!";

    public static String getNoPerms() {
        return noperms;
    }

    public static String getPrefix() {
        return prefix;
    }
}
