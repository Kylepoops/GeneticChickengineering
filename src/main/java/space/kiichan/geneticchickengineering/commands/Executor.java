package space.kiichan.geneticchickengineering.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.jetbrains.annotations.NotNull;
import space.kiichan.geneticchickengineering.GeneticChickengineering;
import space.kiichan.geneticchickengineering.commands.Commands;
import space.kiichan.geneticchickengineering.commands.subcommands.Subcommand;
import space.kiichan.geneticchickengineering.i18n.LanguageBase;
import space.kiichan.geneticchickengineering.i18n.Translation;

public class Executor implements CommandExecutor {
    private static final Translation tl = LanguageBase.getTranslation();
    Commands commands;
    GeneticChickengineering plugin;

    public Executor(GeneticChickengineering plugin, Commands commands) {
        this.commands = commands;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(tl.AVAILABLE_COMMAND);
            for (String name: this.commands.getSubcommands()) {
                sender.sendMessage("    "+name);
            }
            return false;
        }
        Subcommand subcommand = this.commands.getSubcommand(args[0]);
        if (subcommand != null) {
            String[] subargs = new String[args.length-1];
            System.arraycopy(args, 1, subargs, 0, args.length - 1);
            return subcommand.onExecute(sender, subargs);
        } else {
            sender.sendMessage(tl.INVALID_COMMAND + args[0]);
        }
        return false;
    }
}
