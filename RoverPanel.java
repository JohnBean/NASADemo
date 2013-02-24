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
    private JButton modeButton;
    private Timer timer;
    private double x, y, moveX, moveY;
    private boolean mode;		//mode = false -> Ackermann, mode = true -> Crab
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
        mode = false;
        setFocusable(false);
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
   @Override
   public void paintComponent (Graphics page)
   {
        this.height=getHeight();
        this.width=getWidth();

        super.paintComponent (page);
        Graphics2D g2d = (Graphics2D) page;
		  
	if(mode) {
            g2d.setColor(Color.GRAY);
	    Rectangle2D.Double body = new Rectangle2D.Double(-25+x,-50+y, 50, 100);
	    g2d.fill(body);
		  
            g2d.setColor(Color.BLACK);
            Rectangle2D.Double frontLeftWheel = new Rectangle2D.Double(-35+x,-40+y, 10, 25);
	    g2d.translate(-35+5+x, -40+12.5+y);	//translate coordinates to center of wheel for rotation
	    g2d.rotate(Math.toRadians(moveX));
	    g2d.translate(35-5-x, 40-12.5-y);
	    g2d.fill(frontLeftWheel);
            g2d.translate(-35+5+x, -40+12.5+y);	//translate coordinates back to origin
	    g2d.rotate(Math.toRadians(-moveX));
	    g2d.translate(35-5-x, 40-12.5-y);
	        
	    g2d.setColor(Color.BLACK);
	    Rectangle2D.Double frontRightWheel = new Rectangle2D.Double(25+x,-40+y, 10, 25);
            g2d.translate(25+5+x, -40+12.5+y);	//translate coordinates to center of wheel for rotation
	    g2d.rotate(Math.toRadians(moveX));
	    g2d.translate(-25-5-x, 40-12.5-y);
	    g2d.fill(frontRightWheel);
            g2d.translate(25+5+x, -40+12.5+y);	//translate coordinates back to origin
	    g2d.rotate(Math.toRadians(-moveX));
	    g2d.translate(-25-5-x, 40-12.5-y);
		  
            g2d.setColor(Color.BLACK);
	    Rectangle2D.Double backRightWheel = new Rectangle2D.Double(25+x, 20+y, 10, 25);
	    g2d.translate(25+5+x, 20+12.5+y);	//translate coordinates to center of wheel for rotation
	    g2d.rotate(Math.toRadians(moveX));
	    g2d.translate(-25-5-x, -20-12.5-y);
	    g2d.fill(backRightWheel);
            g2d.translate(25+5+x, 20+12.5+y);	//translate coordinates back to origin
	    g2d.rotate(Math.toRadians(-moveX));
	    g2d.translate(-25-5-x, -20-12.5-y);
			  
            g2d.setColor(Color.BLACK);
	    Rectangle2D.Double backLeftWheel = new Rectangle2D.Double(-35+x, 20+y, 10, 25);
	    g2d.translate(-35+5+x, 20+12.5+y);	//translate coordinates to center of wheel for rotation
	    g2d.rotate(Math.toRadians(moveX));
	    g2d.translate(35-5-x, -20-12.5-y);
	    g2d.fill(backLeftWheel);
            g2d.translate(-35+5+x, 20+12.5+y);	//translate coordinates back to origin
	    g2d.rotate(Math.toRadians(-moveX));
	    g2d.translate(35-5-x, -20-12.5-y);
        }	//end if (Crab) 
	else {
            g2d.setColor(Color.BLACK);
            Rectangle2D.Double frontLeftWheel = new Rectangle2D.Double(-35+x,-40+y, 10, 25);
	    g2d.translate(-35+5+x, -40+12.5+y);	//translate coordinates to center of wheel for rotation
	    g2d.rotate(Math.toRadians(moveX));
	    g2d.translate(35-5-x, 40-12.5-y);
	    g2d.fill(frontLeftWheel);
            g2d.translate(-35+5+x, -40+12.5+y);	//translate coordinates back to origin
	    g2d.rotate(Math.toRadians(-moveX));
	    g2d.translate(35-5-x, 40-12.5-y);
                
            g2d.setColor(Color.BLACK);
	    Rectangle2D.Double frontRightWheel = new Rectangle2D.Double(25+x,-40+y, 10, 25);
            g2d.translate(25+5+x, -40+12.5+y);	//translate coordinates to center of wheel for rotation
	    g2d.rotate(Math.toRadians(moveX));
	    g2d.translate(-25-5-x, 40-12.5-y);
	    g2d.fill(frontRightWheel);
            g2d.translate(25+5+x, -40+12.5+y);	//translate coordinates back to origin
	    g2d.rotate(Math.toRadians(-moveX));
	    g2d.translate(-25-5-x, 40-12.5-y);

            g2d.setColor(Color.GRAY);
	    Rectangle2D.Double body = new Rectangle2D.Double(-25+x,-50+y, 50, 100);
            g2d.translate(x, y);
            //g2d.rotate(Math.toRadians(-moveX));
            //g2d.rotate(Math.toRadians(moveX/2));
            g2d.translate(-x,-y);
	    g2d.fill(body);
            
            g2d.setColor(Color.BLACK);
	    Rectangle2D.Double backRightWheel = new Rectangle2D.Double(25+x, 20+y, 10, 25);
	    g2d.fill(backRightWheel);
            
            g2d.setColor(Color.BLACK);
	    Rectangle2D.Double backLeftWheel = new Rectangle2D.Double(-35+x, 20+y, 10, 25);
	    g2d.fill(backLeftWheel);
        }	//end else (Ackermann)
    }	//end paintComponent
	
	/** this method changes delay of the repaint method thought timer.
	* @param delta determines what the change in the timer will be on click
	*/
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x-=moveY*Math.sin(Math.toRadians(moveX));
        y+=moveY*Math.cos(Math.toRadians(moveX));
    }	//end actionPerformed
    public void up(){
        moveY-=.1;
	if(moveY<-2.5){
            moveY=-2.5;
        }
    }	//end up
    public void down(){
        moveY+=.1;
	if(moveY>2){
            moveY=2.5;
        }//moveX*=1.1;
    }	//end down
    public void left(){
        moveX-=2;
    }	//end left
    public void right(){
        moveX+=2;
    }	//end right
    @Override
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
        if(code==KeyEvent.VK_ENTER){
            if(mode == false){	//switch steering mode on key input of enter
                mode = true;
            }
            else{
		mode = false;
            }
        }
   }	//end keyPressed
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_UP){
            moveY=0;
        }	//end if
        if(code==KeyEvent.VK_DOWN){
            moveY=0;
        }	//end if
        if(code==KeyEvent.VK_LEFT){

        }	//end if
        if(code==KeyEvent.VK_RIGHT){

        }	//end if
    }	//end keyReleased	
}
	