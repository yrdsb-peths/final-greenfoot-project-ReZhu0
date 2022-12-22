import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EveNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EveNormal extends Actor
{
    /**
     * Act - do whatever the EveNormal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] idle = new GreenfootImage[3];
    
    SimpleTimer animationTimer = new SimpleTimer();
    public EveNormal()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/characters/eve_idle" + i + ".png");
            if(i == 2)
            {
                for(i = 2; i >= 0; i--)
                {
                    idle[i] = new GreenfootImage("images/characters/eve_idle" + i + ".png");
                }
            }
        }
        setImage(idle[1]);
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
    }
}
