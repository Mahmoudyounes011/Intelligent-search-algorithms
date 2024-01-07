public class Game {
    public void start() {

    }

    public int expectIMinMax(Node n, int depth, String player_sending) {
        if (depth == 0 || n.isFinish()) {
            return n.heuristic();
        }
        return 0;
    }
}
