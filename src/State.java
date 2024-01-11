import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    // get random value
    public static String Dice() {
        List<String> options = List.of("دست", "دواق", "تلاتة", "اربعة", "بارا", "شكة", "بنج");
        List<Double> probabilities = List.of(0.2, 0.1, 0.2, 0.1, 0.1, 0.2, 0.1);
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
    public int num(String result) {
        int num = 0;
        switch (result) {
            case "دست":
                num = 10;
                break;
            case "خال":
                num = 1;
                break;
            case "بنج":
                num = 24;
                break;
            case "شكة":
                num = 6;
                break;
            case "دواق":
                num = 2;
                break;
            case "تلاتة":
                num = 3;
                break;
            case "اربعة":
                num = 4;
                break;
            case "بارا":
                num = 12;
                break;
        }
        return num;
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

    // rolling the dice
    public static void play() {
        State state = State.first_state();
        State new_state = new State(state);
        Grid.print_grid(new_state);
        while (true) {
            System.out.println("");
            System.out.println("player 1 stone 1" + "   " + new_state.getplayer2().getStone1().getPosition());
            System.out.println("player 1 stone 2" + "   " + new_state.getplayer2().getStone2().getPosition());
            System.out.println("player 1 stone 3" + "   " + new_state.getplayer2().getStone3().getPosition());
            System.out.println("player 1 stone 4" + "   " + new_state.getplayer2().getStone4().getPosition());
            System.out.println("player 2 stone 1" + "   " + new_state.getplayer1().getStone1().getPosition());
            System.out.println("player 2 stone 2" + "   " + new_state.getplayer1().getStone2().getPosition());
            System.out.println("player 2 stone 3" + "   " + new_state.getplayer1().getStone3().getPosition());
            System.out.println("player 2 stone 4" + "   " + new_state.getplayer1().getStone4().getPosition());
            System.out.println("player 1");
            new_state = new_state.Throw(new_state, 1);
            Grid.print_grid(new_state);
            if (new_state.isfinished(1)) {
                System.out.println("player number 2" + "the Winner");
                break;
            }

            System.out.println("");
            System.out.println("player 1 stone 1" + "   " + new_state.getplayer2().getStone1().getPosition());
            System.out.println("player 1 stone 2" + "   " + new_state.getplayer2().getStone2().getPosition());
            System.out.println("player 1 stone 3" + "   " + new_state.getplayer2().getStone3().getPosition());
            System.out.println("player 1 stone 4" + "   " + new_state.getplayer2().getStone4().getPosition());
            System.out.println("player 2 stone 1" + "   " + new_state.getplayer1().getStone1().getPosition());
            System.out.println("player 2 stone 2" + "   " + new_state.getplayer1().getStone2().getPosition());
            System.out.println("player 2 stone 3" + "   " + new_state.getplayer1().getStone3().getPosition());
            System.out.println("player 2 stone 4" + "   " + new_state.getplayer1().getStone4().getPosition());

            System.out.println("player 2");
            new_state = new_state.Throw(new_state, 2);

            Grid.print_grid(new_state);
            if (new_state.isfinished(2)) {
                System.out.println("player number 1" + "is the Winner");
                break;
            }
        }
    }

    public State Throw(State state, int player) {
        ArrayList dices = new ArrayList<String>();
        String dice = Dice();
        // خطوة الرمي
        for (int i = 0; i < 10; i++) {
            if (dice == "اربعة" || dice == "تلاتة" || dice == "دواق") {
                dices.add(dice);
                break;
            } else if (dice == "بنج" || dice == "دست") {
                dices.add(dice);
                dices.add("خال");
                dice = Dice();

            } else
                dices.add(dice);
        }
        System.out.println(dices.toString());
        // for ( int i = 0; i < dices.size(); i++) {
        // System.out.print(dices.get(i) +" , ");
        // }
        System.out.println();
        State new_state = state;
        // ذا كانو حجارو كلن مو مركبين
        if (state.player(player).getStone1().getPosition() == 0 && state.player(player).getStone2().getPosition() == 0
                && state.player(player).getStone3().getPosition() == 0
                && state.player(player).getStone4().getPosition() == 0) {
            int old_size = dices.size();
            for (int i = 0; i < dices.size(); i++) {
                if (dices.get(i) == "خال") {
                    System.out.println("خال");
                    new_state = new_state.Human_play(new_state, player, (String) dices.get(i));
                    dices.remove(i);
                    break;
                }
            }
            int new_size = dices.size();
            if (old_size == new_size) {
                System.out.println("you cant move");
                return state;
            }
        }
        while (!dices.isEmpty()) {
            if (this.isfinished(player)) {
                System.out.println("player number " + player + "the Winner");
                return new_state;
            }
            // طباعة الخيارات
            for (int i = 0; i < dices.size(); i++) {
                System.out.println(dices.get(i) + "  " + (i + 1));
            }
            int entry = scanner.nextInt();
            if (entry >= 1 && entry < dices.size() + 1) {

                System.out.println(dices.get(entry - 1));
                new_state = new_state.Human_play(new_state, player, (String) dices.get(entry - 1));
                dices.remove(entry - 1);

            }
        }
        return new_state;
    }

    // playing function
    public State Human_play(State state, int player, String dice) {
        boolean[] check = { this.check(num(dice), this.player(player).getStone1(), player),
                this.check(num(dice), this.player(player).getStone2(), player),
                this.check(num(dice), this.player(player).getStone3(), player),
                this.check(num(dice), this.player(player).getStone4(), player) };
        System.out.println("you can move this stone");
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (check[i] == true) {
                System.out.println("Click " + (i + 1) + " if you want to move the stone number" + (i + 1));
            } else {
                count++;
            }
        }
        if (count == 4) {
            System.out.println("you cant move any stone ");

            return state;
        }
        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        Position stone = new Position();
        State new_state = new State(state);
        switch (entry) {
            case 1:
                stone = new_state.player(player).getStone1();
                break;
            case 2:
                stone = new_state.player(player).getStone2();
                break;
            case 3:
                stone = new_state.player(player).getStone3();
                break;
            case 4:
                stone = new_state.player(player).getStone4();
                break;
            default:
                new_state = this.Human_play(state, player, dice);
                return new_state;
        }
        if (new_state.check(num(dice), stone, player)) {
            new_state = move(new_state, num(dice), stone, player);
        } else {
            new_state = this.Human_play(state, player, dice);
        }
        return new_state;
    }

    public State move(State new_state, int result, Position stone, int player) {
        int old_position = stone.getPosition();
        int new_position = old_position + result;
        new_state.player(player).getstone(stone).setPosition(new_position);
        boolean path[] = new_state.player(player).getpath();
        path[new_position] = true;

        for (int i = 1; i <= 4; i++) {
            if (new_state.player(player).getstonefronum(i).getPosition() == old_position) {
                break;
            }
            if (i == 4) {
                path[old_position] = false;
            }

        }
        if (new_state.player(player).getStone1().getPosition() != old_position
                && new_state.player(player).getStone2().getPosition() != old_position
                && new_state.player(player).getStone3().getPosition() != old_position
                && new_state.player(player).getStone4().getPosition() != old_position) {
            path[old_position] = false;
        }
        new_state.player(player).setpath(path);
        new_state.grid(new_state.player1.getpath(), new_state.player2.getpath());
        if (new_position < 42) {
            new_position = new_position + 34;
        } else {
            new_position = new_position - 34;
        }
        if (player == 1) {
            new_state.kill(2, new_position);
        } else {
            new_state.kill(1, new_position);
        }
        return new_state;
    }

    public void kill(int player, int new_position) {
        if (this.player(player).getpath()[new_position] == true) {
            boolean[] path = this.player(player).getpath();
            path[new_position] = false;
            this.player(player).setpath(path);
            for (int i = 1; i <= 4; i++) {
                if (this.player(player).getstonefronum(i).getPosition() == new_position) {
                    this.player(player).getStone1().setPosition(0);
                }
            }
        }
    }

    public boolean check(int result, Position stone, int player) {
        int[] pro = { 11, 22, 28, 39, 45, 56, 62, 73 };
        int[] grid1 = { 4, 15, 21, 32, 38, 49, 55, 66 };
        boolean can_move = true;
        for (int i = 0; i < 7; i++) {
            int j = grid1[i];
            if (stone.getPosition() + result == pro[i] && player(player).getpath()[pro[i]] != true
                    && getgrid()[j] != "     ") {
                can_move = false;
                break;
            }
        }
        if ((stone.getPosition() + result) > 84) {
            can_move = false;
        }

        if (this.player(player).getstone(stone).getPosition() == 0) {
            if (result != 1)
                can_move = false;
        }
        return can_move;

    }

    public ArrayList<State> nextstate(State state, ArrayList<String> dices) {
        ArrayList<State> previousStates = new ArrayList<State>();
        ArrayList<State> movable = new ArrayList<State>();

        for (String dString : dices) {
            if (previousStates.isEmpty()) {
                for (int stoneNumber = 1; stoneNumber <= 4; stoneNumber++) {
                    State tempState = new State(state);
                    if (tempState.check(num(dString), tempState.player2.getstonefronum(stoneNumber), 2)) {
                        tempState = new State(
                                tempState.move(tempState, num(dString),
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
