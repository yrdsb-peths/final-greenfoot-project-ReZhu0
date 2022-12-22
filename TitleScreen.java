import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author R.Z
 * @version Dec 16 2022
 */
public class TitleScreen extends World
{
    

    /**
     * Constructor for objects of class Title.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        Title title = new Title();
        addObject(title,500, 225);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            GameWorld0 gameWorld = new GameWorld0();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
