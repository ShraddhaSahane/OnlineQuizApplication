package quizapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PL extends JFrame implements ActionListener 
{
    //Declare variable
    JButton b1,b2,b3,b4;
    String username;
    String lang;
    PL(String username)    //Parameterized Constructor
    {
        this.username=username;
        // Frame is Created With white Background
        setBounds(90,80,900,450); //distance_left, distance_up,length, height
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Title text is added into frame
        JLabel l1= new JLabel("Select Programing Language to Attempt Quiz");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Mongolian Baiti", Font.BOLD, 35));
        l1.setBounds(50,30,800,200);
        add(l1);
        
        //Add C button
        b1= new JButton("C Language");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setBounds(200,180,500,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
         
        // Add C++ Button
        b2= new JButton("C++ Language");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b2.setBounds(200,220,500,30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        //Add java Button
        b3= new JButton("JAVA");
        b3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b3.setBounds(200,260,500,30);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        //Add back button
        b4= new JButton("BACK");
        b4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b4.setBounds(200,300,500,30);
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)//abstractmethod of interface ActionListener is implemented
    {
        if(ae.getSource()== b1) //when C button is clicked
        {
            String lang="C Language";
            this.setVisible(false);//
            new Question_C(username,lang).setVisible(true);
        }
        else if(ae.getSource()== b2)//when C++ button is clicked
        {
            String lang="C++ Language";
            this.setVisible(false);
             new Question_Cpp(username,lang).setVisible(true);
        }
        else if(ae.getSource()== b3)//when java button is clicked
        {
            String lang="JAVA";
            this.setVisible(false);
            new Questions(username,lang).setVisible(true);
        }
        else if(ae.getSource()== b4) // //when Back button is clicked
        {
            this.setVisible(false);
            new Rules(username).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new PL("");
    }
        
}
