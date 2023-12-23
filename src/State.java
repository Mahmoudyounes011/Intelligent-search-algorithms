import java.util.Random;
import java.util.Scanner;

public class State {

    private Player  player1 ;
    private Player  player2 ;
    private  boolean [] grid;
    public State( Player player1 , Player player2,boolean [] grid) {
        this.player1=player1 ;
        this.player2=player2 ;
        this.grid = grid;
    }



    public Player getplayer1()
    {
        return player1;
    }
    public Player getplayer2()
    {
        return player2;
    }
    public boolean [] getgrid()
    {
        return this.grid;
    }
    public void setplayer1(Player player1)
    {
        this.player1 = player1;
    }
    public void setplayer2(Player player2)
    {
        this.player2 = player2;
    }
    public void setplayer2(boolean [] grid)
    {
        this.grid = grid;
    }
    public State(State state) {
        this.grid = new boolean [84];
//        this.player2 = new int [10];
//        player1 = state.player1.clone();
        grid = state.grid.clone();
        this.player1=state.getplayer1();
        this.player2=state.getplayer2();
//        player1.setpath(path1);
//        player2.setpath(path2);

        //        // Deep copy each value in passed array, to current instance of game
//        for(int i=0; i<10; i++)
//        {
//            System.arraycopy(state.player1[i], 0, this.player1[i], 0, player1.length);
//            System.arraycopy(state.player2[i], 0, this.player2[i], 0, player2.length);
//        }
    }
    public boolean[] grid(boolean[] p1,boolean[]p2){
        boolean[] grid = new boolean[84];
        int j=43;
        for(int i=9;i<42;i++) {
            if(p1[i]==true){
            grid[i]=p1[i];}
            if(p2[j]==true){
                grid[i]=p1[j];}
            else {
                grid[i]=false;}
            j++;
        }
         j=6;
        for(int i=43;i<75;i++) {
            if(p1[i]==true){
                grid[i]=p1[i];}
            if(p2[j]==true){
                grid[i]=p1[j];}
            else {
                grid[i]=false;}
        j++;
        }
        if(p1[42]==true || p2[8]==true ||p2[76]==true){
            grid[42]=true;
        }
        else{
            grid[42]=false;
        }
        if(p2[42]==true || p1[8]==true ||p1[76]==true){
            grid[8]=true;
        }
        else{
            grid[8]=false;
        }
        return grid;
    }
    public static State first_state(){
        Position play1_stone1 = new Position();
        Position play1_stone2 = new Position();
        Position play1_stone3 = new Position();
        Position play1_stone4 = new Position();
        Position play2_stone1 = new Position();
        Position play2_stone2 = new Position();
        Position play2_stone3 = new Position();
        Position play2_stone4 = new Position();
        boolean[] path1=new boolean[84];
        boolean[] path2= new boolean[84];

        boolean [] grid = new boolean[84];
        for (int i = 1; i < 84; i++) {
            path1[i] =false;
            path2[i] =false;
            grid[i] = false;
        }
        Player player1 = new Player (play1_stone1,play1_stone2,play1_stone3,play1_stone4,path1);
        Player player2 = new Player (play2_stone1,play2_stone2,play2_stone3,play2_stone4,path2);
//        player1.setpath(path1);
//        player2.setpath(path2);
        return new State(player1,player2 , grid);
    }
    public  void print_grid(){
        int i3=8;
        int i1=9;
        int i2=75;
        boolean [] bourd1;
        bourd1 =player1.getpath();
//        bourd1 =grid( player1.getpath(), player2.getpath());
        for (int i = 1; i < 9; i++) {
           System.out.println("                                               "+bourd1[i1]+"    "+bourd1[i]+"    "+bourd1[i2]);
            i1++;
            i2++;
            i3--;
        }
        i1=24;
        i3=67;
        for (int i = 1; i < 9; i++) {
            System.out.print(bourd1[i1]+" ");
            i1--;

        }
        System.out.print("                       ");
        for (int i = 1; i < 9; i++) {
            System.out.print(bourd1[i3]+" ");
            i3--;

        }
        System.out.println();
        System.out.println(bourd1[25]+"                                                                                                            "+bourd1[59]);
        i1=26;
        i3=51;
        for (int i = 1; i < 9; i++) {
            System.out.print(bourd1[i1]+" ");
            i1--;

        }
        System.out.print("                       ");
        for (int i = 1; i < 9; i++) {
            System.out.print(bourd1[i3]+" ");
            i3--;
        }
        i1=26;
        i2=50;
        System.out.println();
        for (int i = 1; i < 8; i++) {
            System.out.println("                                               "+bourd1[i1]+"             "+bourd1[i2]);
            i1++;
            i2--;
        }
        System.out.println("                                               "+bourd1[75]+"    "+bourd1[42]+"    "+bourd1[43]);


//        boolean [] bourd2;
//        bourd2 = this.player2.getpath();
//        for (int i = 1; i < 84; i++) {
////            if(bourd1[i]==true){
////                this.grid[i]=true;
////            }
////            else if(bourd2[i]==true){
////                this.grid[i]=true;
////            }
////            else{
////                this.grid[i]=false;
////            }
//            System.out.print(bourd1[i]+"  ");
//        }
//        System.out.println();
//        for (int i = 1; i < 84; i++) {
////            if(bourd1[i]==true){
////                this.grid[i]=true;
////            }
////            else if(bourd2[i]==true){
////                this.grid[i]=true;
////            }
////            else{
////                this.grid[i]=false;
//            }


//            System.out.print(bourd2[i]+"  ");
//        }

    }
    public String Dice(){
        String[] values = {"دست", "شكة", "دواق",  "تلاتة" ,"اربعة","بنج","بارا"} ;
        Random random = new Random();
        int index = random.nextInt(values.length);
        return values[index];
    }
    public State play(State state ,Player player){
        String dice = Dice();
        boolean [] cheak= {cheak (num(dice),player.getStone1()),cheak (num(dice),player.getStone2()),
                cheak (num(dice),player.getStone3()),cheak (num(dice),player.getStone4()) };
        System.out.println("you can move  this stone");
        for(int i=0; i<4;i++){
            if(cheak[i]==true){
                System.out.println("cleak "+(i+1)+"if youwant to move stone num"+(i+1));
            }}
        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        Position stone = null;
        switch (entry) {
            case 1:
                stone =player.getStone1();
                break;
            case 2:
                stone= player.getStone2();
                break;
            case 3:
                stone =player.getStone3();
                break;
            case 4:
                stone =player.getStone4();
                break;
        }

        //استدعاء تابع التحريك


State new_state =    move(state , num(dice),stone, player);
return new_state;
//        stone.setPosition(10);
//        System.out.print(this.move(1,stone ));


    }
    public State move(State state, int result ,Position stone , Player player){
        System.out.println(result);
        int old_position =stone.getPosition();
        int new_position = old_position + result;
//        System.out.println(old_position);
        stone.setPosition(new_position);
//        grid[(stone.getPosition())]=true;

        boolean path []= player.getpath();
        path[new_position] = true;
        if(new_position>=8){
        grid[new_position]=true;
        }
        if(player.getStone1().getPosition() !=old_position && player.getStone2().getPosition() !=old_position && player.getStone3().getPosition() !=old_position  && player.getStone4().getPosition() !=old_position ) {
            path[old_position] = false;
            grid[new_position]=false;
        }
        State new_state = new State(state);
        new_state.player(player).setpath(path);
        return new_state;
//            grid[(old_position)]= false;
//        }

    }

//    private Player player(Player player) {
//
//    }

