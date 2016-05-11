package org.korobko;


public class Ufo extends BaseObject
{

    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
    };

    public Ufo(double x, double y)
    {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'U');
    }

    @Override
    public void move()
    {
        double dx = Math.random() * 2-1;
        double dy = Math.random() * 2-1;

        x += dx;
        y += dy;

        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() / 2);

        int random10 = (int) (Math.random() * 10);
        if (random10 == 0)
            fire();
    }

    public void fire()
    {
        Space.game.getBombs().add(new Bomb(x, y + 3));
    }
}
