import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainTextbox extends Actor
{
    Label mainLabel = new Label("", 35);
    Label nameLabel = new Label("", 45);
    
    public MainTextbox()
    {
        setText("Hello");
        setName("Eve");
    }
    
    public void addedToWorld(World world)
    {
        world.addObject(mainLabel, 500, 410);
        world.addObject(nameLabel, 210, 332);
    }
    
    public void setText(String text)
    {
        mainLabel.setValue(text);
    }
    
    public void setName(String text)
    {
        nameLabel.setValue(text);
    }
}