import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResponseTextbox extends Actor
{
    Label mainLabel = new Label("", 35);
    
    public ResponseTextbox(){
        setText("John");
    }
    
    public void addedToWorld(World world){
        world.addObject(mainLabel, 500, 180);
    }
    
    public void setText(String text){
        mainLabel.setValue(text);
    }
    
}
