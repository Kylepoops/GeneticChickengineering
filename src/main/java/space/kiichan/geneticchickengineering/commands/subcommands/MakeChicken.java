package space.kiichan.geneticchickengineering.commands.subcommands;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import space.kiichan.geneticchickengineering.GeneticChickengineering;
import space.kiichan.geneticchickengineering.commands.Commands;
import space.kiichan.geneticchickengineering.commands.subcommands.Subcommand;
import space.kiichan.geneticchickengineering.genetics.DNA;

public class MakeChicken extends Subcommand {

    private final String alleles = new String(DNA.getAlleles());
    private final List<String> possibleDNA = new LinkedList<String>() {
        {
            for (int b=2; b>=0; b--) {
            for (int c=2; c>=0; c--) {
            for (int d=2; d>=0; d--) {
            for (int f=2; f>=0; f--) {
            for (int s=2; s>=0; s--) {
            for (int w=2; w>=0; w--) {
                int[] state = new int[]{b+b/2,c+c/2,d+d/2,f+f/2,s+s/2,w+w/2, 1};
                add(new DNA(state).toString());
            }}}}}}
        }
    };

    public MakeChicken(GeneticChickengineering plugin, Commands commands, String permissionName) {
        super(plugin, commands, permissionName);
        this.setName("makechicken");
        this.setHelp("Usage: /gce makechicken <dna>");
        this.commands.register(this);
    }

    @Override
    public boolean onExecute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(this.getHelp());
            return true;
        }
        String notation = args[args.length-1];
        if (!DNA.isValidSequence(notation)) {
            sender.sendMessage("DNA notation invalid for "+notation);
            return true;
        }

        if (sender instanceof Player && this.playerHasPermission((Player) sender)) {
            DNA dna = new DNA(notation.toCharArray());
            ItemStack chick = this.plugin.pocketChicken.fromDNA(dna);
            HashMap<Integer,ItemStack> excess = ((Player) sender).getInventory().addItem(chick);
            for (Integer i: excess.keySet()) {
                ItemStack dropchick = excess.get(i);
                ((Player) sender).getWorld().dropItemNaturally( ((Player) sender).getLocation().toCenterLocation(), dropchick);
            }
        } else {
            sender.sendMessage("Command must be executed by a player with permission");
        }
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        LinkedList<String> out = new LinkedList<>();
        if (args.length == 1) {
            out = this.findDNA(args[0]);
        }
        return out;
    }

    private LinkedList<String> findDNA(String partial) {
        LinkedList<String> out = new LinkedList<>();
        for (String dna: this.possibleDNA) {
            if (dna.startsWith(partial)) {
                out.add(dna);
            }
        }
        return out;
    }
}
