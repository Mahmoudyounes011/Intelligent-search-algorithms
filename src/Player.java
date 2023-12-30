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
    public  Position getstonefronum(int position){

        switch (position) {
            case 1:
                return this.stone1;
            case 2:
                return this.stone2;

            case 3:
                return this.stone4;

            case 4:
                return this.stone4;

            default:
               return new Position();

        }


    }


}
