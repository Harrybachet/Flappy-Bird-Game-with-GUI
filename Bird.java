import java.awt.Graphics;
import java.awt.Color;

public class Bird {
    private double x, y;
    private final int width, height;
    private double yVelocity;
    private final double gravity = 0.6;
    private final double flapStrength = -10;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.yVelocity = 0;
    }

    public void update() {
        yVelocity += gravity;
        y += yVelocity;

        if (y < 0) {
            y = 0;
            yVelocity = 0;
        }
    }

    public void flap() {
        yVelocity = flapStrength;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, width, height);
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isColliding(Hurdle hurdle) {
        return hurdle.getX() < x + width &&
               hurdle.getX() + hurdle.getWidth() > x &&
               (y < hurdle.getGapY() || y + height > hurdle.getGapY() + hurdle.getGapHeight());
    }
}
