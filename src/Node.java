//import java.util.ArrayList;
//
public class Node {}
//    private  Node parent;
//    private State state;
//    private int depth = 3;
//    public Node(Node parent, State state) {
//        this.parent = parent;
//        this.state = new State(state) ;
//    }
//    public Node(Node parent, State state, int depth) {
//        this.parent = parent;
//        this.state = new State(state) ;
//        this.depth = depth;
//    }
//    public Node (Node node){
//        this.parent = node.getParent();
//        this.state = new State(node.getState()) ;
//        this.depth = node.getDepth();
//    }
//
//    public boolean isnotroot() {
//        return this.parent != null;
//    }
//    public Node getParent() {
//        return parent;
//    }
//    public void setParent(Node parent) {
//        this.parent = parent;
//    }
//
//    public State getState() {
//        return state;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//    public int getDepth() {
//        return depth;
//    }
//
//    public void setDepth(int depth) {
//        this.depth = depth;
//    }
//
//    public State maxMove(State state , ArrayList<String> dice , int depth) {
//        State newstate = new State(state);
//        int min_value = Integer.MIN_VALUE;
//        ArrayList<State> states = new ArrayList<>();
//        states.add(state);
//    for(String dices : dice){
//        ArrayList<State> movesList = state.nextstate(states,dices);
//        if (movesList.isEmpty()) {
//            // Handle case where there are no available moves
//            return newstate;
//        }}
//
////        for (State moves : movesList) {
////            int chance = chance(moves,dice ,depth-1);
////            if (chance > min_value) {
////                newstate = moves;
////                min_value = chance;chance
////            }
////        }
//        return newstate;
//    }
////    public int chance(State state , String dice, int depth ){
////
////
////
////        return depth;
////}
////    // function MinMove
////    public State minMove(State state , String dice , int depth) {
////        State newstate = new State(state);
////        int max_value = Integer.MAX_VALUE;
////        ArrayList<State> movesList = state.nextstate( state, dice);
////
////        if (movesList.isEmpty()) {
////            return newstate;
////        }
////
////        for (State moves : movesList) {
////            int chance = chance(moves , dice , depth-1);
////            if (chance < max_value) {
////                 newstate = moves;
////                max_value = chance;
////            }
////        }
////        return newstate;
////    }
////
//
//
//
//
//
//}
