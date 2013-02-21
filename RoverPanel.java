//********************************************************************
//  RoverPanel.java       
//
//********************************************************************
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class RoverPanel extends JPanel implements ActionListener, KeyListener
{
   private int width = 600, height = 600;
	public int delay=5;
   private final int IMAGE_SIZE = 35;
   private ImageIcon image;
   private JButton faster,slower,pause;
	private Timer timer;
   private double x, y, moveX, moveY;
   //-----------------------------------------------------------------
   //  Sets up the panel, including the timer for the animation.
   //-----------------------------------------------------------------
   public RoverPanel()
   {
      timer = new Timer(delay, this);

      x = 200;
      y = 200;
      moveX = 0;
      moveY =0;
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
      setPreferredSize (new Dimension(width, height));
      setBackground (Color.red);
      timer.start();

   }

   //-----------------------------------------------------------------
   //  Draws the image in the current location.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
	   this.height=getHeight();
	   this.width=getWidth();

        super.paintComponent (page);
        Graphics2D g2d = (Graphics2D) page;
		  
		  g2d.setColor(Color.BLACK);
        Rectangle2D.Double frontLeftWheel = new Rectangle2D.Double(-35+x,-40+y, 10, 25);
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(moveX));
        g2d.translate(-x, -y);
        g2d.fill(frontLeftWheel);
        
        g2d.setColor(Color.BLACK);
        Rectangle2D.Double frontRightWheel = new Rectangle2D.Double(25+x,-40+y, 10, 25);
        g2d.fill(frontRightWheel);
        
		  g2d.setColor(Color.GRAY);
        Rectangle2D.Double body = new Rectangle2D.Double(-25+x,-50+y, 50, 100);
		  g2d.translate(x, y);
		  g2d.rotate(Math.toRadians(-moveX));
		  g2d.rotate(Math.toRadians(moveX/2));
		  g2d.translate(-x,-y);
        g2d.fill(body);
		  
		  g2d.setColor(Color.BLACK);
        Rectangle2D.Double backRightWheel = new Rectangle2D.Double(25+x, 20+y, 10, 25);
        g2d.fill(backRightWheel);
		  
		  g2d.setColor(Color.BLACK);
        Rectangle2D.Double backLeftWheel = new Rectangle2D.Double(-35+x, 20+y, 10, 25);
        g2d.fill(backLeftWheel);
        
        
        
        
   }
	/** this method changes delay of the repaint method thought timer.
	* @param delta determines what the change in the timer will be on click
	*/
   public void actionPerformed(ActionEvent e){

	   repaint();
       x-=moveY*Math.sin(Math.toRadians(moveX));
       y+=moveY*Math.cos(Math.toRadians(moveX));
       
   }
   public void up(){
       moveY-=.5;
		 //moveX*=1.1;
   }
   public void down(){
       moveY+=.5;
		 //moveX*=1.1;
   }
   public void left(){
       moveX-=2;
   }
   public void right(){
       moveX+=2;
   }
   public void keyPressed(KeyEvent e){
       int code = e.getKeyCode();
       if(code==KeyEvent.VK_UP){
           up();
       }
       if(code==KeyEvent.VK_DOWN){
           down();
       }
       if(code==KeyEvent.VK_LEFT){
           left();
       }
       if(code==KeyEvent.VK_RIGHT){
           right();
       }  
   }
   public void keyTyped(KeyEvent e){}
   public void keyReleased(KeyEvent e){
	   int code = e.getKeyCode();
       if(code==KeyEvent.VK_UP){
           moveX = moveX*Math.pow(1.1,(moveY/.5));
			  moveY=0;
       }
       if(code==KeyEvent.VK_DOWN){
		 	  moveX = moveX*Math.pow(1.1,(moveY/.5));
           moveY=0;
       }
       if(code==KeyEvent.VK_LEFT){
        //   moveX=0;
       }
       if(code==KeyEvent.VK_RIGHT){
         //  moveX=0;
       }
   }
}
	