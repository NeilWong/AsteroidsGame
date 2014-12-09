import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AsteroidsGame extends PApplet {

boolean wIsPressed = false;
boolean aIsPressed = false;
boolean sIsPressed = false;
boolean dIsPressed = false;
boolean qIsPressed = false;
SpaceShip ship;
Star [] star;
Asteroids [] rock;
ArrayList <Asteroids> rocks;
public void setup() 
{
  star = new Star[80];
  for(int i = 0; i <star.length; i++)
  {
    star[i] = new Star();
  }
  background(0);
  size(900,900);
  background(0);
  ship = new SpaceShip(450,450);

  
rocks = new ArrayList <Asteroids>();
 int rocksX=(int)(Math.random()*900);
 int rocksY=(int)(Math.random()*900);
 int z =0;
 for(z = 0; z<21; z++)
 {
  rocks.add(z,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
 }
 /* rocks.add(0,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(1,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(2,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(3,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(4,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(5,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(6,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(7,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(8,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(9,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(10,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(11,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(12,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(13,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(14,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(15,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(16,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(17,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(18,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(19,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
  rocks.add(20,new Asteroids((int)(Math.random()*900),(int)(Math.random()*900)));
*/
}
    //rocks.set(0,new Asteroids(rockX,rockY));
    // rocks.set(1,new Asteroids(rockX,rockY));


/*rock = new Asteroids[12];
for(int d = 0; d<rock.length; d++)
{
int rockX=(int)(Math.random()*900);
int rockY=(int)(Math.random()*900);
  rock[d] = new Asteroids(rockX,rockY);
}*/

public void draw() 
{
  background(0);
  ship.move();
  ship.show();
  for(int i = 0; i<star.length; i++)
  {
    star[i].show();
  }
 for(int e = 0; e<rocks.size(); e++)
  {
    rocks.get(e).show();
    rocks.get(e).move();
  }
/*  for(int d =0; d<rock.length; d++)
  {
    rock[d].show();
    rock[d].move();
  }*/
  if( dIsPressed == true)
     ship.rotate(10);
  if(aIsPressed == true)
    ship.rotate(-10);
  if(wIsPressed == true)
    ship.accelerate(.15f);
  if(sIsPressed == true)
    ship.accelerate(-.15f);
  if(qIsPressed == true)
    ship.teleport();
}
public void keyPressed()
    {
      if(key=='w')
      {
        wIsPressed = true;
      }
      else if(key=='a')
      {
        aIsPressed = true;
      }
      else if(key=='s')
      {
        sIsPressed = true;
      }
      else if(key=='d')
      {
        dIsPressed = true;
      }
      else if(key =='q')
      {
        qIsPressed = true;
      }
    }
    public void keyReleased()
    {
      if(key =='w')
      {
        wIsPressed = false;
      }
      else if(key =='a')
      {
        aIsPressed = false;
      }
      else if(key =='s')
      {
        sIsPressed = false;
      }
      else if(key =='d')
      {
        dIsPressed = false;
      }
      else if(key == 'q')
      {
        qIsPressed = false;
      }
    }









class SpaceShip extends Floater  
{   
  public  SpaceShip(int x, int y)
  {
    corners = 3;
    xCorners = new int[corners];
    yCorners = new int[corners];
    myColor = (200);
    xCorners[0] = -6;
    yCorners[0] = -6;
    xCorners[1] = 12;
    yCorners[1] = 0;
    xCorners[2] = -6;
    yCorners[2] = 6;
    myCenterX = x;
    myCenterY = y;
    myDirectionX = 0;
    myDirectionY = 0;
    myPointDirection = 270;
  }
    public void setX(int x){myCenterX = x;}
    public int getX(){return myCenterX;}
    public void setY(int y){myCenterY = y;}
    public int getY(){return myCenterY;}
    public void setDirectionX(double x){myDirectionX = x;}
    public double getDirectionX(){return myDirectionX;}
    public void setDirectionY(double y){myDirectionY = y;}
    public double getDirectionY(){return myDirectionY;}
    public void setPointDirection(int degrees){myPointDirection = degrees;}
    public double getPointDirection(){return myPointDirection;}
    public void teleport()
    {
        int randomX = (int)(Math.random()*850);
        int randomY = (int)(Math.random()*850);
        int randomDirection = (int)(Math.random()*360);
        //myCenterX = randomX;
        ship.setX(randomX);//{myCenterX = Math.random()*900;}
        //myCenterY = randomY;
        ship.setY(randomY);//{myCenterX = (int)(Math.random()*900);}
        ship.setPointDirection(randomDirection);
        ship.setDirectionX(0);
        ship.setDirectionY(0);
    }
}







class Asteroids extends Floater
{
 private int rotSpeed;
 public Asteroids(int x, int y)
 {
    rotSpeed = (int)(Math.random()*3-4);
    corners = 6;
    xCorners = new int[corners];
    yCorners = new int[corners];
    myColor = (200);
    xCorners[0] = 0;
    yCorners[0] = 20;
    xCorners[1] = 5;
    yCorners[1] = 9;
    xCorners[2] = 5;
    yCorners[2] = -9;
    xCorners[3] = 0;
    yCorners[3] = -10;
    xCorners[4] = -9;
    yCorners[4] = -5;
    xCorners[5] = -5;
    yCorners[5] =  9;
    //xCorners[6] = -2;
   // yCorners[6] =  4;
   // xCorners[7] = -1;
   // yCorners[7] = 5;
    myCenterX = x;
    myCenterY = y;
    myDirectionX = Math.random()*7-3;
    myDirectionY = Math.random()*7-3;
    myPointDirection = 0;
  }
    public void setX(int x){myCenterX = x;}
    public int getX(){return myCenterX;}
    public void setY(int y){myCenterY = y;}
    public int getY(){return myCenterY;}
    public void setDirectionX(double x){myDirectionX = x;}
    public double getDirectionX(){return myDirectionX;}
    public void setDirectionY(double y){myDirectionY = y;}
    public double getDirectionY(){return myDirectionY;}
    public void setPointDirection(int degrees){myPointDirection = degrees;}
    public double getPointDirection(){return myPointDirection;}
 public void move()
 {
  rotate(rotSpeed);
  super.move();
 } 






}
class Star
{
  private int myX, myY;
  public Star()
  {
    myX = (int)(Math.random()*900);
    myY = (int)(Math.random()*900);
  }
  public void show()
  {
    point(myX,myY);
  }
}



/*class Distance()
{
  
}*/


abstract class Floater //Do NOT modify the Floater class! Make changes in the SpaceShip class 
{   
  protected int corners;  //the number of corners, a triangular floater has 3   
  protected int[] xCorners;   
  protected int[] yCorners;   
  protected int myColor;   
  protected int myCenterX, myCenterY; //holds center coordinates   
  protected double myDirectionX, myDirectionY; //holds x and y coordinates of the vector for direction of travel   
  protected double myPointDirection; //holds current direction the ship is pointing in degrees    
  abstract public void setX(int x);  
  abstract public int getX();   
  abstract public void setY(int y);   
  abstract public int getY();   
  abstract public void setDirectionX(double x);   
  abstract public double getDirectionX();   
  abstract public void setDirectionY(double y);   
  abstract public double getDirectionY();   
  abstract public void setPointDirection(int degrees);   
  abstract public double getPointDirection(); 

  //Accelerates the floater in the direction it is pointing (myPointDirection)   
  public void accelerate (double dAmount)   
  {          
    //convert the current direction the floater is pointing to radians    
    double dRadians =myPointDirection*(Math.PI/180);     
    //change coordinates of direction of travel    
    myDirectionX += ((dAmount) * Math.cos(dRadians));    
    myDirectionY += ((dAmount) * Math.sin(dRadians));       
  }   
  public void rotate (int nDegreesOfRotation)   
  {     
    //rotates the floater by a given number of degrees    
    myPointDirection+=nDegreesOfRotation;   
  }   
  public void move ()   //move the floater in the current direction of travel
  {      
    //change the x and y coordinates by myDirectionX and myDirectionY       
    myCenterX += myDirectionX;    
    myCenterY += myDirectionY;     

    //wrap around screen    
    if(myCenterX >width)
    {     
      myCenterX = 0;    
    }    
    else if (myCenterX<0)
    {     
      myCenterX = width;    
    }    
    if(myCenterY >height)
    {    
      myCenterY = 0;    
    }   
    else if (myCenterY < 0)
    {     
      myCenterY = height;    
    }   
  }   
  public void show ()  //Draws the floater at the current position  
  {             
    fill(myColor);   
    stroke(myColor);    
    //convert degrees to radians for sin and cos         
    double dRadians = myPointDirection*(Math.PI/180);                 
    int xRotatedTranslated, yRotatedTranslated;    
    beginShape();         
    for(int nI = 0; nI < corners; nI++)    
    {     
      //rotate and translate the coordinates of the floater using current direction 
      xRotatedTranslated = (int)((xCorners[nI]* Math.cos(dRadians)) - (yCorners[nI] * Math.sin(dRadians))+myCenterX);     
      yRotatedTranslated = (int)((xCorners[nI]* Math.sin(dRadians)) + (yCorners[nI] * Math.cos(dRadians))+myCenterY);      
      vertex(xRotatedTranslated,yRotatedTranslated);    
    }   
    endShape(CLOSE);  
  }   
} 
//maybe change rotate
//do i have to .show or .move for ArrayList
//does new Asteroids(x,y) do same in arraylist as in array
//easier way to add rocks
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AsteroidsGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
