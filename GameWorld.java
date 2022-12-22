import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * Visual Novel
 * 
 * @author Rebecca Zhu 
 * @version Dec 16 2022
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        
        TextBox text = new TextBox();
        addObject (text , 500, 250);
        
        EveNormal eveNormal = new EveNormal();
        addObject(eveNormal,500,250);
    }
}
