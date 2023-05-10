import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Wombat bob = new Wombat();
        addObject(bob, 300, 300);
        
        createCherries();
    }
    
    /**
     * Create new cherries at random location at top of screen
     */
    public void createCherries(){
        Cherries cherries = new Cherries();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(cherries, x, y);
    }

}
