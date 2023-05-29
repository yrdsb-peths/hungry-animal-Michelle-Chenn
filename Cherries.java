import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for Bear
 * 
 * @author Michelle 
 * @version May 2023
 */
public class Cherries extends Actor
{
    /**
     * Act - do whatever the Cherries wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int speed = 1;
    
    public void act()
    {
        //makes it fall down
        setLocation(getX(), getY() + speed);
        
        //Remove cherries and decreases health when cherries hit the bottom
        MyWorld world = (MyWorld) getWorld();
        int health = 10;
        if(getY() >= world.getHeight()){
            health--;
            if(health>0){
                world.decreaseHealth();
            }
            world.removeObject(this);
        }

    }
    
    /**
     * Sets speed that cherries fall at
     */
    public void setSpeed(int spd){
        speed = spd;
    }
}
