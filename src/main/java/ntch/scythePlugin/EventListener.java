package ntch.scythePlugin;

import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class EventListener implements Listener {
    private final ScythePlugin plugin;
    private final Random random = new Random();

    public EventListener(ScythePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnDamageEvent(EntityDamageByEntityEvent ev){
        if(ev.getDamager() instanceof Player player) {
            LivingEntity target = (LivingEntity) ev.getEntity();
            if(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "custom_item"), PersistentDataType.STRING).equalsIgnoreCase("reaper_scythe")){
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLACK, 1.5F);
                target.getWorld().spawnParticle(Particle.DUST, target.getLocation().add(0,1,0), 20, dustOptions);
                if(random.nextDouble() < 0.03){
                    target.getWorld().spawnParticle(Particle.DUST, target.getLocation().add(0,1,0), 20, new Particle.DustOptions(Color.RED, 2F));
                    target.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,2 * 60,2, true, true,true));
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,2 * 60,5,true,true,true));
                }
            }
        }
    }
}
