import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[4];
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    
    public Bear(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("images/bear_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    
    /**
     * animate bear
     */
    
    int imageIndex = 0;
    public void animateBear(){
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    /**
     * Act - do whatever the Bear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
        
        //Remove cherries if Bear eats it
        eat();
        
        //animate bear
        animateBear();
    }
    
    /**
     * Eat the cherries and spawn new cherries if it is eaten
     */
    public void eat(){
        if(isTouching(Cherries.class)){
            removeTouching(Cherries.class);
            MyWorld world = (MyWorld) getWorld();
            world.createCherries();
            world.increaseScore();
        }
    }
}
