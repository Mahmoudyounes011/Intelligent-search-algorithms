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
                // System.out.println("hi");
                // int[] resultList = { 1, 2 };
                // try (ObjectOutputStream out = new ObjectOutputStream(new
                // FileOutputStream("result.ser"))) {
                // out.writeObject(resultList);
                // } catch (IOException e) {
                // e.printStackTrace();
                // }
                // System.out.println("nana");
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

                ArrayList<Throws> throwsList = Throws.generateThrows(0, new HashSet<String>(), new ArrayList<>(), 1);
                for (Throws t : throwsList) {
                        // System.out.println("the throws are");
                        System.out.println(t.getThrowListItems().toString());
                        // System.out.println("the length is");
                        // System.out.println(t.getThrowListItems().size());
                        // System.out.println("the chance is");
                        // System.out.println(t.getChance());
                }
                System.out.println("*".repeat(20));
                System.out.println("the size is ");
                System.out.println(throwsList.size());
        }
}
