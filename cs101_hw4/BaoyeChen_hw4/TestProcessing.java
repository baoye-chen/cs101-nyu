
import processing.core.PApplet;

public class TestProcessing extends PApplet 
{
	
     public static void main(String[] args) 
     {
          PApplet.main("TestProcessing");
     }
     
     // set the size of the console
     public void settings() 
     {
          size(500, 500);
     }
     
     // set the color of the background
     public void setup() 
     {
 		this.background(255,255,255); // set to white
     }
     
     // print my NetId in red
     public void draw()
     {
    	textSize(32);
 		text("NetId: bc2508",140,240);
 		fill(255,0,0);  // draw the color red
     } 
}