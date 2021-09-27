package space.kiichan.geneticchickengineering.commands.subcommands;

import java.util.LinkedList;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import space.kiichan.geneticchickengineering.GeneticChickengineering;
import space.kiichan.geneticchickengineering.commands.Commands;
import space.kiichan.geneticchickengineering.commands.subcommands.Subcommand;
import space.kiichan.geneticchickengineering.genetics.DNA;
import space.kiichan.geneticchickengineering.genetics.gene;

public class CalculateChance extends Subcommand {

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

    public CalculateChance(GeneticChickengineering plugin, Commands commands, String permissionName) {
        super(plugin, commands, permissionName);
        this.setName("calculatechance");
        this.setHelp("Usage: /gce calculatechance <parent DNA> <parent DNA> <child DNA>");
        this.commands.register(this);
    }

    @Override
    public boolean onExecute(CommandSender sender, String[] args) {
        if (args.length != 3) {
            sender.sendMessage(this.getHelp());
            return true;
        }
        String[] notations = new String[3];
        for (int i=0; i<3; i++) {
            notations[i] = args[args.length-3+i];
            if (!DNA.isValidSequence(notations[i])) {
                sender.sendMessage("DNA notation invalid for "+notations[i]);
                return true;
            }
        }

        if (sender instanceof Player && this.playerHasPermission((Player) sender)) {
            DNA p1dna = new DNA(notations[0].toCharArray());
            DNA p2dna = new DNA(notations[1].toCharArray());
            DNA cdna = new DNA(notations[2].toCharArray());
            double chanceTotal = 1.0;
            for (int i=0; i<6; i++) {
                gene p1g = p1dna.getGene(i);
                gene p2g = p2dna.getGene(i);
                gene cg = cdna.getGene(i);
                double matches = 0.0;
                for (char p1a: p1g.getAlleles()) {
                for (char p2a: p2g.getAlleles()) {
                    if (new gene(new char[]{p1a,p2a}).getState() == cg.getState() ) {
                        matches = matches + 1.0;
                    }
                }
                }
                chanceTotal = chanceTotal * (matches*0.25);
            }
            long readableChance = Math.round(chanceTotal*100);
            String message = "There is a "+readableChance+"% chance ";
            if (chanceTotal > 0 && chanceTotal < 100) {
                message = message + "(roughly 1 in "+Math.round(1/chanceTotal)+" odds) ";
            }
            message = message + "that ("+p1dna.toString()+
                ") and ("+p2dna.toString()+") will produce a ("+cdna.toString()+
                ") child";
            sender.sendMessage(message);
        } else {
            sender.sendMessage("Command must be executed by a player with permission");
        }
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        LinkedList<String> out = new LinkedList<>();
        if (args.length > 0 && args.length < 4) {
            out = this.findDNA(args[args.length-1]);
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
