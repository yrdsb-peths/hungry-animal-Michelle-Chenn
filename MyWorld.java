import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    public int health = 10;
    Label healthBar;
    int level = 1;
        
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(710, 400, 1, false);
        
        //Create Bear object
        Bear bob = new Bear();
        addObject(bob, 355, 300);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        //Create health bar
        healthBar = new Label (10, 80);
        addObject(healthBar, 660, 50);
        
        cherryFalls.mark();
        createCherries();
    }
    
    SimpleTimer cherryFalls = new SimpleTimer();
    
    public void act(){
        if(cherryFalls.millisElapsed() < 1000){
            return;
        }
        cherryFalls.mark();
        createCherries();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 355, 200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0){
            level += 1;
        }
    }
    
    public void decreaseHealth(){
        health--;
        healthBar.setValue(health);
    }
    
    /**
     * Create new cherries at random location at top of screen
     */
    public void createCherries(){
        Cherries cherries = new Cherries();
        cherries.setSpeed(level);
        
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(cherries, x, y);
    }

}
