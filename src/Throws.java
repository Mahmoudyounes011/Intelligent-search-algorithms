
// import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Throws {
    static String[] stones = { "dist", "bnj", "sheqah", "bara", "dowaq", "three", "four" };
    static HashMap<String, Double> stone_probabilities = new HashMap<>();

    public static HashSet<ArrayList<String>> generateThrows(int current,
            ArrayList<String> throwSequence, HashSet<ArrayList<String>> tList,
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
            if (cumulative_prob > 0.0001) {
                ArrayList<ArrayList<String>> permutations = getPermutations(throwSequence);
                for (ArrayList<String> p : permutations) {
                    tList.add(p);
                }
            }
            return tList;
        }
        for (String stone : stones) {
            double next_prob = stone_probabilities.get(stone);
            if (cumulative_prob * next_prob > 0.0001)
                if (stone == "dist" || stone == "bnj" || stone == "sheqah" || stone == "bara") {
                    ArrayList<String> throwItem = new ArrayList<String>();
                    throwItem.addAll(throwSequence);
                    throwItem.add(stone);
                    if (stone == "dist" || stone == "bnj") {
                        throwItem.add("khal");
                    }
                    generateThrows(current + 1, throwItem, tList, cumulative_prob * next_prob);
                } else {
                    ArrayList<String> throwItem = new ArrayList<String>();
                    throwItem.addAll(throwSequence);
                    throwItem.add(stone);
                    ArrayList<ArrayList<String>> permutations = getPermutations(throwItem);
                    for (ArrayList<String> p : permutations) {
                        tList.add(p);
                    }
                }
        }
        return tList;
    }

    public static void serilize() {
        HashSet<ArrayList<String>> throwsList = Throws.generateThrows(0, new ArrayList<String>(),
                new HashSet<ArrayList<String>>(), 1);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.ser"))) {
            out.writeObject(throwsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashSet<ArrayList<String>> getThrows() {
        HashSet<ArrayList<String>> throwsList = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("result.ser"))) {
            throwsList = (HashSet<ArrayList<String>>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return throwsList;
    }

    public static ArrayList<ArrayList<String>> getPermutations(ArrayList<String> elements) {
        ArrayList<ArrayList<String>> permutations = new ArrayList<>();
        generatePermutations(elements, 0, permutations);
        return permutations;
    }

    private static void generatePermutations(ArrayList<String> elements, int currentIndex,
            ArrayList<ArrayList<String>> permutations) {
        if (currentIndex == elements.size() - 1) {
            permutations.add(new ArrayList<>(elements));
            return;
        }
        for (int i = currentIndex; i < elements.size(); i++) {
            // Swap the current element with the element at index i
            Collections.swap(elements, currentIndex, i);
            // Recursively generate permutations for the remaining elements
            generatePermutations(elements, currentIndex + 1, permutations);
            // Undo the swap to backtrack
            Collections.swap(elements, currentIndex, i);
        }
    }
}
