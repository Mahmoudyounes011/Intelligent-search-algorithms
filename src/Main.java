import java.util.*;

public class Main {
        public static void main(String[] args) {
                State state = State.first_state();
                // Grid.print_grid(state);
                ArrayList<String> dices = new ArrayList<>();
                ArrayList<State> movable = new ArrayList<>();
                dices.add("khal");
                dices.add("khal");
                dices.add("dist");
                movable = State.nextstate(state, dices);
                for (State m : movable) {
                        // Grid.print_grid(m);
                        System.out.println("#".repeat(20));
                        System.out.println("player 2 stone 1" + " " +
                                        m.getplayer2().getStone1().getPosition());
                        System.out.println("player 2 stone 2" + " " +
                                        m.getplayer2().getStone2().getPosition());
                        System.out.println("player 2 stone 3" + " " +
                                        m.getplayer2().getStone3().getPosition());
                        System.out.println("player 2 stone 4" + " " +
                                        m.getplayer2().getStone4().getPosition());

                }
        }
}
