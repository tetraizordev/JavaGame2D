package component;

import entity.Entity;
import main.GamePanel;

public class Camera
{
    public int x, y;
    public Entity target;

    public Camera(int xPosition, int yPosition)
    {
        SetPosition(xPosition, yPosition);
    }

    public Camera(int xPosition, int yPosition, Entity target)
    {
        SetPosition(xPosition, yPosition);
        this.target = target;
    }

    public void update()
    {
        if(target == null)
            return;

        SetPosition(target.x, target.y);
    }

    public void SetTarget(Entity _target)
    {
        target = _target;
    }

    public void SetPosition(int x, int y)
    {
        // Clamp position

        this.x = x;
        this.y = y;

    }

    public Boolean IsInsideBoundaries(int _x, int _y, int _offset)
    {
        if(_x <= (x + GamePanel.screenWidth / (2 * GamePanel.scaleFactor)) + _offset && _x >= (x - GamePanel.screenWidth / (2 * GamePanel.scaleFactor)) - _offset)
        {
            if(_y <= (y + GamePanel.screenHeight / (2 * GamePanel.scaleFactor)) + _offset && _y >= (y - GamePanel.screenHeight / (2 * GamePanel.scaleFactor)) - _offset)
            {
                return true;
            }
        }

        return false;
    }

    public Boolean IsInsideBoundaries(int _x, int _y)
    {
        if(_x <= (x + GamePanel.screenWidth / (2 * GamePanel.scaleFactor)) && _x >= (x - GamePanel.screenWidth / (2 * GamePanel.scaleFactor)))
        {
            if(_y <= (y + GamePanel.screenHeight / (2 * GamePanel.scaleFactor)) && _y >= (y - GamePanel.screenHeight / (2 * GamePanel.scaleFactor)))
            {
                return true;
            }
        }

        return false;
    }
}
