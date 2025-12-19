package ntch.scythePlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ScytheItem {

    public static ItemStack createScytheItem(ScythePlugin plugin){
        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Reaper Scythe");
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "custom_item"), PersistentDataType.STRING, "reaper_scythe");
        meta.addEnchant(Enchantment.UNBREAKING,5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        AttributeModifier damageModifier = new AttributeModifier(new NamespacedKey(plugin, "generic.attack_damage"), 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        AttributeModifier speedModifier = new AttributeModifier(new NamespacedKey(plugin, "generic.attack_speed"), -3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speedModifier);

        item.setItemMeta(meta);

        return item;
    }
}
