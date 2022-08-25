public class Snake extends Obstacle {
    public Snake() {
        super("Yilan", 4, (int) (Math.random() * (6 - 3) + 3), 12, 0);
    }
}
