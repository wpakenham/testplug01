package me.pakenham.testplug01;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


public final class Testplug01 extends JavaPlugin implements Listener {

    private final int BedRadius = 300;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block placedBlock = event.getBlock();
        if (event.getBlock().getType() == Material.RESPAWN_ANCHOR) {
            // Perform explosion logic here
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
        }
        if (placedBlock.getType() == Material.WHITE_BED || placedBlock.getType() == Material.LIGHT_GRAY_BED || placedBlock.getType() == Material.GRAY_BED || placedBlock.getType() == Material.BLACK_BED ||
            placedBlock.getType() == Material.BROWN_BED || placedBlock.getType() == Material.RED_BED || placedBlock.getType() == Material.ORANGE_BED || placedBlock.getType() == Material.YELLOW_BED ||
            placedBlock.getType() == Material.LIME_BED || placedBlock.getType() == Material.GREEN_BED || placedBlock.getType() == Material.CYAN_BED || placedBlock.getType() == Material.LIGHT_BLUE_BED ||
            placedBlock.getType() == Material.BLUE_BED || placedBlock.getType() == Material.PURPLE_BED || placedBlock.getType() == Material.MAGENTA_BED || placedBlock.getType() == Material.PINK_BED
                && Math.sqrt(Math.abs(placedBlock.getLocation().getBlockX())^2 + Math.abs(placedBlock.getLocation().getBlockZ()) ^2) > BedRadius) {
            player.sendMessage(Component.text("Hello!" + Math.sqrt(Math.abs(placedBlock.getLocation().getBlockX())^2 + Math.abs(placedBlock.getLocation().getBlockZ()) ^2)));

            // Cancel the block placement
            event.setCancelled(true);

            // Remove the placed block
            placedBlock.setType(Material.AIR);
        }
    }
        @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
