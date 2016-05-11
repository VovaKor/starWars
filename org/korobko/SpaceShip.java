package org.korobko;

/**
 * Created by Вова on 18.02.2016.
 */
public class SpaceShip extends BaseObject
{
    private double dx=0;
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    @Override
    public void move()
    {
        if (x-this.radius>0||x+this.radius< Space.game.getWidth())
        x=x+dx;
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight());
    }
    public void fire(){
        Rocket rocket1 = new Rocket(x+this.radius,y);
        Rocket rocket2 = new Rocket(x-this.radius,y);
        Space.game.getRockets().add(rocket1);
        Space.game.getRockets().add(rocket2);

    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawMatrix(x - radius + 1, y-radius-1, matrix, 'M');
    }

    public void moveLeft(){
        dx=-1;
    }
    public void moveRight(){
        dx=1;
    }
    public SpaceShip(int x, int y)
    {
        super(x, y, 3);
    }
}
