package space.kiichan.geneticchickengineering.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
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
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> out = new ArrayList<>();
        if (args.length == 0) {
            out.addAll(this.commands.getSubcommands());
            Collections.sort(out);
        } else {
            Subcommand subcommand = this.commands.getSubcommand(args[0]);
            if (subcommand != null) {
                String[] subargs = new String[args.length-1];
                System.arraycopy(args, 1, subargs, 0, args.length - 1);
                out = subcommand.onTabComplete(sender, subargs);
            } else {
                StringUtil.copyPartialMatches(args[0], this.commands.getSubcommands(), out);
                Collections.sort(out);
            }
        }
        return out;
    }
}
