package space.kiichan.geneticchickengineering.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.command.PluginCommand;
import space.kiichan.geneticchickengineering.commands.Completer;
import space.kiichan.geneticchickengineering.commands.Executor;
import space.kiichan.geneticchickengineering.commands.subcommands.Subcommand;
import space.kiichan.geneticchickengineering.commands.subcommands.MakeChicken;
import space.kiichan.geneticchickengineering.commands.subcommands.CalculateChance;
import space.kiichan.geneticchickengineering.GeneticChickengineering;

public class Commands {

    private PluginCommand base;
    private Executor ex;
    private GeneticChickengineering plugin;
    private Map<String, Subcommand> subcommands = new HashMap<>();
    private Completer tc;

    public Commands(GeneticChickengineering plugin, Config cfg) {
        this.plugin = plugin;
        this.base = this.plugin.getCommand("geneticchickengineering");
        if (this.base == null) {
            this.plugin.log.severe("Commands failed to initialize");
            return;
        }

        if (cfg.getBoolean("commands.subcommands.makechicken.enabled")) {
            new MakeChicken(plugin, this, cfg.getString("commands.subcommands.makechicken.permission"));
        }
        if (cfg.getBoolean("commands.subcommands.calculatechance.enabled")) {
            new CalculateChance(plugin, this, cfg.getString("commands.subcommands.calculatechance.permission"));
        }

        this.tc = new Completer(plugin, this);
        this.ex = new Executor(plugin, this);
        this.base.setExecutor(this.ex);
        this.base.setTabCompleter(this.tc);
    }

    public void register(Subcommand subcmd) {
        this.subcommands.put(subcmd.getName(), subcmd);
    }

    public Subcommand getSubcommand(String name) {
        return this.subcommands.get(name);
    }

    public Set<String> getSubcommands() {
        return this.subcommands.keySet();
    }
}
