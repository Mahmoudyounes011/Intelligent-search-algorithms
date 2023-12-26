import java.util.List;
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
//        this.grid = new boolean [84];
//        this.player2 = new int [10];
//        player1 = state.player1.clone();
        this.grid = state.grid.clone();
        this.player1=new Player(state.getplayer1());
        this.player2=new Player(state.getplayer2());
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
        boolean[] grid = new boolean[85];
        int j=43;
        int k=2;
        for(int i=9;i<42;i++) {
            if(p1[i]==true){
            grid[k]=true;}
            else if(p2[j]==true){
                grid[k]=true;}
            else {
                grid[k]=false;}
            j++;
            k++;
        }
         j=9;
        k= 36;
        for(int i=43;i<75;i++) {
            if(p1[i]==true){
                grid[k]=true;}
            else if(p2[j]==true){
                grid[k]=true;}
            else {
                grid[k]=false;}
        j++;
            k++;
        }
        if(p1[42]==true || p2[8]==true ||p2[76]==true){
            grid[35]=true;
        }
        else{
            grid[35]=false;
        }
        if(p2[42]==true || p1[8]==true ||p1[76]==true){
            grid[1]=true;
        }
        else{
            grid[1]=false;
        }
this.grid =grid;
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
        boolean[] path1=new boolean[85];
        boolean[] path2= new boolean[85];

        boolean [] grid = new boolean[85];
        for (int i = 1; i < 85; i++) {
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
        int i3=7;
        int i1=3;
        int i2=67;
        int i4=77;
        boolean [] bourd1;
        boolean [] bourd2;
        bourd2 =this.player1.getpath();
        boolean [] bourd3;
        bourd3 =this.player2.getpath();
        bourd1 =this.grid( this.player1.getpath(), this.player2.getpath());
        System.out.println("                                               " + bourd1[2] + "    " + bourd1[1] + "    " + bourd1[68]);
        for (int i = 1; i < 8; i++) {
            if(bourd2[i3]==true|| bourd2[i4]==true ) {
                System.out.println("                                               " + bourd1[i1] + "    " + "true" + "    " + bourd1[i2]);
            }
            else {
                System.out.println("                                               " + bourd1[i1] + "    " + "false" + "    " + bourd1[i2]);
            }
           i1++;
            i2--;
            i3--;
            i4++;
        }
        i1=17;
        i3=60;
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
        System.out.println(bourd1[18]+"                                                                                                            "+bourd1[52]);
        i1=19;
        i3=44;
        for (int i = 1; i < 9; i++) {
            System.out.print(bourd1[i1]+" ");
            i1++;

        }
        System.out.print("                       ");
        for (int i = 1; i < 9; i++) {
            System.out.print(bourd1[i3]+" ");
            i3++;
        }
        i1=27;
        i2=43;
i4=83;
        System.out.println();
        for (int i = 1; i < 8; i++) {
            if(bourd3[i]==true|| bourd3[i4]==true ) {
                System.out.println("                                               " + bourd1[i1] + "    " + "true" + "    " + bourd1[i2]);
            }
            else {
                System.out.println("                                               " + bourd1[i1] + "    " +"false"+ "    " + bourd1[i2]);
            }
            i1++;
            i2--;
            i4--;
        }
        System.out.println("                                               "+bourd1[75]+"    "+bourd1[35]+"    "+bourd1[43]);
    }
//    public String Dice(){
//        String[] values = {"دست", "شكة", "دواق",  "تلاتة" ,"اربعة","بنج","بارا"} ;
//        Random random = new Random();
//        int index = random.nextInt(values.length);
//        return values[index];
//    }

    public State one(State state ,int player ){
//        int player_num=player;
//        String []  = new String[10];
        String dice = Dice();
        String [] d= new String[10];
        for(int i=0 ; i<10; i++){
            if(dice == "اربعة" || dice =="تلاتة"||dice == "دواق"){
                d[i]=dice;
                break;
            }
            else {
                d[i]=dice;
                dice =Dice();
        }}
        for(int i=0;i<10;i++){
            if(d[i]==null){
                break;
            }
            System.out.print(d[i]+"   ");
        }
        System.out.println();
        State new_state = state;
        for(int i=0;i<10;i++){

                if(d[i]=="دست") {
                    System.out.println("خال");
                    new_state = new_state.play(new_state, player, "خال");
                    System.out.println("دست");
                    new_state = new_state.play(new_state, player, "دست");
                    d[i]=null;
                    break;
                }
                 if(d[i]=="بنج") {
                     System.out.println("خال");
                    new_state = new_state.play(new_state, player, "خال");
                     System.out.println("بنج");
                    new_state = new_state.play(new_state, player, "بنج");
                     d[i]=null;
                     break;
                 }
            }

        for(int i=0;i<10;i++){
            if(d[i]!=null){
//        System.out.println(d[i]);
        if(d[i]=="دست") {
            System.out.println("خال");
            new_state = new_state.play(new_state, player, "خال");
            System.out.println("دست");
             new_state = new_state.play(new_state, player, "دست");
        }
        else if(d[i]=="بنج") {
//            System.out.println(player);
            System.out.println("خال");
              new_state = new_state.play(new_state, player, "خال");
            System.out.println("بنج");
              new_state = new_state.play(new_state, player, "بنج");
        }
        else {
            System.out.println(d[i]);
              new_state = new_state.play(new_state, player, d[i]);
        }   }}

//        System.out.println(new_state.player(player).getStone1().getPosition());

//        else new_state= play(state , player , dice);
    return new_state;
    }
