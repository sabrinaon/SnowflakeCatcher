SnowFlake[] blizzard;

void setup()
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
void draw()
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
void mouseDragged()
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
  void show()
  {
    //your code here
    fill(255);
    ellipse(x,y,6,6);
  }
  void lookDown()
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
  void erase()
  {
    //your code here
    fill(0);
    ellipse(x, y, 11, 11);
  }
  void move()
  {
    //your code here
    if(isMoving)
    {
      y++;
    }
  }
  void wrap()
  {
    //your code here
    if (y > 300)
    {
      y = 0;
      x = (int)(Math.random()*300);
    }
  }
}


