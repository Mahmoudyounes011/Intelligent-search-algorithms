public class Grid {
    public static void row(String board1, String board2, String board3){
//if(board1){
//    String cell1=" * ";
//    String cell2=" * ";
//    String cell3=" * ";
//}
        System.out.println("                                                       | " + board1 +"   |  "  + board2 + "  |  "  + board3+" |");
        System.out.println("                                                       "+"|_________|_________|________|"+"                                               ");

    }
    public static void col(String board1){
        System.out.print(board1+"| ");

    }
    public static void col1(){
//        System.out.print(board1+"| ");
        System.out.println("|_____|______|______|______|______|______|______|______|                            |_____|______|______|______|______|______|______|______|");

    }
    public static void print_grid(State state){
        int i3=7;
        int i1=3;
        int i2=67;
        int i4=77;
        String [] board1;
        boolean [] board2;
        board2 =state.getplayer1().getpath();
        boolean [] board3;
        board3 =state.getplayer2().getpath();
        board1 =state.grid( state.getplayer1().getpath(), state.getplayer2().getpath());
        System.out.println("                                                       "+"_____________________________"+"                                               ");
        row(board1[2] ,board1[1],board1[68]);
        for (int i = 1; i < 8; i++) {
            if(board2[i3]==true|| board2[i4]==true) {
                row(board1[i1] ,"  X  ",board1[i2]);
            }
            else {
                row(board1[i1] ,"     ",board1[i2]);
            }
            i1++;
            i2--;
            i3--;
            i4++;
        }
        System.out.println("_______________________________________________________"+"|                            |"+"_______________________________________________________");

        i1=17;
        i3=60;
        System.out.print("|");
        for (int i = 1; i < 9; i++) {
            col(board1[i1]);
            i1--;
        }
        System.out.print("                           |");
        for (int i = 1; i < 9; i++) {
            col(board1[i3]);
            i3--;
        }
        System.out.println();
        col1();
        System.out.println("|"+board1[18]+"|      |      |      |      |      |      |      |                            |     |      |      |      |      |      |      |"+board1[52]+" |");
        col1();
        i1=19;
        i3=44;
        System.out.print("|");
        for (int i = 1; i < 9; i++) {
            col(board1[i1]);
            i1++;
        }
        System.out.print("                           |");
        for (int i = 1; i < 9; i++) {
            col(board1[i3]);
            i3++;
        }
        i1=27;
        i2=43;
        i4=83;
        System.out.println();
        System.out.println("|_____|______|______|______|______|______|______|______|"+"____________________________"+"|_____|______|______|______|______|______|______|______|");
        for (int i = 1; i < 8; i++) {
            if(board3[i]==true|| board3[i4]==true ) {
                row(board1[i1],"  O  ",board1[i2]);
            }
            else {
                row(board1[i1],"     ",board1[i2]);
            }
            i1++;
            i2--;
            i4--;
        }
        row(board1[34],board1[35],board1[36]);
    }

}