public static <T> T Dice() {
    List<String> options = List.of("دست", "دواق", "تلاتة", "اربعة","بارا","شكة","بنج");
    List<Double> probabilities = List.of(0.4, 0.5, 0.1, 0.1,0.1,0.2,0.3);
    double rand = Math.random();
    double cumulativeProb = 0;
    for (int i = 0; i < options.size(); i++) {
        cumulativeProb += probabilities.get(i);
        if (rand <= cumulativeProb) {
            return (T) options.get(i);
        }
    }

    return null;
}
    public State play(State state ,int player , String dice ){
//        String dice = Dice();
        boolean [] cheak= {this.cheak (num(dice),this.player(player).getStone1(),player),this.cheak (num(dice),this.player(player).getStone2(),player),
                this.cheak (num(dice),this.player(player).getStone3(),player),this.cheak (num(dice),this.player(player).getStone4(),player) };
        System.out.println("you can move  this stone");
       int count =0;
        for(int i=0 ; i<4 ; i++){
//            System.out.println(  cheak[i]);
            if(cheak[i]==true){

                System.out.println("cleak "+(i+1)+"if youwant to move stone num"+(i+1));
            }
            else{
        count++;}
        }
        if(count ==4){
          //add if final
    System.out.println("you cant move any stone ");

            return state;
        }
        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        Position stone = new Position();
        State new_state = new State(state);
        switch (entry) {
            case 1:
                stone =new_state.player(player).getStone1();
                break;
            case 2:
                stone= new_state.player(player).getStone2();
                break;
            case 3:
                stone =new_state.player(player).getStone3();
                break;
            case 4:
                stone =new_state.player(player).getStone4();
                break;
            default:
                new_state.play(new_state , player, dice);
        }
        //استدعاء تابع التحريك
//if(dice=="دست"||dice=="بنج"){}
 new_state = move(new_state , num(dice),stone,player);
return new_state;
    }
//    public Position c (int player){
//        Scanner scanner = new Scanner(System.in);
//        int entry = scanner.nextInt();
//        Position stone = new Position();
////        State new_state = new State(state);
//        switch (entry) {
//            case 1:
//                stone =this.player(player).getStone1();
//                break;
//            case 2:
//                stone= this.player(player).getStone2();
//                break;
//            case 3:
//                stone =this.player(player).getStone3();
//                break;
//            case 4:
//                stone =this.player(player).getStone4();
//                break;
//            default:
//                this.play(new_state , player);
//        }
//    }
    public State move(State new_state, int result ,Position stone , int player){
//        System.out.println(result);
        int old_position =stone.getPosition();
        int new_position = old_position + result;
        new_state.player(player).getstone(stone).setPosition(new_position);
        boolean path []= new_state.player(player).getpath();
        path[new_position] = true;
        if(new_state.player(player).getStone1().getPosition() !=old_position && new_state.player(player).getStone2().getPosition() !=old_position && new_state.player(player).getStone3().getPosition() !=old_position  && new_state.player(player).getStone4().getPosition() !=old_position ) {
            path[old_position] = false;
        }
        new_state.player(player).setpath(path);
//        if(new_position<42)
//            new_position =new_position+34;
//            else
//            new_position =new_position-34;
//            if(player == 1)
//
//                new_state.kill(2,  new_position);
//
//            else
//                new_state.kill(1, new_position);

        return new_state;

    }
public void kill(int player ,int new_position){
        if(this.player(player).getpath()[new_position]==true){
            boolean [] path =this.player(player).getpath();
            path[new_position]=false;
            this.player(player).setpath(path);
            if(this.player(player).getStone1().getPosition()==new_position){
                this.player(player).getStone1().setPosition(0);
            }
            if(this.player(player).getStone2().getPosition()==new_position){
                this.player(player).getStone2().setPosition(0);
            }
            if(this.player(player).getStone3().getPosition()==new_position){
                this.player(player).getStone3().setPosition(0);
            }
            if(this.player(player).getStone4().getPosition()==new_position){
                this.player(player).getStone4().setPosition(0);
            }
        }
}
    public Player player (int player){
        if(player == 2)
            return this.player2;
        else  return this.player1;
    }
    public boolean cheak(int result,Position stone, int player ){
        int [] pro ={11,22,28,39,45,56,62,73};
        int [] grid1 ={4,15,21,32,38,49,55,66};
        boolean can_move  = true;
        for(int i=0 ; i<7; i++){
            int j =grid1[i];
            if(stone.getPosition()+result == pro[i] && player(player).getpath()[pro[i]]!=true  && getgrid()[j]==true )
            {
                can_move = false;
                break;
            }
        }
        if((stone.getPosition()+result)>84){
            can_move = false;
        }

       if(this.player(player).getstone(stone).getPosition()==0 ){
           if( result==1)
           can_move=true;
           else
               can_move=false;
//           System.out.println(player +stone.getPosition());
       }
//       else if(this.player(player).getstone(stone).getPosition()==0){
//           can_move=false;
//       }
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

}
