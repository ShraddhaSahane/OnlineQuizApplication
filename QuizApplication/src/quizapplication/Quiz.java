package quizapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Quiz extends JFrame implements ActionListener 
{
    JButton b1,b2;    //Declare Variables
    JTextField t1;
    Quiz()  //Default Constructor
    {
        // Frame is Created With white Background
        setBounds(90,80,1200,500); //distance_left, distance_up,length, height
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Image is added into frame
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("quizapplication/icons/login.jpeg"));
        JLabel l1= new JLabel(i1); 
        l1.setBounds(0,0 ,600 ,500 );
        add(l1);
        
        //Title text is added into frame
        JLabel l2= new JLabel("  My Quiz !!");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        l2.setBounds(750,30 ,300,200);
        add(l2);
        
        // Text added
        JLabel l3= new JLabel("Enter the UserName");
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l3.setBounds(810,100 ,300,200);
        add(l3);
        
        // textbox is added using Text Field
        t1= new JTextField();
        t1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        t1.setBounds(750,240,300,25);
        add(t1);
        
        //Rules and Start Button
        b1= new JButton("Rules & Start");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b1.setBounds(750,300,130,25);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        //Exit Button
        b2= new JButton("Exit");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b2.setBounds(920,300,120,25);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) //abstractmethod of interface ActionListener is implemented
    {
        if(ae.getSource()== b1) //When Rules and Start button is clicked , Returns object on which event is occured
        {
            String name=t1.getText();
            this.setVisible(false);    //Closing the frame MyJavaQuiz
            new Rules(name);
        }
        else            //When exit button is clicked
        {
            System.exit(0);
        }    
    }
    public static void main(String[] args) //Main function
    {
       new Quiz();
    }
    
}
