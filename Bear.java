import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Actor
{
    GreenfootImage[] idleRight = new GreenfootImage[4];
    GreenfootImage[] idleLeft = new GreenfootImage[4];
    
    // Direction the bear is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created
     */
    
    public Bear(){
        for(int i = 0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/bear_idle/idle" + i + ".png");
        }
        
        for(int i = 0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/bear_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
        }
        
        animationTimer.mark();
        
        //Initial bear image
        setImage(idleRight[0]);
    }
    
    /**
     * animate bear
     */
    
    int imageIndex = 0;
    public void animateBear(){
        if(animationTimer.millisElapsed() < 1000){
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
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
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(2);
            facing = "right";
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