    public Player player (Player player){
        if(player == this.player1)
            return player1;
        else return player2;
    }
//    public State change(State state , int old_position ,int new_position){
////        boolean path []= player.getpath();
////        path[new_position] = true;
////        player.setpath(path);
//    }
    public boolean cheak(int result,Position stone ){
        int [] pro ={11,22,28,39,45,56,62,73};
        boolean can_move  = true;
//        stone.setPosition(10);
//        System.out.println(stone.getPosition());
//        System.out.println(stone.getPosition()+result);

        for(int i=0 ; i<7; i++){
            if(stone.getPosition()+result == pro[i] )
            {
//                System.out.println(pro[i] + "t");
                can_move = false;
//                System.out.println(pro[i] + "f");
                break;

            }}

//            for(int p :pro){
//                if((stone.getPosition()+result)==p && player1.getpath()[(stone.getPosition()+result+34)]==true);
//                {
//                    can_move = false;
//                    break;
//                }}


//        if((stone.getPosition()+result)>83){
//            can_move = false;
//        }


        return can_move;
    }


    public int num(String result){
        int num =0;
        switch (result) {
            case"دست":
                num=10;
                break;
            case"خال":
                num=1;
                break;
            case"بنج":
                num=24;
                break;
            case"شكة":
                num=6;
                break;
            case"دواق":
                num=2;
                break;
            case"تلاتة":
                num=3;
                break;
            case"اربعة":
                num=4;
                break;
            case"بارا":
                num=12;
                break;



        }
        return num;
    }

////    public State  state(State state)
////    {
////        return state;
////    }
//    public String Dice(){
//        String[] values = {"دست", "شكة", "دواق",  "تلاتة" ,"اربعة","بنج","بارا"} ;
//        Random random = new Random();
//        int index = random.nextInt(values.length);
//        return values[index];
//    }
//public void play(int player){
//    String dice = Dice();
//   boolean [] cheak= {move(num(dice),play1_stone1,1),move(num(dice),play1_stone2,1),
//   move(num(dice),play1_stone3,1),
//move(num(dice),play1_stone4,1)};
//    System.out.println("you can move this stone");
//   for(int i=0; i<4;i++){
//       if(cheak[i]==true){
//           System.out.println("cleak "+(i+1)+"if youwant to move stone num"+(i+1));
//       }}
//    Scanner scanner = new Scanner(System.in);
//    int stone = scanner.nextInt();
//    Position move = null;
//    switch (stone) {
//        case 1:
//            if(player==1)
//                move =play1_stone1;
//            else
//                move =play2_stone1;
//            break;
//        case 2:
//            if(player==1)
//                move =play1_stone2;
//            else
//                move =play2_stone2;
//            break;
//        case 3:
//            if(player==1)
//                move =play1_stone3;
//            else
//                move =play2_stone3;
//            break;
//        case 4:
//            if(player==1)
//                move =play1_stone4;
//            else
//                move =play2_stone4;
//            break;
//    }
//
//    //استدعاء تابع التحريك
////    move(num(dice),move, player);
//
//     move.setPosition(10);
//    System.out.print(this.move(1,move,1));
//
//
//    }
//
//    public boolean move(int result,Position stone,int player){
//        int [] pro ={11,22,28,39,45,56,62,73};
//        boolean can_move = true;
////        stone.setPosition(10);
////        System.out.println(stone.getPosition());
//        for(int p :pro){
//
//        if((stone.getPosition()+result)==p && player2[(stone.getPosition()+result+34)]==1)
//        {
//             can_move = false;
//          break;
//}}
//        if((stone.getPosition()+result)>83){
//            can_move = false;
//        }
//        return can_move;
//    }
//
//public int num(String result){
//int num =0;
//    switch (result) {
//        case"دست":
//            num=10;
//            break;
//        case"خال":
//            num=1;
//            break;
//        case"بنج":
//            num=24;
//            break;
//        case"شكة":
//            num=6;
//            break;
//        case"دواق":
//            num=2;
//            break;
//        case"تلاتة":
//            num=3;
//            break;
//        case"اربعة":
//            num=4;
//            break;
//        case"بارا":
//            num=12;
//            break;
//
//
//
//}
//    return num;
//    }
//
//
//
}
