public class Node {
    private Node parent;
    private State state;
    private int depth;
    private String type;

    public Node(String type, Node parent, State state, int depth) {
        this.type = type;
        this.parent = parent;
        this.state = new State(state);
        this.depth = depth;
    }

    public boolean isRoot() {
        return this.parent == null;
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
}
