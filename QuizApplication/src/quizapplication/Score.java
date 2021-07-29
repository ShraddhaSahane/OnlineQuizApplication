package quizapplication;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener
{
    JButton b1,b2,b3; //Declare Variables
    String username;
    String lang;
    int score;
    Score(String username,int score,String lang)  // Parameterized Constructor 
    {
        this.username=username;
        this.lang=lang;
        this.score=score;
        // Frame is Created With white Background
        setBounds(100,30,900,600); //distance_left, distance_up,length, height
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         // Image is added into frame
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("quizapplication/icons/score.jpg"));
        JLabel l1= new JLabel(i1);
        l1.setBounds(20,160 ,400 ,350 );    //distance_left, distance_up,length, height
        add(l1);
        //Title text is added into frame
        JLabel l2= new JLabel(" Thankyou!! "+username+" For attempting Quiz.");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        l2.setBounds(50,0 ,1000 ,200);
        add(l2);
        //Text added
        JLabel l3= new JLabel(" Your Score is : "+score);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        l3.setBounds(500,100 ,500,150);//distance_left, distance_up,length, height
        add(l3);
        
        JLabel l4= new JLabel("Total no. of Questions : 10 ");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        l4.setBounds(500,130 ,500,150);//distance_left, distance_up,length, height
        add(l4);
        
        JLabel l5= new JLabel("Number of Correct Answer : "+(score/10));
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        l5.setBounds(500,160 ,500,150);//distance_left, distance_up,length, height
        add(l5);
        
        JLabel l6= new JLabel("Number of Wrong Answer : "+(10-(score/10)));
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        l6.setBounds(500,190 ,500,150);//distance_left, distance_up,length, height
        add(l6); 
        
        //Add Attempt Again button
        b1= new JButton("Attempt Again");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b1.setBounds(520,330,200,30);   //distance_left, distance_up,length, height
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b3= new JButton("See correct answers");
        b3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b3.setBounds(520,380,200,30);   //distance_left, distance_up,length, height
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        //Add Exit Button
        b2= new JButton("Exit");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b2.setBounds(520,430,200,30);//distance_left, distance_up,length, height
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)//abstractmethod of interface ActionListener is implemented
    {
        if(ae.getSource()== b1)//When Attempt again Button is clicked
        {
            this.setVisible(false);// Score window closses
            new Quiz().setVisible(true);//main window opens
        }
        else if(ae.getSource()== b3)// when see correct answer button is clicked
        {
            this.setVisible(false);
            if(lang=="C Language")
            {
                new AnsC(username,score,lang).setVisible(true);
            }
            else if(lang=="C++ Language")
            {
                new AnsCpp(username,score,lang).setVisible(true);
            }
            else if(lang=="JAVA")
            {
                new AnsJ(username,score,lang).setVisible(true);
            }
        }
        else        //When exit Button is clicked
        {
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        new Score("",0,"");
    }
}
