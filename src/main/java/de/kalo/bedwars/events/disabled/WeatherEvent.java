package de.kalo.bedwars.events.disabled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener {

    @EventHandler
    public void handleWeather(WeatherChangeEvent event){
        event.setCancelled(true);
    }
}
