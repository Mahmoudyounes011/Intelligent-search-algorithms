public class forme {
//    public State dest(State new_state , int player){
//        System.out.println("خال");
//        new_state = new_state.Human_play(new_state, player, "خال");
//        System.out.println("دست");
//        new_state = new_state.Human_play(new_state, player, "دست");
//        return new_state;
//    }
//    public State banj(State new_state , int player){
//        System.out.println("خال");
//        new_state = new_state.Human_play(new_state, player, "خال");
//        System.out.println("بنج");
//        new_state = new_state.Human_play(new_state, player, "بنج");
//        return new_state;
//    }



    //print board
//public void row ( boolean  board1,boolean  board2,boolean  board3){
//    System.out.println("                                                       | " + board1 +"   |  "  + board2 + "  |  "  + board3+" |");
//    System.out.println("                                                       "+"|_________|_________|________|"+"                                               ");
//
//    }
//    public void col ( boolean  board1){
// System.out.print(board1+"| ");
//
//    }
//    public void col1 (){
////        System.out.print(board1+"| ");
//        System.out.println("|_____|______|______|______|______|______|______|______|                            |_____|______|______|______|______|______|______|______|");
//
//    }
//    public  void print_grid(){
//        int i3=7;
//        int i1=3;
//        int i2=67;
//        int i4=77;
//        boolean [] board1;
//        boolean [] board2;
//        board2 =this.player1.getpath();
//        boolean [] board3;
//        board3 =this.player2.getpath();
//        board1 =this.grid( this.player1.getpath(), this.player2.getpath());
//        System.out.println("                                                       "+"_____________________________"+"                                               ");
//        row(board1[2] ,board1[1],board1[68]);
//        for (int i = 1; i < 8; i++) {
//            if(board2[i3]==true|| board2[i4]==true ) {
//                row(board1[i1] ,true,board1[i2]);
//            }
//            else {
//                row(board1[i1] ,false,board1[i2]);
//            }
//            i1++;
//            i2--;
//            i3--;
//            i4++;
//        }
//        i1=17;
//        i3=60;
//        System.out.print("|");
//        for (int i = 1; i < 9; i++) {
//            col(board1[i1]);
//            i1--;
//        }
//        System.out.print("                           |");
//        for (int i = 1; i < 9; i++) {
//            col(board1[i3]);
//            i3--;
//        }
//        System.out.println();
//         col1();
//        System.out.println("|"+board1[18]+"|      |      |      |      |      |      |      |                            |     |      |      |      |      |      |      |"+board1[52]+" |");
//        col1();
//        i1=19;
//        i3=44;
//        System.out.print("|");
//        for (int i = 1; i < 9; i++) {
//            col(board1[i1]);
//            i1++;
//        }
//        System.out.print("                           |");
//        for (int i = 1; i < 9; i++) {
//            col(board1[i3]);
//            i3++;
//        }
//        i1=27;
//        i2=43;
//        i4=83;
//        System.out.println();
//        col1();
//        for (int i = 1; i < 8; i++) {
//            if(board3[i]==true|| board3[i4]==true ) {
//                row(board1[i1],true,board1[i2]);
//            }
//            else {
//               row(board1[i1],false,board1[i2]);
//            }
//            i1++;
//            i2--;
//            i4--;
//        }
//       row(board1[75],board1[35],board1[43]);
//    }
    //first state



//    public boolean position(Position stone, int player , int value){
//        return this.player(player).getStone3().getPosition() == value;
//
//    }
}
