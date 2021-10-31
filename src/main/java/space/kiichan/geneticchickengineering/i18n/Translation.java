package space.kiichan.geneticchickengineering.i18n;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Translation {
    private final Plugin plugin;
    private final YamlConfiguration config;
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

    public Translation(Plugin plugin, YamlConfiguration config, File file) {
        this.plugin = plugin;
        this.config = config;
        //Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            loadOrSetDefault(config);
            try { config.save(file); } catch (IOException e) { e.printStackTrace(); }
        //});
    }

    private void loadOrSetDefault(@NotNull YamlConfiguration config) {
        this.PAPER_WARNING = config.getString("PAPER_WARNING", "Connection to database failed. Aborting initialization.");
        this.PAPER_CHECK = config.getString("PAPER_CHECK", "Check above for more information about the error.");
        this.AVAILABLE_COMMAND = config.getString("AVAILABLE_COMMAND", "Available subcommands:");
        this.INVALID_COMMAND = config.getString("INVALID_COMMAND", "Invalid subcommand: ");
        //Type Name
        this.TYPE_FEATHER = config.getString("TYPE_FEATHER", "Feather");
        this.TYPE_BONE = config.getString("TYPE_BONE", "Bone");
        this.TYPE_COBBLESTRONE = config.getString("TYPE_COBBLESTRONE", "Cobblestone");
        this.TYPE_DIRT = config.getString("TYPE_DIRT", "Dirt");
        this.TYPE_FLINT = config.getString("TYPE_FLINT", "Flint");
        this.TYPE_SAND = config.getString("TYPE_SAND", "Sand");
        this.TYPE_WATER = config.getString("TYPE_WATER", "Water");
        this.TYPE_COAL = config.getString("TYPE_COAL", "Coal");
        this.TYPE_STRING = config.getString("TYPE_STRING", "String");
        this.TYPE_LEATHER = config.getString("TYPE_LEATHER", "Leather");
        this.TYPE_SUGAR = config.getString("TYPE_SUGAR", "Sugar");
        this.TYPE_SPONGE = config.getString("TYPE_SPONGE", "Sponge");
        this.TYPE_DIORITE = config.getString("TYPE_DIORITE", "Diorite");
        this.TYPE_ANDESITE = config.getString("TYPE_ANDESITE", "Andesite");
        this.TYPE_GRAVEL = config.getString("TYPE_GRAVEL", "GRAVEL");
        this.TYPE_ICE = config.getString("TYPE_ICE", "Ice");
        this.TYPE_GRANITE = config.getString("TYPE_GRANITE", "Granite");
        this.TYPE_CLAY = config.getString("TYPE_CLAY", "Clay");
        this.TYPE_OAK_LOG = config.getString("TYPE_QAK_LOG", "Oak Log");
        this.TYPE_GUNPOWDER = config.getString("TYPE_GUNPOWDER", "Gunpowder");
        this.TYPE_KELP = config.getString("TYPE_KELP", "Kelp");
        this.TYPE_SLIME = config.getString("TYPE_SLIME", "Slime");
        this.TYPE_GOLD = config.getString("TYPE_GOLD", "Gold");
        this.TYPE_NETHERRACK = config.getString("TYPE_NETHERRACK", "Netherrack");
        this.TYPE_GLASS = config.getString("TYPE_GLASS", "Glass");
        this.TYPE_LAPIS = config.getString("TYPE_LAPIS", "Lapis");
        this.TYPE_IRON = config.getString("TYPE_IRON", "Iron");
        this.TYPE_IRON_DUST = config.getString("TYPE_IRON_DUST", "Iron Dust");
        this.TYPE_GOLD_DUST = config.getString("TYPE_GOLD_DUST", "Gold Dust");
        this.TYPE_SILVER_DUST = config.getString("TYPE_SILVER_DUST", "Silver Dust");
        this.TYPE_ZINC_DUST = config.getString("TYPE_ZINC_DUST", "Zinc Dust");
        this.TYPE_CAKE = config.getString("TYPE_CAKE", "Cake");
        this.TYPE_OBSIDIAN = config.getString("TYPE_OBSIDIAN", "Obsidian");
        this.TYPE_COPPER_DUST = config.getString("TYPE_COPPER_DUST", "Copper Dust");
        this.TYPE_MAGNESIUM_DUST = config.getString("TYPE_MAGNESIUM_DUST", "Magnesium Dust");
        this.TYPE_LAVA = config.getString("TYPE_LAVA", "Lava");
        this.TYPE_TIN_DUST = config.getString("TYPE_TIN_DUST", "Tin Dust");
        this.TYPE_SNOWBALL = config.getString("TYPE_SNOWBALL", "Snowball");
        this.TYPE_REDSTONE = config.getString("TYPE_REDSTONE", "Redstone");
        this.TYPE_CACTUS = config.getString("TYPE_CACTUS", "Cactus");
        this.TYPE_ALUMINUM_DUST = config.getString("TYPE_ALUMINUM_DUST", "Aluminum Dust");
        this.TYPE_LEAD_DUST = config.getString("TYPE_LEAD_DUST", "Lead Dust");
        this.TYPE_BLACKSTONE = config.getString("TYPE_BLACKSTONE", "Blackstone");
        this.TYPE_SOUL_SOIL = config.getString("TYPE_SOUL_SOIL", "Soul Soil");
        this.TYPE_BLAZE_ROD = config.getString("TYPE_BLAZE_ROD", "Blaze Rod");
        this.TYPE_GHAST_TEAR = config.getString("TYPE_GHAST_TEAR", "Ghast Tear");
        this.TYPE_SULFATE = config.getString("TYPE_SULFATE", "Sulfate");
        this.TYPE_SHROOMLIGHT = config.getString("TYPE_SHROOMLIGHT", "Shroomlight");
        this.TYPE_NETHER_QUARTZ = config.getString("TYPE_NETHER_QUARTZ", "Nether Quartz");
        this.TYPE_BASALT = config.getString("BASALT", "Basalt");
        this.TYPE_CRYING_OBSIDIAN = config.getString("TYPE_CRYING_OBSIDIAN", "Crying Obsidian");
        this.TYPE_SOUL_SAND = config.getString("TYPE_SOUL_SAND", "Soul Sand");
        this.TYPE_ENDER_PEARL = config.getString("TYPE_ENDER_PEARL", "Ender Pearl");
        this.TYPE_NETHERWART = config.getString("TYPE_NETHERWART", "Netherwart");
        this.TYPE_PHANTOM_MEMBRANE = config.getString("TYPE_PHANTOM_MEMBRANE", "Phantom Membrane");
        this.TYPE_MAGMA_CREAM = config.getString("TYPE_MAGMA_CREAM", "Magma Cream");
        this.TYPE_GLOWSTONE_DUST = config.getString("TYPE_GLOWSTONE_DUST", "Glowstone Dust");
        this.TYPE_DIAMOND = config.getString("TYPE_DIAMOND", "Diamond");
        this.TYPE_END_STONE = config.getString("TYPE_END_STONE", "End Stone");
        this.TYPE_PRISMARINE_CRYSTAL = config.getString("TYPE_PRISMARINE_CRYSTAL", "Prismarine Crystal");
        this.TYPE_PRISMARINE_SHARD = config.getString("TYPE_PRISMARINE_SHARD", "Prismarine Shard");
        this.TYPE_XP = config.getString("TYPE_XP", "XP");
        this.TYPE_EMERALD = config.getString("TYPE_EMERALD", "Emerald");
        this.TYPE_NETHERITE = config.getString("TYPE_NETHERITE", "Netherite");
        // PocketChicken Lore
        this.LORE_STATUS = config.getString("LORE_STATUS", "Status");
        this.LORE_HEALTHY = config.getString("LORE_HEALTHY", "Healthy");
        this.LORE_EXHAUSTED = config.getString("LORE_EXHAUSTED", "Exhausted");
        this.LORE_FATIGUED = config.getString("LORE_FATIGUED", "Fatigued");
        this.LORE_DNA = config.getString("LORE_DNA", "DNA");
        this.LORE_TYPE = config.getString("LORE_TYPE", "TYPE");
        this.LORE_CHICKEN = config.getString("LORE_CHICKEN", "Chicken");
        // GCEItems
        this.POCKET_CHICKEN = this.getStringArray("POCKET_CHICKEN", "§r§bPocket Chicken", "§7Right click on a block", "§7to release the chicken");
        this.CHICKEN_NET = this.getStringArray("§aChicken Net", "§r§7§oMakes chickens portable");
        this.WATER_EGG = this.getStringArray("§9Water Egg", "§r§7§oContains water");
        this.LAVA_EGG = this.getStringArray("§cLava Egg", "§r§7§oContains lava");
        this.GENETIC_SEQUENCER = this.getStringArray("§eGenetic Sequencer", "§r§7§oUsed to determine a chicken's genotype");
        this.EXCITATION_CHAMBER = this.getStringArray("§eExcitation Chamber", "§r§7§oEnables chickens to produce a resource");
        this.EXCITATION_CHAMBER_2 = this.getStringArray("§eBoosted Excitation Chamber", "§r§7§oEnables chickens to produce a resource,", "§r§7§obut faster");
        this.PRIVATE_COOP = this.getStringArray("§ePrivate Coop", "§ePrivate Coop", "§r§7§oBig enough for two...");
        this.RESTORATION_CHAMBER = this.getStringArray("§eRestoration Chamber", "§r§7§oHeals Pocket Chickens");
        // Recipe
        this.RECIPE_EXCITATION_CHAMBER = this.getStringArray("RECIPE_EXCITATION_CHAMBER", "§r§fObtained from a §bPocket Chicken", "&fin an §eExcitation Chamber");


        //TODO: ALL MESSAGE
    }

    private String[] getStringArray(String path, String... def) {
        if (config.isSet(path)) {
            return config.getStringList(path).toArray(new String[0]);
        } else {
            List<String> value = Arrays.stream(def).collect(Collectors.toList());
            config.set(path, value);
            return def;
        }
    }
}
