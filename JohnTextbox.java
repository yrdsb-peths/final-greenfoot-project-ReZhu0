import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JohnTextbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JohnTextbox extends Actor
{
    /**
     * Act - do whatever the JohnTextbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Label mainLabel = new Label("", 35);
    
    public JohnTextbox()
    {
        
    }
    
    public void addedToWorld(World world)
    {
        world.addObject(mainLabel, 500, 410);
    }
    
    public void setText(String text)
    {
        mainLabel.setValue(text);
    }
    
    public void hide(){
        getImage().setTransparency(0);
        mainLabel.setValue("");
    }
    
    public void show(){
        getImage().setTransparency(255);
    }
}
