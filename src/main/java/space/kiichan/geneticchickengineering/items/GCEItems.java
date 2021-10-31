package space.kiichan.geneticchickengineering.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import space.kiichan.geneticchickengineering.i18n.LanguageBase;
import space.kiichan.geneticchickengineering.i18n.Translation;

public final class GCEItems {

    private GCEItems() {}

    private static final Translation tl = LanguageBase.getTranslation();

    public static final SlimefunItemStack POCKET_CHICKEN = new SlimefunItemStack("GCE_POCKET_CHICKEN", "1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893", "§r§bPocket Chicken", "§7Right click on a block", "§7to release the chicken");
    public static final SlimefunItemStack CHICKEN_NET = new SlimefunItemStack("GCE_CHICKEN_NET", new ItemStack(Material.COBWEB), tl.CHICKEN_NET[0], tl.CHICKEN_NET[1], LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack WATER_EGG = new SlimefunItemStack("GCE_WATER_EGG", new ItemStack(Material.TURTLE_SPAWN_EGG), tl.WATER_EGG[0], tl.WATER_EGG[1], LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack LAVA_EGG = new SlimefunItemStack("GCE_LAVA_EGG", new ItemStack(Material.STRIDER_SPAWN_EGG), tl.LAVA_EGG[0], tl.LAVA_EGG[1], LoreBuilder.RIGHT_CLICK_TO_USE);
    public static final SlimefunItemStack GENETIC_SEQUENCER = new SlimefunItemStack("GCE_GENETIC_SEQUENCER", new ItemStack(Material.SMOKER), tl.GENETIC_SEQUENCER[0], tl.GENETIC_SEQUENCER[1], LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE), LoreBuilder.powerPerSecond(6));
    public static final SlimefunItemStack EXCITATION_CHAMBER = new SlimefunItemStack("GCE_EXCITATION_CHAMBER", new ItemStack(Material.BLAST_FURNACE), tl.EXCITATION_CHAMBER[0], tl.EXCITATION_CHAMBER[1], LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE), LoreBuilder.powerPerSecond(10));
    public static final SlimefunItemStack EXCITATION_CHAMBER_2 = new SlimefunItemStack("GCE_EXCITATION_CHAMBER_2", new ItemStack(Material.BLAST_FURNACE), tl.EXCITATION_CHAMBER_2[0], tl.EXCITATION_CHAMBER_2[1], tl.EXCITATION_CHAMBER_2[2],LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.powerPerSecond(15));
    public static final SlimefunItemStack PRIVATE_COOP = new SlimefunItemStack("GCE_PRIVATE_COOP", new ItemStack(Material.BEEHIVE), tl.PRIVATE_COOP[0], tl.PRIVATE_COOP[1], LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE), LoreBuilder.powerPerSecond(2));
    public static final SlimefunItemStack RESTORATION_CHAMBER = new SlimefunItemStack("GCE_RESTORATION_CHAMBER", new ItemStack(Material.PINK_SHULKER_BOX), tl.RESTORATION_CHAMBER[0], tl.RESTORATION_CHAMBER[1], LoreBuilder.machine(MachineTier.MEDIUM, MachineType.MACHINE), LoreBuilder.powerPerSecond(4));

}
