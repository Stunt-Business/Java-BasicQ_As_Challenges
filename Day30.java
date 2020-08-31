// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 30 :Challenge XIV - Moving a Drawing in your GUI
// Day 30 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class DrawCircle extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 4418630376090808431L;
    private int x = 75;
    private int y = 25;
    private int width = 100;
    private int height = 100;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, this.width, this.height);
    }

    // ypu could customize the following functions
    public  void moveLeft()
    {
        this.x--;
        repaint();
    }
    public  void moveRight()
    {
        this.x++;
        repaint();
    }
    public  void moveUp()
    {
        this.y--;
        repaint();
    }
    public  void moveDown()
    {
        this.y++;
        repaint();
    }


}
class GUI_D30 extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = -6021547927386781783L;
    public static int currentUserID = 0; // for the user id in the text file

    // GUI is your main panel
    public GUI_D30()
    {
        JPanel imgPanel = new JPanel();
        JLabel imgLabel = new JLabel(new ImageIcon("img_data/android-chrome-192x192.png"));
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        imgLabel.setPreferredSize(new Dimension(200,270));
       
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setPreferredSize(new Dimension(200, 270));

        imgPanel.add(
            imgLabel, BorderLayout.CENTER
            );
        

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);

    
        
        JPanel drawingPanel = new JPanel();
        drawingPanel.setPreferredSize(new Dimension(250, 100));
        drawingPanel.setLayout(new BoxLayout(drawingPanel, BoxLayout.Y_AXIS));
        drawingPanel.setBackground(Color.WHITE);

        DrawCircle circle = new DrawCircle();
    
        drawingPanel.add(circle);

        // Panel indicator
        JLabel panelIndicator;
        panelIndicator = new JLabel("No event.", SwingConstants.LEFT);
       
        JButton left, right, up, down;
        left = new JButton("Left");
        left.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
                    circle.moveLeft();	
                    panelIndicator.setText("Left");	
            }
          }          
        );
        right = new JButton("Right");
        right.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
                    circle.moveRight();	
                    panelIndicator.setText("Right");		
            }
          }          
        );
        up = new JButton("Up");
        up.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
                    circle.moveUp();
                    panelIndicator.setText("Up");			
            }
          }          
        );
        down = new JButton("Down");
        down.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
                    circle.moveDown();	
                    panelIndicator.setText("Down");		
            }
          }          
        );

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setPreferredSize(new Dimension(250, 50));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(left);
        buttonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonsPanel.add(right);
        buttonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonsPanel.add(up);
        buttonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonsPanel.add(down);
        
        
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(250, 270));
        infoPanel.add(Box.createRigidArea(new Dimension(250, 30)));
        infoPanel.add(drawingPanel);
        infoPanel.add(Box.createRigidArea(new Dimension(250,20)));
        infoPanel.add(buttonsPanel);
        infoPanel.add(Box.createRigidArea(new Dimension(250,10)));
        infoPanel.add(panelIndicator);
        

        add(imgPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }
}
public class Day30
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Moving a Circle.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI_D30());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}