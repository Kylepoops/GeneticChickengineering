package space.kiichan.geneticchickengineering.genetics;

import java.util.Arrays;
import java.util.Random;
import space.kiichan.geneticchickengineering.genetics.gene;

public class DNA {
    private gene[] sequence;
    final static private char[] alleles = new char[]{'b','c','d','f','s','w'};
    final private boolean[] boolcast = new boolean[]{false, true};
    private boolean learned;

    public DNA(int[] state) {
        // Load DNA from state
        this.sequence = new gene[6];
        for (int i=0; i<6; i++) {
            this.sequence[i] = new gene(alleles[i], state[i]);
        }
        this.learned = boolcast[state[6]];
    }

    public DNA(String state) {
        // Load DNA from a String state
        char[] statechars = state.toCharArray();
        this.sequence = new gene[6];
        for (int i=0; i<6; i++) {
            this.sequence[i] = new gene(alleles[i], Character.getNumericValue(statechars[i]));
        }
        this.learned = boolcast[Character.getNumericValue(statechars[6])];
    }

    public DNA(int typing) {
        this.sequence = new gene[6];
        String typeStr = Integer.toBinaryString(typing);
        String padded = String.format("%6s", typeStr).replaceAll(" ", "0");

        for (int i=0; i<6; i++) {
            this.sequence[i] = new gene(alleles[i], 3*(((int) padded.charAt(i))-((int) '0')));
        }
        this.learned = true;
    }

    public DNA(char[] half1, char[] half2) {
        // New DNA from two parent halves
        this.sequence = new gene[6];
        for (int i=0; i<6; i++) {
            this.sequence[i] = new gene(new char[]{half1[i], half2[i]});
        }
        this.learned = false;
    }

    public DNA(char[] notation) {
        // New DNA from notation, should be 12 long and only contain alleles
        this.sequence = new gene[6];
        for (int i=0; i<6; i++) {
            this.sequence[i] = new gene(new char[]{notation[2*i], notation[2*i+1]});
        }
        this.learned = true;
    }

    public DNA(double mutationRate, int maxMutation) {
        /* Random new DNA
         * For generating DNA of converted stock chickens
         *
         *
         */
        this.sequence = new gene[6];
        int[] mutations = new Random().ints(0, 6).distinct().limit(maxMutation).toArray();

        for (int i=0; i<6; i++) {
            char notation = Character.toUpperCase(alleles[i]);
            char[] markup = {notation, notation};
            // If this index was in the ones randomly chosen,
            // This allele is heterozygous
            final int z = i;
            boolean isMutated = Arrays.stream(mutations).anyMatch(x -> x == z);
            if (isMutated && Math.random()*100 < mutationRate) {
                markup[1] = alleles[i];
            }
            this.sequence[i] = new gene(markup);
        }

        this.learned = false;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i=0; i<6; i++) {
            out.append(this.sequence[i].toString());
        }
        return out.toString();
    }

    public char[] split() {
        char[] out = new char[6];
        for (int i=0; i<6; i++) {
            out[i] = this.sequence[i].split();
        }
        return out;
    }

    public gene[] getGenes() {
        return this.sequence;
    }

    public gene getGene(int index) {
        return this.sequence[index];
    }

    public int[] getState() {
        int[] out = new int[7];
        for (int i=0; i<6; i++) {
            out[i] = this.sequence[i].getState();
        }
        if (this.learned) {
            out[6] = 1;
        } else {
            out[6] = 0;
        }
        return out;
    }

    public String getStateString() {
        char[] out = new char[7];
        int[] state = getState();
        for (int i = 0; i < 7; i++) {
            out[i] = (char)(state[i] + '0');
        }
        return new String(out);
    }

    public int getTyping() {
        int out = 0;
        for (int i=5; i>-1; i--) {
            if (this.sequence[i].isDominant()) {
                out = out + (int) Math.pow(2,5-i);
            }
        }
        return out;
    }

    public int getTier() {
        int out = 0;
        for (int i=5; i>-1; i--) {
            if (!this.sequence[i].isDominant()) {
                out = out + 1;
            }
        }
        return out;
    }

    public static char[] getAlleles() {
        return alleles;
    }

    public static boolean isValidSequence(String seq) {
        return isValidSequence(seq.toCharArray());
    }

    public static boolean isValidSequence(char[] seq) {
        if (seq.length != 12) {
            return false;
        }
        for (int i=0; i<6; i++) {
            char allele = alleles[i];
            if (Character.toLowerCase(seq[2*i]) != allele ||
                Character.toLowerCase(seq[2*i+1]) != allele) {
                return false;
            }
        }
        return true;
    }

    public boolean isKnown() {
        return this.learned;
    }

    public void learn() {
        this.learned = true;
    }
}
