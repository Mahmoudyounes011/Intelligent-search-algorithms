import java.util.*;

public class State {
    private Player player1;
    private Player player2;
    private String[] grid;
    Scanner scanner = new Scanner(System.in);

    public State(Player player1, Player player2, String[] grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.grid = grid;
    }

    // Deep copy
    public State(State state) {
        this.grid = state.grid.clone();
        this.player1 = new Player(state.getplayer1());
        this.player2 = new Player(state.getplayer2());
    }

    // getter && setter
    public Player getplayer1() {
        return player1;
    }

    public Player getplayer2() {
        return player2;
    }

    public String[] getgrid() {
        return this.grid;
    }

    public void setplayer1(Player player1) {
        this.player1 = player1;
    }

    public void setplayer2(Player player2) {
        this.player2 = player2;
    }

    public void setplayer2(String[] grid) {
        this.grid = grid;
    }

    // returns the player by his number
    public Player player(int player) {
        if (player == 2)
            return this.player2;
        else
            return this.player1;
    }

    // join path of player1 with path of player2
    public String[] grid(boolean[] p1, boolean[] p2) {
        String[] grid = this.grid;
        int j = 43;
        int k = 2;
        for (int i = 9; i < 42; i++) {
            if (p1[i]) {
                grid[k] = "   X ";
            } else if (p2[j]) {
                grid[k] = "  O  ";
            } else {
                grid[k] = "     ";
            }
            j++;
            k++;
        }
        j = 9;
        k = 36;
        for (int i = 43; i < 75; i++) {
            if (p1[i]) {
                grid[k] = "  X  ";
            } else if (p2[j]) {
                grid[k] = "  O  ";
            } else {
                grid[k] = "     ";
            }
            j++;
            k++;
        }

        if (p1[42]) {
            grid[35] = "  X  ";
        } else if (p2[8] || p2[76]) {
            grid[35] = "  O  ";
        } else {
            grid[35] = "     ";
        }
        if (p2[42]) {

            grid[1] = "  X  ";
        } else if (p1[8] || p1[76]) {
            grid[1] = "  O  ";
        } else {
            grid[1] = "     ";
        }
        this.grid = grid;
        return grid;
    }

    public static State first_state() {
        Position play1_stone1 = new Position();
        Position play1_stone2 = new Position();
        Position play1_stone3 = new Position();
        Position play1_stone4 = new Position();
        Position play2_stone1 = new Position();
        Position play2_stone2 = new Position();
        Position play2_stone3 = new Position();
        Position play2_stone4 = new Position();
        boolean[] path1 = new boolean[85];
        boolean[] path2 = new boolean[85];

        String[] grid = new String[85];
        for (int i = 1; i < 85; i++) {
            path1[i] = false;
            path2[i] = false;
            grid[i] = "     ";
        }
        Player player1 = new Player(play1_stone1, play1_stone2, play1_stone3, play1_stone4, path1);
        Player player2 = new Player(play2_stone1, play2_stone2, play2_stone3, play2_stone4, path2);
        return new State(player1, player2, grid);
    }

    public boolean isfinished(int player) {
        int j = 0;
        for (int i = 1; i < 5; i++) {
            if (this.player(player).getstonefronum(i).getPosition() == 84) {
                j++;
            }
        }
        if (j == 4)
            return true;
        return false;
    }

    public boolean getposition(int player, int num) {
        boolean result = true;
        for (int i = 0; i <= 4; i++) {
            if (this.player(player).getstonefronum(i).getPosition() != num) {
                return false;

            }
        }
        return result;
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

    public ArrayList<State> nextstate(State state, ArrayList<String> dices) {
        ArrayList<State> previousStates = new ArrayList<State>();
        ArrayList<State> movable = new ArrayList<State>();

        for (String dString : dices) {
            if (previousStates.isEmpty()) {
                for (int stoneNumber = 1; stoneNumber <= 4; stoneNumber++) {
                    State tempState = new State(state);
                    if (tempState.check(Dice.num(dString), tempState.player2.getstonefronum(stoneNumber), 2)) {
                        tempState = new State(
                                tempState.move(tempState, Dice.num(dString),
                                        tempState.player2.getstonefronum(stoneNumber), 2));
                        previousStates.add(tempState);
                    }
                }
                continue;
            }
            if (dices.size() == 1) {
                movable.addAll(previousStates);
                return movable;
            }
            if (!previousStates.isEmpty()) {
                ArrayList<State> tempPreviousState = new ArrayList<>();
                for (State ps : previousStates) {
                    for (int stoneNumber = 1; stoneNumber <= 4; stoneNumber++) {
                        State tempState = new State(ps);
                        if (tempState.check(num(dString),
                                tempState.player2.getstonefronum(stoneNumber), 2)) {
                            tempState = new State(
                                    tempState.move(tempState, num(dString),
                                            tempState.player2.getstonefronum(stoneNumber), 2));
                            tempPreviousState.add(tempState);
                        }
                    }
                }
                previousStates.clear();
                previousStates.addAll(tempPreviousState);
            }
        }
        movable.addAll(previousStates);
        return movable;
    }
}