import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Actor
{
    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pointer()
    {
        GreenfootImage image = new GreenfootImage(20, 20);
        image.fillOval(0, 0, 0,0);
        setImage(image);
    }

    public void act()
    {
        
        MouseInfo info = Greenfoot.getMouseInfo();
        
        if(info != null)
        {
            int x = info.getX();
            int y = info.getY();
            setLocation(x, y);
        }
    }
}
