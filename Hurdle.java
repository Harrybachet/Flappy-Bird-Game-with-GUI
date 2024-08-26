import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Hurdle {
    private double x;
    private final int width, height;
    private final int gapHeight;
    private final int gapY;

    public Hurdle(int x, int width, int height, int gapHeight) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.gapHeight = gapHeight;
        this.gapY = new Random().nextInt(height - gapHeight - 100) + 50; // Randomize the gap position
    }

    public void update() {
        x -= 5; // Move hurdle to the left
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, 0, width, gapY);
        g.fillRect((int) x, gapY + gapHeight, width, height - (gapY + gapHeight));
    }

    public int getX() {
        return (int) x;
    }

    public int getWidth() {
        return width;
    }

    public int getGapY() {
        return gapY;
    }

    public int getGapHeight() {
        return gapHeight;
    }
}
