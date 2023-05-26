import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for wombat
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
        // Add your action code here.
        
        //makes it fall down
        setLocation(getX(), getY() + speed);
        
        //Remove cherries and draw game over when cherries hit the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()){
            world.decreaseHealth();
            world.removeObject(this);
        }
        
        if(MyWorld.getHealth() == 0){
            world.gameOver();
            world.removeObject(this);
        }   

    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}
