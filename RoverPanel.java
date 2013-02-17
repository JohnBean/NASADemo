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
   private int width = 300, height = 100;
	public int delay=5;
   private final int IMAGE_SIZE = 35;
   private ImageIcon image;
   private JButton faster,slower,pause;
	private Timer timer;
   private int x, y, moveX, moveY;

   //-----------------------------------------------------------------
   //  Sets up the panel, including the timer for the animation.
   //-----------------------------------------------------------------
   public RoverPanel()
   {
      timer = new Timer(delay, this);

      x = 200;
      y = 200;
      moveX = moveY =0;
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
        g2d.setColor(Color.GRAY);
        Rectangle rect2 = new Rectangle(-25+x,-50+y, 50, 100);
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(moveX));
        
        g2d.translate(-x, -y);
        g2d.fill(rect2);
        
        g2d.setColor(Color.BLACK);
        Rectangle rect3 = new Rectangle(-35+x,-40+y, 10, 25);
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(moveX));
        
        g2d.translate(-x, -y);
        g2d.fill(rect3);
        
        g2d.setColor(Color.BLACK);
        Rectangle rect4 = new Rectangle(-35+x, 20+y, 10, 25);
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(moveX));
        
        g2d.translate(-x, -y);
        g2d.fill(rect4);
        
        
        g2d.setColor(Color.BLACK);
        Rectangle rect5 = new Rectangle(25+x,-40+y, 10, 25);
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(moveX));
        
        g2d.translate(-x, -y);
        g2d.fill(rect5);
        
        g2d.setColor(Color.BLACK);
        Rectangle rect6 = new Rectangle(25+x, 20+y, 10, 25);
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(moveX));
        
        g2d.translate(-x, -y);
        g2d.fill(rect6);
   }
	/** this method changes delay of the repaint method thought timer.
	* @param delta determines what the change in the timer will be on click
	*/
   public void actionPerformed(ActionEvent e){

	   repaint();
       x+=moveY*Math.sin(Math.toRadians(moveX));
       y+=moveY*Math.cos(Math.toRadians(moveX));
       
   }
   public void up(){
       moveY-=1;
   }
   public void down(){
       moveY+=1;
   }
   public void left(){
       moveX-=1;
   }
   public void right(){
       moveX+=1;
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
   public void keyReleased(KeyEvent e){}
}
