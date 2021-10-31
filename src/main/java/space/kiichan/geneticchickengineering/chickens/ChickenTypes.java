package space.kiichan.geneticchickengineering.chickens;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import space.kiichan.geneticchickengineering.i18n.LanguageBase;
import space.kiichan.geneticchickengineering.i18n.Translation;
import space.kiichan.geneticchickengineering.items.GCEItems;

public final class ChickenTypes {

    private static final Translation tl = LanguageBase.getTranslation();

    private ChickenTypes() {}

    private static final Map<Integer, Object[]> typemap = new LinkedHashMap<Integer, Object[]>() {
        {
            /* Key: int[] of dominance as returned by DNA.getTyping()
             * Value[0]: String of chicken type
             * Value[1]: ItemStack of the resource it gives
             */
            put(63, new Object[]{tl.TYPE_FEATHER, new ItemStack(Material.FEATHER)});
            put(31, new Object[]{tl.TYPE_BONE, new ItemStack(Material.BONE)});
            put(47, new Object[]{tl.TYPE_COBBLESTRONE, new ItemStack(Material.COBBLESTONE)});
            put(55, new Object[]{tl.TYPE_DIRT, new ItemStack(Material.DIRT)});
            put(59, new Object[]{tl.TYPE_FLINT, new ItemStack(Material.FLINT)});
            put(61, new Object[]{tl.TYPE_SAND, new ItemStack(Material.SAND)});
            put(62, new Object[]{tl.TYPE_WATER, GCEItems.WATER_EGG});
            put(15, new Object[]{tl.TYPE_COAL, new ItemStack(Material.COAL)});
            put(23, new Object[]{tl.TYPE_STRING, new ItemStack(Material.STRING)});
            put(27, new Object[]{tl.TYPE_LEATHER, new ItemStack(Material.LEATHER)});
            put(29, new Object[]{tl.TYPE_SUGAR, new ItemStack(Material.SUGAR)});
            put(30, new Object[]{tl.TYPE_SPONGE, new ItemStack(Material.SPONGE)});
            put(39, new Object[]{tl.TYPE_DIORITE, new ItemStack(Material.DIORITE)});
            put(43, new Object[]{tl.TYPE_ANDESITE, new ItemStack(Material.ANDESITE)});
            put(45, new Object[]{tl.TYPE_GRAVEL, new ItemStack(Material.GRAVEL)});
            put(46, new Object[]{tl.TYPE_ICE, new ItemStack(Material.ICE)});
            put(51, new Object[]{tl.TYPE_GRANITE, new ItemStack(Material.GRANITE)});
            put(53, new Object[]{tl.TYPE_CLAY, new ItemStack(Material.CLAY)});
            put(54, new Object[]{tl.TYPE_OAK_LOG, new ItemStack(Material.OAK_LOG)});
            put(57, new Object[]{tl.TYPE_GUNPOWDER, new ItemStack(Material.GUNPOWDER)});
            put(58, new Object[]{tl.TYPE_KELP, new ItemStack(Material.KELP)});
            put(60, new Object[]{tl.TYPE_SLIME, new ItemStack(Material.SLIME_BALL)});
            put(7, new Object[]{tl.TYPE_GOLD, new ItemStack(Material.GOLD_INGOT)});
            put(11, new Object[]{tl.TYPE_NETHERRACK, new ItemStack(Material.NETHERRACK)});
            put(13, new Object[]{tl.TYPE_GLASS, new ItemStack(Material.GLASS)});
            put(14, new Object[]{tl.TYPE_LAPIS, new ItemStack(Material.LAPIS_LAZULI)});
            put(19, new Object[]{tl.TYPE_IRON, new ItemStack(Material.IRON_INGOT)});
            put(21, new Object[]{tl.TYPE_IRON_DUST, SlimefunItems.IRON_DUST});
            put(22, new Object[]{tl.TYPE_GOLD_DUST, SlimefunItems.GOLD_DUST});
            put(25, new Object[]{tl.TYPE_SILVER_DUST, SlimefunItems.SILVER_DUST});
            put(26, new Object[]{tl.TYPE_ZINC_DUST, SlimefunItems.ZINC_DUST});
            put(28, new Object[]{tl.TYPE_CAKE, new ItemStack(Material.CAKE)});
            put(35, new Object[]{tl.TYPE_OBSIDIAN, new ItemStack(Material.OBSIDIAN)});
            put(37, new Object[]{tl.TYPE_COPPER_DUST, SlimefunItems.COPPER_DUST});
            put(38, new Object[]{tl.TYPE_MAGNESIUM_DUST, SlimefunItems.MAGNESIUM_DUST});
            put(41, new Object[]{tl.TYPE_LAVA, GCEItems.LAVA_EGG});
            put(42, new Object[]{tl.TYPE_TIN_DUST, SlimefunItems.TIN_DUST});
            put(44, new Object[]{tl.TYPE_SNOWBALL, new ItemStack(Material.SNOWBALL)});
            put(49, new Object[]{tl.TYPE_REDSTONE, new ItemStack(Material.REDSTONE)});
            put(50, new Object[]{tl.TYPE_CACTUS, new ItemStack(Material.CACTUS)});
            put(52, new Object[]{tl.TYPE_ALUMINUM_DUST, SlimefunItems.ALUMINUM_DUST});
            put(56, new Object[]{tl.TYPE_LEAD_DUST, SlimefunItems.LEAD_DUST});
            put(3, new Object[]{tl.TYPE_BLACKSTONE, new ItemStack(Material.BLACKSTONE)});
            put(5, new Object[]{tl.TYPE_SOUL_SOIL, new ItemStack(Material.SOUL_SOIL)});
            put(9, new Object[]{tl.TYPE_BLAZE_ROD, new ItemStack(Material.BLAZE_ROD)});
            put(17, new Object[]{tl.TYPE_GHAST_TEAR, new ItemStack(Material.GHAST_TEAR)});
            put(33, new Object[]{tl.TYPE_SULFATE, SlimefunItems.SULFATE});
            put(6, new Object[]{tl.TYPE_SHROOMLIGHT, new ItemStack(Material.SHROOMLIGHT)});
            put(10, new Object[]{tl.TYPE_NETHER_QUARTZ, new ItemStack(Material.QUARTZ)});
            put(18, new Object[]{tl.TYPE_BASALT, new ItemStack(Material.BASALT)});
            put(34, new Object[]{tl.TYPE_CRYING_OBSIDIAN, new ItemStack(Material.CRYING_OBSIDIAN)});
            put(12, new Object[]{tl.TYPE_SOUL_SAND, new ItemStack(Material.SOUL_SAND)});
            put(20, new Object[]{tl.TYPE_ENDER_PEARL, new ItemStack(Material.ENDER_PEARL)});
            put(36, new Object[]{tl.TYPE_NETHERWART, new ItemStack(Material.NETHER_WART)});
            put(24, new Object[]{tl.TYPE_PHANTOM_MEMBRANE, new ItemStack(Material.PHANTOM_MEMBRANE)});
            put(40, new Object[]{tl.TYPE_MAGMA_CREAM, new ItemStack(Material.MAGMA_CREAM)});
            put(48, new Object[]{tl.TYPE_GLOWSTONE_DUST, new ItemStack(Material.GLOWSTONE_DUST)});
            put(1, new Object[]{tl.TYPE_DIAMOND, new ItemStack(Material.DIAMOND)});
            put(2, new Object[]{tl.TYPE_END_STONE, new ItemStack(Material.END_STONE)});
            put(4, new Object[]{tl.TYPE_PRISMARINE_CRYSTAL, new ItemStack(Material.PRISMARINE_CRYSTALS)});
            put(8, new Object[]{tl.TYPE_PRISMARINE_SHARD, new ItemStack(Material.PRISMARINE_SHARD)});
            put(16, new Object[]{tl.TYPE_XP, new ItemStack(Material.EXPERIENCE_BOTTLE)});
            put(32, new Object[]{tl.TYPE_EMERALD, new ItemStack(Material.EMERALD)});
            put(0, new Object[]{tl.TYPE_NETHERITE, new ItemStack(Material.NETHERITE_INGOT)});
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

    public static void registerChickens(Research research, PocketChicken pc, ItemGroup itemGroup, RecipeType rt) {
        for (int i=typemap.size()-1; i>-1; i--) {
            Object[] attrs = typemap.get(i);
            pc.fakeVariant(i, (String) attrs[0], itemGroup, rt);
        }
        pc.plugin.log.info("Registered "+typemap.size()+" chickens");
    }

}
