import java.util.ArrayList;

public class Node {
    private Node parent;
    private State state;
    private int depth;
    private String type;
    private double chance;
    private ArrayList<String> thrownDice;

    public Node(String type, Node parent, State state, int depth) {
        this.type = type;
        this.parent = parent;
        this.state = new State(state);
        this.depth = depth;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isFinish() {
        return this.state.isfinished(1) || this.state.isfinished(2);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // ! player 2 is the computer max
    // ! player 1 is the human min
    public int heuristic() {
        if (this.state.isfinished(2)) {
            return Integer.MAX_VALUE;
        }
        if (this.state.isfinished(1)) {
            return Integer.MIN_VALUE;
        }
        return 1;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public ArrayList<String> getThrownDice() {
        return thrownDice;
    }

    public void setThrownDice(ArrayList<String> thrownDice) {
        this.thrownDice = thrownDice;
    }
}
