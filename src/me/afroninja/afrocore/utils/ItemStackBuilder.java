package me.afroninja.afrocore.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemStackBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemStackBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemStackBuilder amount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder setName(String displayName) {
        this.itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemStackBuilder color(int hex) {
        if (this.itemMeta instanceof LeatherArmorMeta) {
            ((LeatherArmorMeta)this.itemMeta).setColor(Color.fromRGB(hex));
        }

        return this;
    }

    public ItemStackBuilder addLore(String... strings) {
        List<String> loreArray = new ArrayList();
        String[] var6 = strings;
        int var5 = strings.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            String loreBit = var6[var4];
            loreArray.add(ChatColor.WHITE + loreBit);
        }

        this.itemMeta.setLore(loreArray);
        return this;
    }

    public ItemStackBuilder addLore(List<String> strings) {
        List<String> loreArray = new ArrayList();
        Iterator var4 = strings.iterator();

        while(var4.hasNext()) {
            String loreBit = (String)var4.next();
            loreArray.add(ChatColor.translateAlternateColorCodes('&', loreBit));
        }

        this.itemMeta.setLore(loreArray);
        return this;
    }

    public ItemStackBuilder enchant(Enchantment enchanement, int level, boolean ignoreLevelRestriction) {
        this.itemMeta.addEnchant(enchanement, level, ignoreLevelRestriction);
        return this;
    }

    public ItemStackBuilder durability(int durability) {
        this.itemStack.setDurability((short)durability);
        return this;
    }

    public ItemStack build() {
        ItemStack clonedStack = this.itemStack.clone();
        clonedStack.setItemMeta(this.itemMeta.clone());
        return clonedStack;
    }
}
