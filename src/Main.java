import java.util.*;
import java.io.*;

public class Main {
        public static void main(String[] args) {
                // State.play();
                // State state = State.first_state();
                // // Grid.print_grid(state);
                // ArrayList<String> movable = new ArrayList<>();
                // movable.add("خال");
                // movable.add("خال");

                // State.play();
                // State state = State.first_state();
                //// Grid.print_grid(state);
                // ArrayList<String> movable = new ArrayList<>();
                // movable.add("خال");
                // movable.add("دست");
                // movable.add("دواق");
                // ArrayList<State> movable1 = new ArrayList<>();
                // movable1 =state.nextstate( movable);
                //// System.out.println(movable);
                // for (State movables : movable1){
                // Grid.print_grid(movables);
                // }

                // int[] resultList = null;
                // try (ObjectInputStream in = new ObjectInputStream(new
                // FileInputStream("result.ser"))) {
                // resultList = (int[]) in.readObject();
                // } catch (ClassNotFoundException | IOException e) {
                // e.printStackTrace();
                // }

                // for (int i = 0; i < resultList.length; i++) {
                // System.out.println("Element at index " + i + " : " + resultList[i]);
                // }

                // HashSet<ArrayList<String>> throwsList = Throws.generateThrows(0, new
                // ArrayList<String>(),
                // new HashSet<ArrayList<String>>(), 1);
                // // for (ArrayList<String> t : throwsList) {
                // // System.out.println(t.toString());
                // // }
                // System.out.println("*".repeat(20));
                // System.out.println("the size is ");
                // System.out.println(throwsList.size());

                // Throws.serilize();

                HashSet<ArrayList<String>> throwsList = Throws.getThrows();

                System.out.println("*".repeat(20));
                System.out.println("the size is ");
                System.out.println(throwsList.size());
        }
}
