import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EveHappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EveHappy extends Actor
{
    /**
     * Act - do whatever the EveHappy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void hideImage(){
        getImage().setTransparency(0);
    }
    
    public void showImage(){
        getImage().setTransparency(255);
    }
}
