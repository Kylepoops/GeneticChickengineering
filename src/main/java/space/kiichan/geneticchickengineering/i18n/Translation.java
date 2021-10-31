package space.kiichan.geneticchickengineering.i18n;

import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Translation {
    private final Plugin plugin;
    private final Config config;
    public String PAPER_WARNING;
    public String PAPER_CHECK;
    public String AVAILABLE_COMMAND;
    public String INVALID_COMMAND;
    public String TYPE_FEATHER;
    public String TYPE_BONE;
    public String TYPE_COBBLESTRONE;
    public String TYPE_DIRT;
    public String TYPE_FLINT;
    public String TYPE_SAND;
    public String TYPE_WATER;
    public String TYPE_COAL;
    public String TYPE_STRING;
    public String TYPE_LEATHER;
    public String TYPE_SUGAR;
    public String TYPE_SPONGE;
    public String TYPE_DIORITE;
    public String TYPE_ANDESITE;
    public String TYPE_GRAVEL;
    public String TYPE_ICE;
    public String TYPE_GRANITE;
    public String TYPE_CLAY;
    public String TYPE_OAK_LOG;
    public String TYPE_GUNPOWDER;
    public String TYPE_KELP;
    public String TYPE_SLIME;
    public String TYPE_GOLD;
    public String TYPE_NETHERRACK;
    public String TYPE_GLASS;
    public String TYPE_LAPIS;
    public String TYPE_IRON;
    public String TYPE_IRON_DUST;
    public String TYPE_GOLD_DUST;
    public String TYPE_SILVER_DUST;
    public String TYPE_ZINC_DUST;
    public String TYPE_CAKE;
    public String TYPE_OBSIDIAN;
    public String TYPE_COPPER_DUST;
    public String TYPE_MAGNESIUM_DUST;
    public String TYPE_LAVA;
    public String TYPE_TIN_DUST;
    public String TYPE_SNOWBALL;
    public String TYPE_REDSTONE;
    public String TYPE_CACTUS;
    public String TYPE_ALUMINUM_DUST;
    public String TYPE_LEAD_DUST;
    public String TYPE_BLACKSTONE;
    public String TYPE_SOUL_SOIL;
    public String TYPE_BLAZE_ROD;
    public String TYPE_GHAST_TEAR;
    public String TYPE_SULFATE;
    public String TYPE_SHROOMLIGHT;
    public String TYPE_NETHER_QUARTZ;
    public String TYPE_BASALT;
    public String TYPE_CRYING_OBSIDIAN;
    public String TYPE_SOUL_SAND;
    public String TYPE_ENDER_PEARL;
    public String TYPE_NETHERWART;
    public String TYPE_PHANTOM_MEMBRANE;
    public String TYPE_MAGMA_CREAM;
    public String TYPE_GLOWSTONE_DUST;
    public String TYPE_DIAMOND;
    public String TYPE_END_STONE;
    public String TYPE_PRISMARINE_CRYSTAL;
    public String TYPE_PRISMARINE_SHARD;
    public String TYPE_XP;
    public String TYPE_EMERALD;
    public String TYPE_NETHERITE;
    // PocketChicken Lore
    public String LORE_STATUS;
    public String LORE_HEALTHY;
    public String LORE_EXHAUSTED;
    public String LORE_FATIGUED;
    public String LORE_DNA;
    public String LORE_TYPE;
    public String LORE_CHICKEN;
    // GCEItems
    public String[] POCKET_CHICKEN;
    public String[] CHICKEN_NET;
    public String[] WATER_EGG;
    public String[] LAVA_EGG;
    public String[] GENETIC_SEQUENCER;
    public String[] EXCITATION_CHAMBER;
    public String[] EXCITATION_CHAMBER_2;
    public String[] PRIVATE_COOP;
    public String[] RESTORATION_CHAMBER;
    // Recipe
    public String[] RECIPE_EXCITATION_CHAMBER;

    public Translation(Plugin plugin, Config config, File file) {
        this.plugin = plugin;
        this.config = config;
        //Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            loadOrSetDefault(config);
            config.save(file);
        //});
    }

    private void loadOrSetDefault(@NotNull Config config) {
        this.PAPER_WARNING = config.getOrSetDefault("PAPER_WARNING", "Connection to database failed. Aborting initialization.");
        this.PAPER_CHECK = config.getOrSetDefault("PAPER_CHECK", "Check above for more information about the error.");
        this.AVAILABLE_COMMAND = config.getOrSetDefault("AVAILABLE_COMMAND", "Available subcommands:");
        this.INVALID_COMMAND = config.getOrSetDefault("INVALID_COMMAND", "Invalid subcommand: ");
        //Type Name
        this.TYPE_FEATHER = config.getOrSetDefault("TYPE_FEATHER", "Feather");
        this.TYPE_BONE = config.getOrSetDefault("TYPE_BONE", "Bone");
        this.TYPE_COBBLESTRONE = config.getOrSetDefault("TYPE_COBBLESTRONE", "Cobblestone");
        this.TYPE_DIRT = config.getOrSetDefault("TYPE_DIRT", "Dirt");
        this.TYPE_FLINT = config.getOrSetDefault("TYPE_FLINT", "Flint");
        this.TYPE_SAND = config.getOrSetDefault("TYPE_SAND", "Sand");
        this.TYPE_WATER = config.getOrSetDefault("TYPE_WATER", "Water");
        this.TYPE_COAL = config.getOrSetDefault("TYPE_COAL", "Coal");
        this.TYPE_STRING = config.getOrSetDefault("TYPE_STRING", "String");
        this.TYPE_LEATHER = config.getOrSetDefault("TYPE_LEATHER", "Leather");
        this.TYPE_SUGAR = config.getOrSetDefault("TYPE_SUGAR", "Sugar");
        this.TYPE_SPONGE = config.getOrSetDefault("TYPE_SPONGE", "Sponge");
        this.TYPE_DIORITE = config.getOrSetDefault("TYPE_DIORITE", "Diorite");
        this.TYPE_ANDESITE = config.getOrSetDefault("TYPE_ANDESITE", "Andesite");
        this.TYPE_GRAVEL = config.getOrSetDefault("TYPE_GRAVEL", "GRAVEL");
        this.TYPE_ICE = config.getOrSetDefault("TYPE_ICE", "Ice");
        this.TYPE_GRANITE = config.getOrSetDefault("TYPE_GRANITE", "Granite");
        this.TYPE_CLAY = config.getOrSetDefault("TYPE_CLAY", "Clay");
        this.TYPE_OAK_LOG = config.getOrSetDefault("TYPE_QAK_LOG", "Oak Log");
        this.TYPE_GUNPOWDER = config.getOrSetDefault("TYPE_GUNPOWDER", "Gunpowder");
        this.TYPE_KELP = config.getOrSetDefault("TYPE_KELP", "Kelp");
        this.TYPE_SLIME = config.getOrSetDefault("TYPE_SLIME", "Slime");
        this.TYPE_GOLD = config.getOrSetDefault("TYPE_GOLD", "Gold");
        this.TYPE_NETHERRACK = config.getOrSetDefault("TYPE_NETHERRACK", "Netherrack");
        this.TYPE_GLASS = config.getOrSetDefault("TYPE_GLASS", "Glass");
        this.TYPE_LAPIS = config.getOrSetDefault("TYPE_LAPIS", "Lapis");
        this.TYPE_IRON = config.getOrSetDefault("TYPE_IRON", "Iron");
        this.TYPE_IRON_DUST = config.getOrSetDefault("TYPE_IRON_DUST", "Iron Dust");
        this.TYPE_GOLD_DUST = config.getOrSetDefault("TYPE_GOLD_DUST", "Gold Dust");
        this.TYPE_SILVER_DUST = config.getOrSetDefault("TYPE_SILVER_DUST", "Silver Dust");
        this.TYPE_ZINC_DUST = config.getOrSetDefault("TYPE_ZINC_DUST", "Zinc Dust");
        this.TYPE_CAKE = config.getOrSetDefault("TYPE_CAKE", "Cake");
        this.TYPE_OBSIDIAN = config.getOrSetDefault("TYPE_OBSIDIAN", "Obsidian");
        this.TYPE_COPPER_DUST = config.getOrSetDefault("TYPE_COPPER_DUST", "Copper Dust");
        this.TYPE_MAGNESIUM_DUST = config.getOrSetDefault("TYPE_MAGNESIUM_DUST", "Magnesium Dust");
        this.TYPE_LAVA = config.getOrSetDefault("TYPE_LAVA", "Lava");
        this.TYPE_TIN_DUST = config.getOrSetDefault("TYPE_TIN_DUST", "Tin Dust");
        this.TYPE_SNOWBALL = config.getOrSetDefault("TYPE_SNOWBALL", "Snowball");
        this.TYPE_REDSTONE = config.getOrSetDefault("TYPE_REDSTONE", "Redstone");
        this.TYPE_CACTUS = config.getOrSetDefault("TYPE_CACTUS", "Cactus");
        this.TYPE_ALUMINUM_DUST = config.getOrSetDefault("TYPE_ALUMINUM_DUST", "Aluminum Dust");
        this.TYPE_LEAD_DUST = config.getOrSetDefault("TYPE_LEAD_DUST", "Lead Dust");
        this.TYPE_BLACKSTONE = config.getOrSetDefault("TYPE_BLACKSTONE", "Blackstone");
        this.TYPE_SOUL_SOIL = config.getOrSetDefault("TYPE_SOUL_SOIL", "Soul Soil");
        this.TYPE_BLAZE_ROD = config.getOrSetDefault("TYPE_BLAZE_ROD", "Blaze Rod");
        this.TYPE_GHAST_TEAR = config.getOrSetDefault("TYPE_GHAST_TEAR", "Ghast Tear");
        this.TYPE_SULFATE = config.getOrSetDefault("TYPE_SULFATE", "Sulfate");
        this.TYPE_SHROOMLIGHT = config.getOrSetDefault("TYPE_SHROOMLIGHT", "Shroomlight");
        this.TYPE_NETHER_QUARTZ = config.getOrSetDefault("TYPE_NETHER_QUARTZ", "Nether Quartz");
        this.TYPE_BASALT = config.getOrSetDefault("BASALT", "Basalt");
        this.TYPE_CRYING_OBSIDIAN = config.getOrSetDefault("TYPE_CRYING_OBSIDIAN", "Crying Obsidian");
        this.TYPE_SOUL_SAND = config.getOrSetDefault("TYPE_SOUL_SAND", "Soul Sand");
        this.TYPE_ENDER_PEARL = config.getOrSetDefault("TYPE_ENDER_PEARL", "Ender Pearl");
        this.TYPE_NETHERWART = config.getOrSetDefault("TYPE_NETHERWART", "Netherwart");
        this.TYPE_PHANTOM_MEMBRANE = config.getOrSetDefault("TYPE_PHANTOM_MEMBRANE", "Phantom Membrane");
        this.TYPE_MAGMA_CREAM = config.getOrSetDefault("TYPE_MAGMA_CREAM", "Magma Cream");
        this.TYPE_GLOWSTONE_DUST = config.getOrSetDefault("TYPE_GLOWSTONE_DUST", "Glowstone Dust");
        this.TYPE_DIAMOND = config.getOrSetDefault("TYPE_DIAMOND", "Diamond");
        this.TYPE_END_STONE = config.getOrSetDefault("TYPE_END_STONE", "End Stone");
        this.TYPE_PRISMARINE_CRYSTAL = config.getOrSetDefault("TYPE_PRISMARINE_CRYSTAL", "Prismarine Crystal");
        this.TYPE_PRISMARINE_SHARD = config.getOrSetDefault("TYPE_PRISMARINE_SHARD", "Prismarine Shard");
        this.TYPE_XP = config.getOrSetDefault("TYPE_XP", "XP");
        this.TYPE_EMERALD = config.getOrSetDefault("TYPE_EMERALD", "Emerald");
        this.TYPE_NETHERITE = config.getOrSetDefault("TYPE_NETHERITE", "Netherite");
        // PocketChicken Lore
        this.LORE_STATUS = config.getOrSetDefault("LORE_STATUS", "Status");
        this.LORE_HEALTHY = config.getOrSetDefault("LORE_HEALTHY", "Healthy");
        this.LORE_EXHAUSTED = config.getOrSetDefault("LORE_EXHAUSTED", "Exhausted");
        this.LORE_FATIGUED = config.getOrSetDefault("LORE_FATIGUED", "Fatigued");
        this.LORE_DNA = config.getOrSetDefault("LORE_DNA", "DNA");
        this.LORE_TYPE = config.getOrSetDefault("LORE_TYPE", "TYPE");
        this.LORE_CHICKEN = config.getOrSetDefault("LORE_CHICKEN", "Chicken");
        // GCEItems
        this.POCKET_CHICKEN = this.getOrSetDefaultArray("POCKET_CHICKEN", "§r§bPocket Chicken", "§7Right click on a block", "§7to release the chicken");
        this.CHICKEN_NET = this.getOrSetDefaultArray("CHICKEN_NET", "§aChicken Net", "§r§7§oMakes chickens portable");
        this.WATER_EGG = this.getOrSetDefaultArray("WATER_EGG", "§9Water Egg", "§r§7§oContains water");
        this.LAVA_EGG = this.getOrSetDefaultArray("LAVA_EGG", "§cLava Egg", "§r§7§oContains lava");
        this.GENETIC_SEQUENCER = this.getOrSetDefaultArray("GENETIC_SEQUENCER", "§eGenetic Sequencer", "§r§7§oUsed to determine a chicken's genotype");
        this.EXCITATION_CHAMBER = this.getOrSetDefaultArray("EXCITATION_CHAMBER", "§eExcitation Chamber", "§r§7§oEnables chickens to produce a resource");
        this.EXCITATION_CHAMBER_2 = this.getOrSetDefaultArray("EXCITATION_CHAMBER_2", "§eBoosted Excitation Chamber", "§r§7§oEnables chickens to produce a resource,", "§r§7§obut faster");
        this.PRIVATE_COOP = this.getOrSetDefaultArray("PRIVATE_COOP", "§ePrivate Coop", "§ePrivate Coop", "§r§7§oBig enough for two...");
        this.RESTORATION_CHAMBER = this.getOrSetDefaultArray("RESTORATION_CHAMBER", "§eRestoration Chamber", "§r§7§oHeals Pocket Chickens");
        // Recipe
        this.RECIPE_EXCITATION_CHAMBER = this.getOrSetDefaultArray("RECIPE_EXCITATION_CHAMBER", "§r§fObtained from a §bPocket Chicken", "&fin an §eExcitation Chamber");


        //TODO: ALL MESSAGE
    }

    private String[] getOrSetDefaultArray(String path, String... def) {
        if (config.contains(path)) {
            return config.getStringList(path).toArray(new String[0]);
        } else {
            List<String> value = Arrays.stream(def).collect(Collectors.toList());
            config.setValue(path, value);
            return def;
        }
    }
}
