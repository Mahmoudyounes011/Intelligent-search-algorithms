public class Position {

int position ;


  public  Position (){
      this.position=0;
  }
    public  Position (Position position1){
        this.position=position1.position;
    }
  public void setPosition(int position){
      this.position =position;
  }
    public int getPosition(){
     return this.position;
    }



}
