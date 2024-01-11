import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);

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
            new_state = Humanplay(new_state, 1);
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
            new_state = Humanplay(new_state, 2);

            Grid.print_grid(new_state);
            if (new_state.isfinished(2)) {
                System.out.println("player number 1" + "is the Winner");
                break;
            }
        }
    }

    public static State Humanplay(State state, int player) {
        ArrayList<String> dices = Throw();
        State newstate = Choose_move(state, player, dices);
        return newstate;
    }

    public static ArrayList<String> Throw() {
        ArrayList<String> dices = new ArrayList<String>();
        String dice = Dice.RandomDice();
        // خطوة الرمي

        for (int i = 0; i < 10; i++) {
            if (dice == Dice.FOUR || dice == Dice.THREE || dice == Dice.DOWAQ) {
                dices.add(dice);
                break;
            } else if (dice == Dice.BNJ || dice == Dice.DIST) {
                dices.add(dice);
                dices.add(Dice.KHAL);
                dice = Dice.RandomDice();

            } else
                dices.add(dice);
        }
        System.out.println(dices.toString());
        System.out.println();
        return dices;
    }

    public static State Choose_move(State state, int player, ArrayList<String> dices) {

        State new_state = state;
        // ذا كانو حجارو كلن مو مركبين
        if (state.getposition(player, 0)) {
            int old_size = dices.size();
            for (int i = 0; i < dices.size(); i++) {
                if (dices.get(i) == Dice.KHAL) {
                    System.out.println(Dice.KHAL);
                    new_state = Choose_stone(new_state, player, (String) dices.get(i));
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
            if (new_state.isfinished(player)) {
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
                new_state = Choose_stone(new_state, player, (String) dices.get(entry - 1));
                dices.remove(entry - 1);

            }
        }
        return new_state;
    }

    // playing function
    public static State Choose_stone(State state, int player, String dice) {
        boolean[] check = { check(state, Dice.num(dice), state.player(player).getStone1(), player),
                check(state, Dice.num(dice), state.player(player).getStone2(), player),
                check(state, Dice.num(dice), state.player(player).getStone3(), player),
                check(state, Dice.num(dice), state.player(player).getStone4(), player) };
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
                new_state = Choose_stone(state, player, dice);
                return new_state;
        }
        if (check(new_state, Dice.num(dice), stone, player)) {
            new_state = move(new_state, Dice.num(dice), stone, player);
        } else {
            new_state = Choose_stone(state, player, dice);
        }
        return new_state;
    }

    public static State move(State new_state, int result, Position stone, int player) {
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
        new_state.grid(new_state.getplayer1().getpath(), new_state.getplayer2().getpath());
        if (new_position < 42) {
            new_position = new_position + 34;
        } else {
            new_position = new_position - 34;
        }
        if (player == 1) {
            kill(new_state, 2, new_position);
        } else {
            kill(new_state, 1, new_position);
        }
        return new_state;
    }

    public static void kill(State state, int player, int new_position) {
        if (state.player(player).getpath()[new_position] == true) {
            boolean[] path = state.player(player).getpath();
            path[new_position] = false;
            state.player(player).setpath(path);

            for (int i = 1; i <= 4; i++) {
                if (state.player(player).getstonefronum(i).getPosition() == new_position) {
                    state.player(player).getStone1().setPosition(0);
                }
            }
        }
    }

    public static boolean check(State state, int result, Position stone, int player) {
        int[] pro = { 11, 22, 28, 39, 45, 56, 62, 73 };
        int[] grid1 = { 4, 15, 21, 32, 38, 49, 55, 66 };
        boolean can_move = true;
        for (int i = 0; i < 7; i++) {
            int j = grid1[i];
            if (stone.getPosition() + result == pro[i] && state.player(player).getpath()[pro[i]] != true
                    && state.getgrid()[j] != "     ") {
                can_move = false;
                break;
            }
        }
        if ((stone.getPosition() + result) > 84) {
            can_move = false;
        }

        if (state.player(player).getstone(stone).getPosition() == 0) {
            if (result != 1)
                can_move = false;
        }
        return can_move;

    }

}