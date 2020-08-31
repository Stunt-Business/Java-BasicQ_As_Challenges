// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 28 : GUI for collecting User information - II
// Day 28 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.awt.Dimension;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class GUI_D28 extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = -6021547927386781783L;

    // GUI is your main panel
    public GUI_D28()
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

        // user input fields
        JTextField lastName, firstName;
        JLabel lastNameLabel, firstNameLabel,dateOfBirthLabel;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        
        lastName = new JTextField();
        lastNameLabel = new JLabel("Last name");
        firstName = new JTextField();
        firstNameLabel = new JLabel("First name");
        dateOfBirthLabel = new JLabel("Date of birth");
        
        JPanel inputsPanel = new JPanel();
        inputsPanel.setPreferredSize(new Dimension(250, 100));
        inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.Y_AXIS));
        inputsPanel.setBackground(Color.WHITE);
        inputsPanel.add(lastNameLabel);
        inputsPanel.add(lastName);
        inputsPanel.add(firstNameLabel);
        inputsPanel.add(firstName);
        inputsPanel.add(dateOfBirthLabel);
        inputsPanel.add(dateTextField);

        // Panel indicator
        JLabel panelIndicator;
        panelIndicator = new JLabel("No event.", SwingConstants.LEFT);
       

        
        // JButtons
        JButton submit, reset;
        submit = new JButton("Submit");
        submit.setMargin(new Insets(20,25,20,25));
        submit.setBackground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
                    panelIndicator.setText("Clicked on submit!");
                    User user = new User();
                    user.setFirstName(firstName.getText());		
                    user.setLastName(lastName.getText());	
                    // users are student
                    // the field category is not implemented in the GUI
                    user.setCategory("Student");
                    if ( dateTextField.getText().trim().length() != 0 )
                    {
                        String dOfB = dateTextField.getText();
                        String[] dates = dOfB.split("-");
                        user.setDateOfBirth(
                            Integer.parseInt(dates[0]), 
                            Integer.parseInt(dates[1]), 
                            Integer.parseInt(dates[2])
                        );
                        
                        System.out.println(user);

                        firstName.setText("");
                        lastName.setText("");
                        dateTextField.setText("");


                    }
                    else
                    {
                        System.out.println("Fields have to be filled");
                    }
                   
                    System.out.println( dateTextField.getText());
            }
          }          
        );
        reset = new JButton("Reset");
        reset.setMargin(new Insets(20,25,20,25));
        reset.setBackground(Color.WHITE);
        reset.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
					panelIndicator.setText("Clicked on reset!");				
            }
          }          
        );



        

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setPreferredSize(new Dimension(250, 50));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(submit);
        buttonsPanel.add(Box.createRigidArea(new Dimension(35, 0)));
        buttonsPanel.add(reset);
        
        
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(250, 270));
        infoPanel.add(Box.createRigidArea(new Dimension(250, 30)));
        infoPanel.add(inputsPanel);
        infoPanel.add(Box.createRigidArea(new Dimension(250,20)));
        infoPanel.add(buttonsPanel);
        infoPanel.add(Box.createRigidArea(new Dimension(250,10)));
        infoPanel.add(panelIndicator);
        

        add(imgPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }
}
public class Day28  
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("User registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI_D28());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}