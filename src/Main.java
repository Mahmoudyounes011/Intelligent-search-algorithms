// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        State state = State.first_state();
        state.print_grid();
     while (true){
         System.out.println("");
         System.out.println("1ston1"+"   "+state.getplayer1().getStone1().getPosition());
         System.out.println("1ston2"+"   "+state.getplayer1().getStone2().getPosition());
         System.out.println("1ston3"+"   "+state.getplayer1().getStone3().getPosition());
         System.out.println("1ston4"+"   "+state.getplayer1().getStone4().getPosition());
         System.out.println("2ston1"+"   "+state.getplayer2().getStone1().getPosition());
         System.out.println("2ston2"+"   "+state.getplayer2().getStone2().getPosition());
         System.out.println("2ston3"+"   "+state.getplayer2().getStone3().getPosition());
         System.out.println("2ston4"+"   "+state.getplayer2().getStone4().getPosition());
         State new_state=  state.play(state ,state.getplayer1());
         new_state.print_grid();
        new_state=  state.play(state ,state.getplayer2());
         new_state.print_grid();
//        System.out.print( state.move(10,state.getplayer1().getStone1()));
//       System.out.print( state.getplayer1().move(1,state.getplayer1().stone2));
//        State s = new State(state);
//        state.play(1);
//       System.out.print(state.Dice());
//     System.out.print(state.move(1,state.play1_stone2,1));
    }
}}