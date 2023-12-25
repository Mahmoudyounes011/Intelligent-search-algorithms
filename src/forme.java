import java.util.Scanner;

public class forme {




//        boolean [] bourd2;
//        bourd2 = this.player2.getpath();
//        for (int i = 1; i < 84; i++) {
//            if(bourd1[i]==true){
//                this.grid[i]=true;
//            }
//            else if(bourd2[i]==true){
//                this.grid[i]=true;
//            }
//            else{
//                this.grid[i]=false;
//            }
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




    //main
    boolean[] a=new boolean[84];
//
//        boolean[] b=new boolean[84];
//        boolean[] c=new boolean[84];
//        for(int i=0 ;i<84;i++){
////            System.out.println(c[i]);
//c[i]=false;
//        }
//        for(int i=0 ;i<84;i++){
////            System.out.println(c[i]);
//            a[i]=false;
//        }
//        for(int i=0 ;i<84;i++){
////            System.out.println(c[i]);
//            b[i]=false;
//        }
//
//        a[44]=true;
//        a[8]=true;
//        b[3]=true;
//        a[9]=true;
//        c= state.grid(a,b);
//        for(int i=1 ;i<81;i++){
//            System.out.println(c[i]);
//        }


//    public State play(State state ,int player){
//        String dice = Dice();
//        boolean [] cheak= {cheak (num(dice),player(player).getStone1(),player),cheak (num(dice),player(player).getStone2(),player),
//                cheak (num(dice),player(player).getStone3(),player),cheak (num(dice),player(player).getStone4(),player) };
//        System.out.println("you can move  this stone");
//        int count =0;
//        for(int i=0 ; i<4 ; i++){
//            if(cheak[i]==true){
//                System.out.println("cleak "+(i+1)+"if youwant to move stone num"+(i+1));
//            }
//            else{
//                count++;}
//        }
//        if(count ==4){
//            return state;
//        }
//        Scanner scanner = new Scanner(System.in);
//        int entry = scanner.nextInt();
//        Position stone = null;
//        State new_state = new State(state);
//        switch (entry) {
//            case 1:
//                stone =new_state.player(player).getStone1();
//                break;
//            case 2:
//                stone= new_state.player(player).getStone2();
//                break;
//            case 3:
//                stone =new_state.player(player).getStone3();
//                break;
//            case 4:
//                stone =new_state.player(player).getStone4();
//                break;
//        }
//
//        //استدعاء تابع التحريك
//
//
//        new_state = move(new_state , num(dice),stone,player);
//        return new_state;
////        stone.setPosition(10);
////        System.out.print(this.move(1,stone ));
//
//
//    }




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


//        boolean [] bourd1;
//        boolean [] bourd2;
//        bourd2 =player1.getpath();
//        boolean [] bourd3;
//        bourd3 =player2.getpath();
//        bourd1 =grid( this.player1.getpath(), this.player2.getpath());
//        for(int i=1 ;i<8;i++){
//            System.out.print(bourd2[i]+"  ");
//        }
//        System.out.println();
//        for(int i=1 ;i<68;i++){
//            System.out.print(bourd1[i]+"  ");
//        }
//        System.out.println();
//        for(int i=1 ;i<84;i++){
//            System.out.print(bourd3[i]+"  ");
//        }

}


