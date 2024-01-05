import java.util.Random;
import java.util.Scanner;

public class Player {
    private boolean [] path;
public Position [] stone = new Position[4];
    public void setStone1(Position stone1) {
        this.stone[0]= stone1;
    }
    public void setStone2(Position stone2) {
        this.stone[1] = stone2;
    }
    public void setStone3(Position stone3) {
        this.stone[2] = stone3;
    }
    public void setStone4(Position stone4) {
        this.stone[3] = stone4;
    }
    public void setPath(boolean[] path) {
        this.path = path;
    }
    public Position getStone1() {
        return stone[0];
    }
    public Position getStone2() {
        return stone[1];
    }
    public Position getStone3() {
        return stone[2];
    }
    public Position getStone4() {
        return stone[3];
    }
    public Player (Position stone1, Position stone2, Position stone3, Position  stone4, boolean [] path){
        this.stone[0]=stone1;
        this.stone[1]=stone2;
        this.stone[2]=stone3;
        this.stone[3]=stone4;
        this.path = path;
    }
    public Player (Player player){
        Position stone1 =new Position(player.stone[0]) ;
        Position stone2=new Position(player.stone[1]);
        Position stone3 =new Position(player.stone[2]);
        Position stone4 =new Position(player.stone[3]);
        this.path =  player.path.clone();
        this.stone = new Position[]{stone1,stone2,stone3,stone4};
    }
    public  boolean [] getpath(){return this.path;}
    public  void  setpath( boolean [] path){ this.path=path;}
    public  Position getstone(Position position){
     if(position == stone[0]){
         return stone[0];
     }
        else if(position ==stone[1]){
            return stone[1]
                    ;
        }
     else if(position ==stone[2]){
         return stone[2];
     }
     else {
         return stone[3];
     }

    }
    public  Position getstonefronum(int position){

        switch (position) {
            case 1:
                return this.stone[0];
            case 2:
                return this.stone[1];

            case 3:
                return this.stone[2];

            case 4:
                return this.stone[3];

            default:
               return new Position();

        }


    }


}
