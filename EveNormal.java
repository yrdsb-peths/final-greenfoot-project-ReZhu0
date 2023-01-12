import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EveNormal here.
 * 
 * @author R.Z 
 * @version Dec 16 2022
 */
public class EveNormal extends Actor
{
    /**
     * Act - do whatever the EveNormal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] idle = new GreenfootImage[12];
    
    SimpleTimer animationTimer = new SimpleTimer();
    public EveNormal()
    {
        
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
    public void animateIdle()
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
        animateIdle();
    }
    
    public void hideImage(){
        getImage().setTransparency(0);
    }
    
    public void showImage(){
        getImage().setTransparency(255);
    }
}
