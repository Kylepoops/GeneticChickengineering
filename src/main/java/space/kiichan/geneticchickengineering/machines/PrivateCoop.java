package space.kiichan.geneticchickengineering.machines;

import io.github.thebusybiscuit.cscorelib2.inventory.InvUtils;
import io.github.thebusybiscuit.cscorelib2.inventory.ItemUtils;
import io.github.thebusybiscuit.cscorelib2.item.CustomItem;
import java.util.LinkedList;
import java.util.List;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import space.kiichan.geneticchickengineering.GeneticChickengineering;
import space.kiichan.geneticchickengineering.chickens.PocketChicken;
import space.kiichan.geneticchickengineering.items.GCEItems;

public class PrivateCoop extends AContainer {
    private GeneticChickengineering plugin;
    private final PocketChicken pc;

    public PrivateCoop(GeneticChickengineering plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.plugin = plugin;
        this.pc = plugin.pocketChicken;
    }

    @Override
    public ItemStack getProgressBar() {
        return GCEItems.POCKET_CHICKEN;
    }

    @Override
    public String getMachineIdentifier() {
        return "GCE_PRIVATE_COOP";
    }

    @Override
    protected void tick(Block b) {
        super.tick(b);
        if (getMachineProcessor().getOperation(b) != null) {
            if (Math.random() < 0.25) {
                Location l = b.getLocation().toCenterLocation();
                l.getWorld().spawnParticle(Particle.HEART, l.add(0,0.5,0), 2, 0.2, 0, 0.2);
            }
            BlockMenu inv = BlockStorage.getInventory(b);
            // Check if parent chickens have been removed
            if (this.getParents(inv).size() != 2) {
                getMachineProcessor().endOperation(b);
                inv.replaceExistingItem(22, new CustomItem(Material.BLACK_STAINED_GLASS_PANE, " "));
            }
        }
    }

    private List<ItemStack> getParents(BlockMenu inv) {
        List<ItemStack> parents = new LinkedList<ItemStack>();
        for (int slot : getInputSlots()) {
            ItemStack parent = inv.getItemInSlot(slot);
            if (parent == null) {
                // since this machine only works with two parents
                // and this method is used to check for two chickens, 
                // we just return the list here since it won't have
                // a length of two anyway, saving some time
                return parents;
            }
            if (this.pc.isPocketChicken(parent)) {
                if (this.pc.isAdult(parent)) {
                    parents.add(parent);
                }
            }
        }
        return parents;
    }

    @Override
    protected MachineRecipe findNextRecipe(BlockMenu inv) {
        List<ItemStack> parents = this.getParents(inv);
        if (parents.size() == 2) {
            ItemStack baby = this.pc.breed(parents.get(0), parents.get(1));
            if (baby == null) {
                // Shouldn't ever be here, just in case
                return null;
            }
            MachineRecipe recipe = new MachineRecipe(60, new ItemStack[] { parents.get(0), parents.get(1) }, new ItemStack[] {baby});

            Inventory invi = inv.toInventory();
            invi.setMaxStackSize(1);
            if (!InvUtils.fitAll(invi, recipe.getOutput(), getOutputSlots())) {
                return null;
            }

            if (this.plugin.painEnabled()) {
                for (ItemStack parent: parents) {
                    if (!this.plugin.survivesPain(parent) && !this.plugin.deathEnabled()) {
                        return null;
                    }
                    this.plugin.possiblyHarm(parent);
                    if (this.pc.getHealth(parent) == 0d) {
                        ItemUtils.consumeItem(parent, false);
                        inv.getBlock().getWorld().playSound(inv.getLocation(), Sound.ENTITY_CHICKEN_DEATH, 1f, 1f);
                        return null;
                    }
                }
            }

            return recipe;
        }
        return null;
    }

}
