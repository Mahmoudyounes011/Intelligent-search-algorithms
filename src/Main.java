import java.util.*;

public class Main {
        public static void main(String[] args) {
                Algorithm algorithm = new Algorithm();
                State s = State.first_state();
                Node n = new Node("max", null, s, 1);
                ArrayList<String> dices = new ArrayList<>();
                dices.add(Dice.KHAL);
                dices.add(Dice.BNJ);
                // System.out.println("the possible state");
                // ArrayList<State> states = State.nextstate(s, dices, 2);
                // for (State state : states) {
                // Grid.print_grid(state);
                // }
                n.setThrownDice(dices);
                Node value = algorithm.expectIMinMax(n, 1, dices);
                // System.out.println(value.getState());
                // Grid.print_grid(value.getState());
        }
}
