import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wombat extends Actor
{
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
        
        //Remove cherries if wombat eats it
        eat();
        
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
