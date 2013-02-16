import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoverDemo
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("RoverDemo");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new RoverPanel());
      frame.pack();
      frame.setVisible(true);
   }
}
