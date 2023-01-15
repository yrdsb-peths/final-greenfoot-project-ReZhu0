import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResponseTextboxB extends Actor
{
    Label mainLabel = new Label("", 35);
    
    public ResponseTextboxB(){
        setText(" ");
    }
    
    public void addedToWorld(World world){
        world.addObject(mainLabel, 500, 257);
    }
    
    public void setText(String text){
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
