import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                // State.play();
                State state = State.first_state();
                // Grid.print_grid(state);
                ArrayList<String> movable = new ArrayList<>();
                movable.add("خال");
                movable.add("خال");

                ArrayList<State> movable1 = new ArrayList<>();
                movable1 = state.nextstate(state, movable);
                // System.out.println(movable);
                for (State movables : movable1) {
                        Grid.print_grid(movables);
                }
        }
}
