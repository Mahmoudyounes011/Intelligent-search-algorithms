import java.util.Random;
import java.util.Scanner;

public class Player {
    private boolean [] path;
    private Position stone1;
    public Position stone2;
    public Position stone3;
    public Position stone4;

    public void setStone1(Position stone1) {
        this.stone1 = stone1;
    }
    public void setStone2(Position stone2) {
        this.stone2 = stone2;
    }
    public void setStone3(Position stone3) {
        this.stone3 = stone3;
    }
    public void setStone4(Position stone4) {
        this.stone4 = stone4;
    }
    public void setPath(boolean[] path) {
        this.path = path;
    }
    public Position getStone1() {
        return stone1;
    }
    public Position getStone2() {
        return stone2;
    }
    public Position getStone3() {
        return stone3;
    }
    public Position getStone4() {
        return stone4;
    }
    public Player (Position stone1, Position stone2, Position stone3, Position  stone4, boolean [] path){
this.stone1 = stone1;
this.stone2=stone2;
this.stone3 =stone3;
this.stone4 =stone4;
this.path = path;
    }
    public Player (Player player){
        this.stone1 =new Position(player.stone1) ;
        this.stone2=new Position(player.stone2);
        this.stone3 =new Position(player.stone3);
        this.stone4 =new Position(player.stone4);
//        this.path = new boolean [84];
//        this.player2 = new int [10];
//        player1 = state.player1.clone();
        this.path =  player.path.clone();
    }
    public  boolean [] getpath(){return this.path;}
    public  void  setpath( boolean [] path){ this.path=path;}
    public  Position getstone(Position position){
     if(position ==stone1){
         return stone1;
     }
        else if(position ==stone2){
            return stone2
                    ;
        }
     else if(position ==stone3){
         return stone3;
     }
     else {
         return stone4;
     }

    }
//
//    public boolean move(int result,Position stone ){
//        int [] pro ={11,22,28,39,45,56,62,73};
//        boolean can_move = true;
////        stone.setPosition(10);
//        System.out.println(stone.getPosition());
//        System.out.println(stone.getPosition()+result);
//
//        for(int i=0 ; i<7; i++){
//            if(stone.getPosition()+result == pro[i] )
//            {
//                System.out.println(pro[i] + "t");
//                can_move = false;
//                System.out.println(pro[i] + "f");
//                break;
//
//            }}
//
////            for(int p :pro){
////                if((stone.getPosition()+result)==p && player1.getpath()[(stone.getPosition()+result+34)]==true);
////                {
////                    can_move = false;
////                    break;
////                }}
//
//
////        if((stone.getPosition()+result)>83){
////            can_move = false;
////        }
//
//
//        return can_move;
//    }
//    //

//    public String Dice(){
//        String[] values = {"دست", "شكة", "دواق",  "تلاتة" ,"اربعة","بنج","بارا"} ;
//        Random random = new Random();
//        int index = random.nextInt(values.length);
//        return values[index];
//    }
//public void play(){
//    String dice = Dice();
//   boolean [] cheak= {move(num(dice),stone1),move(num(dice),stone2),
//   move(num(dice),stone3),move(num(dice),stone4)};
//    System.out.println("you can move this stone");
//   for(int i=0; i<4;i++){
//       if(cheak[i]==true){
//           System.out.println("cleak "+(i+1)+"if youwant to move stone num"+(i+1));
//       }}
//    Scanner scanner = new Scanner(System.in);
//    int entry = scanner.nextInt();
//    Position stone = null;
//    switch (entry) {
//        case 1:
//          stone =stone1;
//            break;
//        case 2:
//                stone= stone2;
//            break;
//        case 3:
//            stone =stone3;
//            break;
//        case 4:
//            stone =stone4;
//            break;
//    }
//
//    //استدعاء تابع التحريك
////    move(num(dice),move, player);
//
//    stone.setPosition(10);
//    System.out.print(this.move(1,stone));
//
//
//    }
//
//    public boolean move(int result,Position stone){
//        int [] pro ={11,22,28,39,45,56,62,73};
//        boolean can_move = true;
////        stone.setPosition(10);
////        System.out.println(stone.getPosition());
//        for(int p :pro){
//
//        if((stone.getPosition()+result)==p && state.getplayer().getpath()[(stone.getPosition()+result+34)]==true)
//        {
//             can_move = false;
//          break;
//}}
//        if((stone.getPosition()+result)>83){
//            can_move = false;
//        }
//        return can_move;
//    }
////
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



}
