package ntch.scythePlugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScythePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerItemRecipe();
        getCommand("givescythe").setExecutor(this);
        getServer().getPluginManager().registerEvents(new EventListener(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerItemRecipe(){
        ItemStack customItem = ScytheItem.createScytheItem(this);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "reaper_scythe"), customItem);

        recipe.shape(
                "NNW",
                " S ",
                "S  "
        );
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        recipe.setIngredient('S', Material.STICK);

        this.getServer().addRecipe(recipe);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("givescythe")){
            if(sender instanceof Player player){
                ItemStack customItem = ScytheItem.createScytheItem(this);
                player.getInventory().addItem(customItem);
                player.sendMessage("Success");
                return true;
            }
        }
        return false;
    }
}
