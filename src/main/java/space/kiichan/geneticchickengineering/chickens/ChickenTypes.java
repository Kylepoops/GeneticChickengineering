package space.kiichan.geneticchickengineering.chickens;

import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import java.util.LinkedHashMap;
import java.util.Map;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import space.kiichan.geneticchickengineering.chickens.PocketChicken;
import space.kiichan.geneticchickengineering.items.GCEItems;

public final class ChickenTypes {

    private ChickenTypes() {}

    private static final Map<Integer, Object[]> typemap = new LinkedHashMap<Integer, Object[]>() {
        {
            /* Key: int[] of dominance as returned by DNA.getTyping()
             * Value[0]: String of chicken type
             * Value[1]: ItemStack of the resource it gives
             */
            put(63, new Object[]{"Feather",new ItemStack(Material.FEATHER)});
            put(31, new Object[]{"Bone",new ItemStack(Material.BONE)});
            put(47, new Object[]{"Cobblestone",new ItemStack(Material.COBBLESTONE)});
            put(55, new Object[]{"Dirt",new ItemStack(Material.DIRT)});
            put(59, new Object[]{"Flint",new ItemStack(Material.FLINT)});
            put(61, new Object[]{"Sand",new ItemStack(Material.SAND)});
            put(62, new Object[]{"Water", GCEItems.WATER_EGG});
            put(15, new Object[]{"Coal",new ItemStack(Material.COAL)});
            put(23, new Object[]{"String",new ItemStack(Material.STRING)});
            put(27, new Object[]{"Leather",new ItemStack(Material.LEATHER)});
            put(29, new Object[]{"Sugar",new ItemStack(Material.SUGAR)});
            put(30, new Object[]{"Sponge",new ItemStack(Material.SPONGE)});
            put(39, new Object[]{"Diorite",new ItemStack(Material.DIORITE)});
            put(43, new Object[]{"Andesite",new ItemStack(Material.ANDESITE)});
            put(45, new Object[]{"Gravel",new ItemStack(Material.GRAVEL)});
            put(46, new Object[]{"Ice",new ItemStack(Material.ICE)});
            put(51, new Object[]{"Granite",new ItemStack(Material.GRANITE)});
            put(53, new Object[]{"Clay",new ItemStack(Material.CLAY)});
            put(54, new Object[]{"Oak Log",new ItemStack(Material.OAK_LOG)});
            put(57, new Object[]{"Gunpowder",new ItemStack(Material.GUNPOWDER)});
            put(58, new Object[]{"Kelp",new ItemStack(Material.KELP)});
            put(60, new Object[]{"Slime",new ItemStack(Material.SLIME_BALL)});
            put(7, new Object[]{"Gold",new ItemStack(Material.GOLD_INGOT)});
            put(11, new Object[]{"Netherrack",new ItemStack(Material.NETHERRACK)});
            put(13, new Object[]{"Glass",new ItemStack(Material.GLASS)});
            put(14, new Object[]{"Lapis",new ItemStack(Material.LAPIS_LAZULI)});
            put(19, new Object[]{"Iron",new ItemStack(Material.IRON_INGOT)});
            put(21, new Object[]{"Iron Dust", SlimefunItems.IRON_DUST});
            put(22, new Object[]{"Gold Dust", SlimefunItems.GOLD_DUST});
            put(25, new Object[]{"Silver Dust", SlimefunItems.SILVER_DUST});
            put(26, new Object[]{"Zinc Dust", SlimefunItems.ZINC_DUST});
            put(28, new Object[]{"Cake",new ItemStack(Material.CAKE)});
            put(35, new Object[]{"Obsidian",new ItemStack(Material.OBSIDIAN)});
            put(37, new Object[]{"Copper Dust", SlimefunItems.COPPER_DUST});
            put(38, new Object[]{"Magnesium Dust", SlimefunItems.MAGNESIUM_DUST});
            put(41, new Object[]{"Lava", GCEItems.LAVA_EGG});
            put(42, new Object[]{"Tin Dust", SlimefunItems.TIN_DUST});
            put(44, new Object[]{"Snowball",new ItemStack(Material.SNOWBALL)});
            put(49, new Object[]{"Redstone",new ItemStack(Material.REDSTONE)});
            put(50, new Object[]{"Cactus",new ItemStack(Material.CACTUS)});
            put(52, new Object[]{"Aluminum Dust", SlimefunItems.ALUMINUM_DUST});
            put(56, new Object[]{"Lead Dust", SlimefunItems.LEAD_DUST});
            put(3, new Object[]{"Blackstone",new ItemStack(Material.BLACKSTONE)});
            put(5, new Object[]{"Soul Soil",new ItemStack(Material.SOUL_SOIL)});
            put(9, new Object[]{"Blaze Rod",new ItemStack(Material.BLAZE_ROD)});
            put(17, new Object[]{"Ghast Tear",new ItemStack(Material.GHAST_TEAR)});
            put(33, new Object[]{"Sulfate", SlimefunItems.SULFATE});
            put(6, new Object[]{"Shroomlight",new ItemStack(Material.SHROOMLIGHT)});
            put(10, new Object[]{"Nether Quartz",new ItemStack(Material.QUARTZ)});
            put(18, new Object[]{"Basalt",new ItemStack(Material.BASALT)});
            put(34, new Object[]{"Crying Obsidian",new ItemStack(Material.CRYING_OBSIDIAN)});
            put(12, new Object[]{"Soul Sand",new ItemStack(Material.SOUL_SAND)});
            put(20, new Object[]{"Ender Pearl",new ItemStack(Material.ENDER_PEARL)});
            put(36, new Object[]{"Netherwart",new ItemStack(Material.NETHER_WART)});
            put(24, new Object[]{"Phantom Membrane",new ItemStack(Material.PHANTOM_MEMBRANE)});
            put(40, new Object[]{"Magma Cream",new ItemStack(Material.MAGMA_CREAM)});
            put(48, new Object[]{"Glowstone Dust",new ItemStack(Material.GLOWSTONE_DUST)});
            put(1, new Object[]{"Diamond",new ItemStack(Material.DIAMOND)});
            put(2, new Object[]{"End Stone",new ItemStack(Material.END_STONE)});
            put(4, new Object[]{"Prismarine Crystal",new ItemStack(Material.PRISMARINE_CRYSTALS)});
            put(8, new Object[]{"Prismarine Shard",new ItemStack(Material.PRISMARINE_SHARD)});
            put(16, new Object[]{"XP",new ItemStack(Material.EXPERIENCE_BOTTLE)});
            put(32, new Object[]{"Emerald",new ItemStack(Material.EMERALD)});
            put(0, new Object[]{"Netherite",new ItemStack(Material.NETHERITE_INGOT)});
        }
    };

    public static Object[] get(int typing) {
        return typemap.get(typing);
    }

    public static String getName(int typing) {
        return (String) typemap.get(typing)[0];
    }

    public static ItemStack getResource(int typing) {
        return (ItemStack) typemap.get(typing)[1];
    }

    public static void registerChickens(Research research, PocketChicken pc, Category category, RecipeType rt) {
        for (int i=typemap.size()-1; i>-1; i--) {
            Object[] attrs = typemap.get(i);
            pc.fakeVariant(i, (String) attrs[0], category, rt);
        }
        pc.plugin.log.info("Registered "+typemap.size()+" chickens");
    }

}
