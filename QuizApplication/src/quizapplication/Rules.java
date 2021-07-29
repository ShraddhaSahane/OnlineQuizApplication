package quizapplication;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class Rules extends JFrame implements ActionListener
{
    JButton b1,b2;   //Declare variable
    String username;
    Rules(String username)   //Parameterized Constructor
    {
        // Frame is Created With white Background
        this.username=username;
        setBounds(300,70,800,600);//distance_left, distance_up,length, height
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Title text is added into frame
        JLabel l1= new JLabel(" Welcome "+username +" to My Quiz!! ");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setBounds(60,20,700,30);
        add(l1);
        JLabel l2= new JLabel("Rulessss");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Times New Roman", Font.BOLD,15));
        l2.setBounds(80,100,600,250);   //distance_left, distance_up,length, height
        l2.setText(
                "<html>" +
                    "* All Questions are Multiple Choice Questions."+"<br><br>"+
                    "* All Questions are Multiple Choice Questions."+"<br><br>"+
                    "* Attempt all Questions Compulsory" +"<br><br>"+     
                    "* Total 10 Questions ,Each Question of 10 marks"+"<br><br>"+
                    "* No Negative Marking."+"<br><br>"+
                    "* Turn off your cell (or put it on vibrate mode)" +"<br><br>"+
                    "* Keep track of time."+"<br><br>"+  
                    "* Score will be displayed after submitting the quiz"+"<br><br>"+
                    "ALL THE BEST !! GOOD LUCK !!"+"<br><br>"+
                "<html>"
                        );
        add(l2);
        
        //Add Back Button 
        b1= new JButton("Back");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b1.setBounds(250,450,100,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        //Text added using label
        JLabel l3= new JLabel("ALL THE BEST !! GOOD LUCK !!");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l3.setBounds(60,380,700,30); //distance_left, distance_up,length, height
        add(l3);
        
        //Add Start Button
        b2= new JButton("Start");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b2.setBounds(400,450,100,30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)//abstractmethod of interface ActionListener is implemented
    {
        if(ae.getSource() == b1) //when Back button is clicked
        {
            this.setVisible(false); // Rules window closes
            new Quiz().setVisible(true); // main window opens
        }
        else if(ae.getSource() == b2) //When Start Button is clicked
        {
            this.setVisible(false);// Rules window closes
            //new Questions(username).setVisible(true); //Quiz window opens
            new PL(username).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Rules("");
    }
}
