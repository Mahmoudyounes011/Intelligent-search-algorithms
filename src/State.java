import java.util.Random;
import java.util.Scanner;

public class State {

    private int [] player1;
    private int [] player2;
    private Position play1_stone1;
    public Position play1_stone2;
    public Position play1_stone3;
    public Position play1_stone4;
    public Position play2_stone1;
    public Position play2_stone2;
    public Position play2_stone3;
    public Position play2_stone4;

    public State( int [] player1,int [] player2) {
        this.player1=player1 ;
    this.player2=player2;
        this.play1_stone1 = new Position();
        this.play1_stone2 = new Position();
        this.play1_stone3 = new Position();
        this.play1_stone4 = new Position();
        this.play2_stone1 = new Position();
        this.play2_stone2 = new Position();
        this.play2_stone3 = new Position();
        this.play2_stone4 = new Position();
    }
    public int[] getplayer1()
    {
        return player1;
    }
    public int[] getplayer2()
    {
        return player2;
    }
    public void setplayer1(int [] player1)
    {
        this.player1 = player1;
    }
    public void setplayer2(int [] player2)
    {
        this.player2 = player2;
    }
    public State(State state) {
        this.player1 = new int [10];
        this.player2 = new int [10];
        player1 = state.player1.clone();
        player2 = state.player2.clone();
//        // Deep copy each value in passed array, to current instance of game
//        for(int i=0; i<10; i++)
//        {
//            System.arraycopy(state.player1[i], 0, this.player1[i], 0, player1.length);
//            System.arraycopy(state.player2[i], 0, this.player2[i], 0, player2.length);
//        }
    }
    public static State first_state(){
        int [] player1;
        player1= new int [83];
        int [] player2;
        player2= new int [83];
        for (int i = 0; i < 83; i++) {
            player1[i] =0;
            player2[i] =1;
        }

        return new State(player1,player2);
    }
    public  void print_grid(){
        int [] bourd1;
        bourd1 = this.getplayer1();
        int [] bourd2;
        bourd2 = this.getplayer2();
        for (int i = 0; i < this.getplayer1().length; i++) {
                System.out.print(bourd1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < this.getplayer2().length; i++) {
            System.out.print(bourd2[i] + " ");
        }
    }
//    public State  state(State state)
//    {
//        return state;
//    }
    public String Dice(){
        String[] values = {"دست", "شكة", "دواق",  "تلاتة" ,"اربعة","بنج","بارا"} ;
        Random random = new Random();
        int index = random.nextInt(values.length);
        return values[index];
    }
public void play(int player){
    String dice = Dice();
   boolean [] cheak= {move(num(dice),play1_stone1,1),move(num(dice),play1_stone2,1),
   move(num(dice),play1_stone3,1),
move(num(dice),play1_stone4,1)};
    System.out.println("you can move this stone");
   for(int i=0; i<4;i++){
       if(cheak[i]==true){
           System.out.println("cleak "+(i+1)+"if youwant to move stone num"+(i+1));
       }}
    Scanner scanner = new Scanner(System.in);
    int stone = scanner.nextInt();
    Position move = null;
    switch (stone) {
        case 1:
            if(player==1)
                move =play1_stone1;
            else
                move =play2_stone1;
            break;
        case 2:
            if(player==1)
                move =play1_stone2;
            else
                move =play2_stone2;
            break;
        case 3:
            if(player==1)
                move =play1_stone3;
            else
                move =play2_stone3;
            break;
        case 4:
            if(player==1)
                move =play1_stone4;
            else
                move =play2_stone4;
            break;
    }

    //استدعاء تابع التحريك
//    move(num(dice),move, player);

     move.setPosition(10);
    System.out.print(this.move(1,move,1));


    }

    public boolean move(int result,Position stone,int player){
        int [] pro ={11,22,28,39,45,56,62,73};
        boolean can_move = true;
//        stone.setPosition(10);
//        System.out.println(stone.getPosition());
        for(int p :pro){

        if((stone.getPosition()+result)==p && player2[(stone.getPosition()+result+34)]==1)
        {
             can_move = false;
          break;
}}
        if((stone.getPosition()+result)>83){
            can_move = false;
        }
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
