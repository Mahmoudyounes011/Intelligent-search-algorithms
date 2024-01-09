
// import java.util.ArrayList;
import java.util.*;

public class Throws {
    static String[] stones = { "dist", "bnj", "sheqah", "bara", "dowaq", "three", "four" };
    static HashMap<String, Double> stone_probabilities = new HashMap<>();
    private HashSet<String> throwListItems;
    private double chance;

    public Throws(HashSet<String> t, double chance) {
        this.throwListItems = t;
        this.chance = chance;
    }

    public HashSet<String> getThrowListItems() {
        return throwListItems;
    }

    public void setThrowListItems(HashSet<String> t) {
        this.throwListItems = t;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public static ArrayList<Throws> generateThrows(int current,
            HashSet<String> throwSequence, ArrayList<Throws> tList,
            double cumulative_prob) {
        if (current == 0) {
            stone_probabilities.put("dist", 0.186624);
            stone_probabilities.put("bnj", 0.0368864);
            stone_probabilities.put("sheqah", 0.046656);
            stone_probabilities.put("bara", 0.004096);
            stone_probabilities.put("dowaq", 0.31104);
            stone_probabilities.put("three", 0.27648);
            stone_probabilities.put("four", 0.13824);
        }
        if (current == 10) {
            if (cumulative_prob > 0.000001) {
                tList.add(new Throws(throwSequence, cumulative_prob));
            }
            return tList;
        }
        for (String stone : stones) {
            double next_prob = stone_probabilities.get(stone);
            // System.out.println(next_prob);
            if (cumulative_prob * next_prob > 0.000001)
                if (stone == "dist" || stone == "bnj" || stone == "sheqah" || stone == "bara") {
                    // throwSequence.add(stone);
                    HashSet<String> throwItem = new HashSet<String>();
                    throwItem.addAll(throwSequence);
                    throwItem.add(stone);
                    generateThrows(current + 1, throwItem, tList, cumulative_prob * next_prob);
                } else {
                    HashSet<String> throwItem = new HashSet<String>();
                    throwItem.addAll(throwSequence);
                    throwItem.add(stone);
                    tList.add(new Throws(throwItem, next_prob * cumulative_prob));
                }
            // throwSequence.remove(stone);
        }
        return tList;
    }
}
