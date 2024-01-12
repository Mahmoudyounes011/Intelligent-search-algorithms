import java.util.ArrayList;
import java.util.HashSet;

public class Algorithm {

    public Node expectIMinMax(Node n, int depth) {
        return expectIMinMax(n, depth, new ArrayList<>());
    }

    public Node expectIMinMax(Node n, int depth, ArrayList<String> dices) {

        HashSet<ArrayList<String>> toThrowDices = new HashSet<>();
        ArrayList<Node> childrenNodes = new ArrayList<>();
        if (n.getType() == "max") {
            System.out.println("inside max");
            Node maxNode = new Node(n);
            if (dices.isEmpty()) {
                toThrowDices = Throws.getThrows();
            } else {
                toThrowDices = new HashSet<>(Throws.getPermutations(dices));
            }
            for (ArrayList<String> t : toThrowDices) {
                Node tempNode = new Node("chance", n.getParent(), n.getState(), depth - 1);
                tempNode.setThrownDice(t);
                childrenNodes.add(tempNode);
            }
            double value = Double.MIN_VALUE;
            for (Node node : childrenNodes) {
                Grid.print_grid(node.getState());
                value = Double.max(value, chance(node, depth - 1, node.getThrownDice()));
                maxNode = new Node(node);
                maxNode.setChance(value);
            }
            return maxNode;
        } else {
            System.out.println("inside min");
            Node minNode = new Node(n);

            if (dices.isEmpty()) {
                toThrowDices = Throws.getThrows();
            } else {
                toThrowDices = new HashSet<>(Throws.getPermutations(dices));

            }
            for (ArrayList<String> t : toThrowDices) {
                Node tempNode = new Node("chance", n.getParent(), n.getState(), depth - 1);
                tempNode.setThrownDice(t);
                childrenNodes.add(tempNode);
            }
            double value = Double.MAX_VALUE;
            for (Node node : childrenNodes) {
                value = Double.min(value, chance(node, depth - 1, node.getThrownDice()));
                minNode = new Node(node);
                minNode.setChance(value);
            }
            return minNode;
        }
    }

    // if the parent is null then I am max and the chance should return *min* and
    // the state should be 1
    // else max or 2
    public double chance(Node n, int depth, ArrayList<String> dices) {
        System.out.println("inside chance");
        if (depth <= 0 || n.isFinish()) {
            return n.heuristic();
        }
        ArrayList<State> states = new ArrayList<>();
        ArrayList<Node> childrenNodes = new ArrayList<>();

        states = State.nextstate(n.getState(), n.getThrownDice(), (n.getParent() == null
                || n.getParent().getType() == "max") ? 2 : 1);
        for (State state : states) {
            childrenNodes.add(new Node((n.getParent() == null || n.getParent().getType() == "max") ? "min" : "max", n,
                    state, depth - 1));
        }
        double value = 0;
        double prob = Dice.getDiceProbability(dices);
        for (Node node : childrenNodes) {
            value += prob * expectIMinMax(node, depth - 1).getChance();
            node.setChance(value);
        }
        return value;
    }

}
