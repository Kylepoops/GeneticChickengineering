package space.kiichan.geneticchickengineering.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import space.kiichan.geneticchickengineering.GeneticChickengineering;
import space.kiichan.geneticchickengineering.commands.Commands;
import space.kiichan.geneticchickengineering.commands.subcommands.Subcommand;

public class Completer implements TabCompleter {
    Commands commands;
    GeneticChickengineering plugin;

    public Completer(GeneticChickengineering plugin, Commands commands) {
        this.commands = commands;
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> out = new ArrayList<String>();
        if (args.length == 0) {
            for (String name: this.commands.getSubcommands()) {
                out.add(name);
            }
            Collections.sort(out);
        } else {
            Subcommand subcommand = this.commands.getSubcommand(args[0]);
            if (subcommand != null) {
                String[] subargs = new String[args.length-1];
                for (int i=0; i < args.length-1; i++) {
                    subargs[i] = args[i+1];
                }
                out = subcommand.onTabComplete(sender, subargs);
            } else {
                StringUtil.copyPartialMatches(args[0], this.commands.getSubcommands(), out);
                Collections.sort(out);
            }
        }
        return out;
    }
}
