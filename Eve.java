import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Eve here.
 * 
 * @author R.Z 
 * @version Dec 16 2022
 */
public class Eve extends Actor
{
    /**
     * Act - do whatever the EveNormal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] idle = new GreenfootImage[12];
    
    GreenfootImage happy = new GreenfootImage("images/characters/eve_happy.png");
    
    GreenfootImage menu = new GreenfootImage("images/characters/eve_menu.png");
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    String state = "normal"; // angry, happy
    
    public Eve()
    {
        //happy = new GreenfootImage("images/characters/eve_idle0.png")
        
        idle[0] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[1] = new GreenfootImage("images/characters/eve_idle1.png");
        idle[2] = new GreenfootImage("images/characters/eve_idle2.png");
        idle[3] = new GreenfootImage("images/characters/eve_idle1.png");
        idle[4] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[5] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[6] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[7] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[8] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[9] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[10] = new GreenfootImage("images/characters/eve_idle0.png");
        idle[11] = new GreenfootImage("images/characters/eve_idle0.png");
                    
        setImage(idle[0]);
        animationTimer.mark();
    }
    
    int i = 0;
    public void animateNormal()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();

        setImage(idle[i]);
        i = (i + 1) % idle.length;
    }
    
    public void act()
    {
        // Add your action code here.
        if(state.equals("normal"))
        {
            animateNormal();
        }else if(state.equals("happy"))
        {
            //show happy
            setImage(happy);
        }else if(state.equals("menu"))
        {
            setImage(menu);
        }
    }
    
    public void setState(String text)
    {
        state = text;
    }
    
    public void hideImage(){
        getImage().setTransparency(0);
    }
    
    public void showImage(){
        getImage().setTransparency(255);
    }
}
