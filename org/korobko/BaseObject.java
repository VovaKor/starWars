package org.korobko;


public abstract class BaseObject
{

    protected double x;
    protected double y;
    protected double radius;
    private boolean isAlive;

    public BaseObject(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public double getY()
    {
        return y;
    }

    public void draw(Canvas canvas)
    {

    }

    public void move()
    {

    }

    public void checkBorders(double minx, double maxx, double miny, double maxy)
    {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public void die()
    {
        isAlive = false;
    }

    public boolean isIntersec(BaseObject o)
    {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}
