import java.util.ArrayList;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        State state = State.first_state();
//        Stack a = new Stack();
        Stack<State> a = new Stack<>();
//        state.print_grid();
//
//                 System.out.println("");
//         System.out.println("1ston1"+"   "+state.getplayer1().getStone1().getPosition());
//         System.out.println("1ston2"+"   "+state.getplayer1().getStone2().getPosition());
//         System.out.println("1ston3"+"   "+state.getplayer1().getStone3().getPosition());
//         System.out.println("1ston4"+"   "+state.getplayer1().getStone4().getPosition());
//         System.out.println("2ston1"+"   "+state.getplayer2().getStone1().getPosition());
//         System.out.println("2ston2"+"   "+state.getplayer2().getStone2().getPosition());
//         System.out.println("2ston3"+"   "+state.getplayer2().getStone3().getPosition());
//         System.out.println("2ston4"+"   "+state.getplayer2().getStone4().getPosition());
//
//        System.out.println();
//        state.getplayer2().getStone1().setPosition(10);
State new_state = new State(state);
        new_state.print_grid();
                 System.out.println("");
//         System.out.println("1ston1"+"   "+new_state.getplayer1().getStone1().getPosition());
//         System.out.println("1ston2"+"   "+new_state.getplayer1().getStone2().getPosition());
//         System.out.println("1ston3"+"   "+new_state.getplayer1().getStone3().getPosition());
//         System.out.println("1ston4"+"   "+new_state.getplayer1().getStone4().getPosition());
//         System.out.println("2ston1"+"   "+new_state.getplayer2().getStone1().getPosition());
//         System.out.println("2ston2"+"   "+new_state.getplayer2().getStone2().getPosition());
//         System.out.println("2ston3"+"   "+new_state.getplayer2().getStone3().getPosition());
//         System.out.println("2ston4"+"   "+new_state.getplayer2().getStone4().getPosition());
//     int i=0;
        while (true) {
            System.out.println("");
            System.out.println("1ston1" + "   " + new_state.getplayer1().getStone1().getPosition());
            System.out.println("1ston2" + "   " + new_state.getplayer1().getStone2().getPosition());
            System.out.println("1ston3" + "   " + new_state.getplayer1().getStone3().getPosition());
            System.out.println("1ston4" + "   " + new_state.getplayer1().getStone4().getPosition());
            System.out.println("2ston1" + "   " + new_state.getplayer2().getStone1().getPosition());
            System.out.println("2ston2" + "   " + new_state.getplayer2().getStone2().getPosition());
            System.out.println("2ston3" + "   " + new_state.getplayer2().getStone3().getPosition());
            System.out.println("2ston4" + "   " + new_state.getplayer2().getStone4().getPosition());
            new_state = new_state.play(new_state, 1);
            new_state.print_grid();
//            a.add(new_state);
            System.out.println("");
            System.out.println("1ston1" + "   " + new_state.getplayer1().getStone1().getPosition());
            System.out.println("1ston2" + "   " + new_state.getplayer1().getStone2().getPosition());
            System.out.println("1ston3" + "   " + new_state.getplayer1().getStone3().getPosition());
            System.out.println("1ston4" + "   " + new_state.getplayer1().getStone4().getPosition());
            System.out.println("2ston1" + "   " + new_state.getplayer2().getStone1().getPosition());
            System.out.println("2ston2" + "   " + new_state.getplayer2().getStone2().getPosition());
            System.out.println("2ston3" + "   " + new_state.getplayer2().getStone3().getPosition());
            System.out.println("2ston4" + "   " + new_state.getplayer2().getStone4().getPosition());
            new_state = new_state.play(new_state, 2);
            new_state.print_grid();
//            a.add(new_state);
//            i = i + 2;


        }
//        for(int l=0;l<7;l++)
//        {
//           State state1=a.pop();
//System.out.println();
//            state1.print_grid();
//        }
//        a.remove();









//        System.out.print( state.move(10,state.getplayer1().getStone1()));
//       System.out.print( state.getplayer1().move(1,state.getplayer1().stone2));
//        State s = new State(state);
//        state.play(1);
//       System.out.print(state.Dice());
//     System.out.print(state.move(1,state.play1_stone2,1));
    }}
