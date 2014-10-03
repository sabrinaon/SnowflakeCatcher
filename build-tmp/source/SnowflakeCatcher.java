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

public class SnowflakeCatcher extends PApplet {

SnowFlake[] blizzard;

public void setup()
{
  //your code here
  blizzard = new SnowFlake[150];
  for(int i = 0; i < blizzard.length; i++)
  {
    blizzard[i] = new SnowFlake();
  }
  size(300,300);
  background(0);
  noStroke();
}
public void draw()
{
  //your code here
  for(int i = 0; i < blizzard.length; i++)
  {
    blizzard[i].erase();
    blizzard[i].lookDown();
    blizzard[i].move();
    blizzard[i].wrap();
    blizzard[i].show();
  }
}
public void mouseDragged()
{
  //your code here
  strokeWeight(6);
  //catcher = (int)(Math.random()*256)
  if(mouseButton==RIGHT)
  {
    stroke(0);
    strokeWeight(10);
  }
  else
  {
    stroke(147,200,20);
  }
  line(mouseX,mouseY,pmouseX,pmouseY);
  noStroke();
}

class SnowFlake
{
  //class member variable declarations
  int x, y;
  boolean isMoving;
  SnowFlake()
  {
    //class member variable initializations
    x = (int)(Math.random()*300);
    y = (int)(Math.random()*300);
    isMoving = true;
  }
  public void show()
  {
    //your code here
    fill(255);
    ellipse(x,y,6,6);
  }
  public void lookDown()
  {
    //your code here
    if(y<290 && y>=0 && x>=1 && x<290 && (get(x-1,y+5) != color(0) || get(x-1, y+4)!= color(0)))
    {
      isMoving=false;
    }
    else
    {
      isMoving=true;
    }
  }
  public void erase()
  {
    //your code here
    fill(0);
    ellipse(x, y, 11, 11);
  }
  public void move()
  {
    //your code here
    if(isMoving)
    {
      y++;
    }
  }
  public void wrap()
  {
    //your code here
    if (y > 300)
    {
      y = 0;
      x = (int)(Math.random()*300);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
