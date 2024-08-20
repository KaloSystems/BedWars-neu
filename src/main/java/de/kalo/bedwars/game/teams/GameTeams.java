package de.kalo.bedwars.game.teams;

public abstract class GameTeams {

    private static final String BLUE = "BLAU",
                                RED = "ROT",
                                YELLOW = "GELB",
                                GREEN = "GRÜN";
    public abstract void add();
    public abstract void remove();

    public static String getBLUE() {
        return BLUE;
    }

    public static String getGREEN() {
        return GREEN;
    }

    public static String getRED() {
        return RED;
    }

    public static String getYELLOW() {
        return YELLOW;
    }
}
