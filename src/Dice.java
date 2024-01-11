import java.util.List;

public class Dice {
    public static String RandomDice() {
        List<String> options = List.of("dist", "bnj", "sheqah", "bara", "dowaq", "three", "four");
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
            case "dist":
                num = 10;
                break;
            case "bnj":
                num = 25;
                break;
            case "sheqah":
                num = 6;
                break;
            case "bara":
                num = 12;
                break;
            case "dowaq":
                num = 2;
                break;
            case "three":
                num = 3;
                break;
            case "four":
                num = 4;
                break;
            case "khal":
                num = 1;
                break;
        }
        return num;
    }

}
