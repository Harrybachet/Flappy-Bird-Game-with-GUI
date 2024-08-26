import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private Bird bird;
    private ArrayList<Hurdle> hurdles;
    private Timer timer;
    private int score;

    public GamePanel() {
        bird = new Bird(100, 300, 30, 30);
        hurdles = new ArrayList<>();
        hurdles.add(new Hurdle(800, 80, 600, 150));
        score = 0;

        timer = new Timer(16, this); // Approx 60 FPS
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bird.flap();
                }
            }
        });
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.update();

        ArrayList<Hurdle> hurdlesToRemove = new ArrayList<>();
        for (Hurdle hurdle : hurdles) {
            hurdle.update();

            if (bird.isColliding(hurdle)) {
                timer.stop(); // Game Over
            }

            if (hurdle.getX() + hurdle.getWidth() < 0) {
                hurdlesToRemove.add(hurdle);
                score++;
            }
        }

        hurdles.removeAll(hurdlesToRemove);

        if (hurdles.isEmpty() || hurdles.get(hurdles.size() - 1).getX() < 600) {
            hurdles.add(new Hurdle(800, 80, 600, 150));
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bird.draw(g);

        for (Hurdle hurdle : hurdles) {
            hurdle.draw(g);
        }

        g.drawString("Score: " + score, 10, 20);
    }
}
