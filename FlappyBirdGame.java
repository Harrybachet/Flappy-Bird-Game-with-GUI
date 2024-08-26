import javax.swing.JFrame;

public class FlappyBirdGame {
    public static void main(String[] args) {
        JFrame window = new JFrame("Flappy Bird");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setResizable(false);
        window.setVisible(true);
    }
}
