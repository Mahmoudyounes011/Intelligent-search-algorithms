import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dice {
    public static final String DIST = "dist";
    public static final String BNJ = "bnj";
    public static final String SHEQAH = "sheqah";
    public static final String BARA = "bara";
    public static final String DOWAQ = "dowaq";
    public static final String THREE = "three";
    public static final String FOUR = "four";
    public static final String KHAL = "khal";

    public static final HashMap<String, Double> PROBABILITIES = new HashMap<>() {
        {
            putIfAbsent(Dice.DIST, 0.186624);
            putIfAbsent(Dice.BNJ, 0.0368864);
            putIfAbsent(Dice.SHEQAH, 0.046656);
            putIfAbsent(Dice.BARA, 0.004096);
            putIfAbsent(Dice.DOWAQ, 0.31104);
            putIfAbsent(Dice.THREE, 0.27648);
            putIfAbsent(Dice.FOUR, 0.13824);
            putIfAbsent(Dice.KHAL, 1.0);

        }
    };

    public static String RandomDice() {

        List<String> options = List.of(Dice.DIST, Dice.BNJ, Dice.SHEQAH, Dice.BARA, Dice.DOWAQ, Dice.THREE, Dice.FOUR);
        List<Double> probabilities = List.of(0.186624, 0.0368864, 0.046656, 0.004096, 0.31104, 0.27648, 0.13824);
        double rand = Math.random();
        double cumulativeProb = 0;
        for (int i = 0; i < options.size(); i++) {
            cumulativeProb += probabilities.get(i);
            if (rand <= cumulativeProb) {
                return options.get(i);
            }
        }

        return null;
    }

    // returns the number of cells to move
    public static int num(String result) {
        int num = 0;
        switch (result) {
            case Dice.DIST:
                num = 10;
                break;
            case Dice.BNJ:
                num = 25;
                break;
            case Dice.SHEQAH:
                num = 6;
                break;
            case Dice.BARA:
                num = 12;
                break;
            case Dice.DOWAQ:
                num = 2;
                break;
            case Dice.THREE:
                num = 3;
                break;
            case Dice.FOUR:
                num = 4;
                break;
            case Dice.KHAL:
                num = 1;
                break;
        }
        return num;
    }

    public static double getDiceProbability(ArrayList<String> dices) {
        double value = 1;
        for (String diceString : dices) {
            value *= Dice.PROBABILITIES.get(diceString);
        }
        return value;
    }
}
