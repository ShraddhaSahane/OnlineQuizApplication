package quizapplication;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Question_C extends JFrame implements ActionListener
{
    JButton submit, next, back;
    JLabel q, qno;
    static int count=0;
    static int timer=20;
    static int ans_given=0;
    int score=0;
    String q1[][]= new String[10][5]; //2D Array to store question with multiple option
    String Rans[][]=new String[10][2]; //2D Array to store correct answer for question
    String ans[][]=new String[10][1];  //2D array to store answer given by user
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup opt;
    String username;
    String lang;
    Question_C(String username,String lang)
    {
        this.username=username;
        this.lang=lang;
        q1[0][0] = "Who invented C Language?";
        q1[0][1] = "Charles Babbage";
        q1[0][2] = "Grahambel";
        q1[0][3] = "Dennis Ritchie";
        q1[0][4] = "Steve Jobs";
        
        q1[1][0] = "What is an Identifier in C Language?";
        q1[1][1] = "Name of a Function or Variable";
        q1[1][2] = "Name of a Macros";
        q1[1][3] = "Name of Structure or Union";
        q1[1][4] = "All the above.";

        q1[2][0] = "Variables of type auto, static and extern are all stored in ?";
        q1[2][1] = "ROM";
        q1[2][2] = "RAM";
        q1[2][3] = "CPU";
        q1[2][4] = "Compiler";

        q1[3][0] = "A function which calls itself is called a .....function.";
        q1[3][1] = "Self Function";
        q1[3][2] = "Auto Function";
        q1[3][3] = "Recursive Function" ;
        q1[3][4] = "Static Function";

        q1[4][0] ="Operator % in C Language is called?" ;
        q1[4][1] ="Percentage Operator" ;
        q1[4][2] ="Quotient Operator" ;
        q1[4][3] ="Modulus";
        q1[4][4] ="Division";

        q1[5][0] ="What is the default C Storage Class for a variable?" ;
        q1[5][1] ="static";
        q1[5][2] ="auto";
        q1[5][3] ="register" ;
        q1[5][4] ="extern";

        q1[6][0] ="Find a Floating Point constant." ;
        q1[6][1] ="12.3E5";
        q1[6][2] ="12e34";
        q1[6][3] ="125.34857" ;
        q1[6][4] ="All the above.";

        q1[7][0] ="What are the types of Constants in C Language?" ;
        q1[7][1] ="Primary Constants" ;
        q1[7][2] ="Secondary Constants" ;
        q1[7][3] ="Basic & Advanced Constants" ;
        q1[7][4] ="Both primary and secondary";
        
        q1[8][0] = "C is ...... type of programming language.?";
        q1[8][1] = "Procedural";
        q1[8][2] = "Object Oriented";
        q1[8][3] = "Bit level language";
        q1[8][4] = "Functional";

        q1[9][0] ="C language was invented to develop which Operating System.?";
        q1[9][1] ="Android" ;
        q1[9][2] ="Linux";
        q1[9][3] ="Ubuntu" ;
        q1[9][4] ="Unix" ;
        //Correct answer to question
        Rans[0][1] = "Dennis Ritchie";
        Rans[1][1] ="All the above." ;
        Rans[2][1] ="RAM";
        Rans[3][1] ="Recursive Function" ;
        Rans[4][1] ="Modulus";
        Rans[5][1] ="auto";
        Rans[6][1] ="All the above.";
        Rans[7][1] ="Both primary and secondary";
        Rans[8][1] ="Procedural";
        Rans[9][1] ="Unix";

        // Frame is Created With white Background
        setBounds(60,20,1100,630); //distance_left, distance_up,length, height
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Image is added into frame
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("quizapplication/icons/quiz.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0 ,1160 ,290 );
        add(l1);
        
        //Adding Question to the Frame
        qno = new JLabel("");
        qno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        qno.setBounds(100,310,40,20);   //distance_left, distance_up,length, height
        add(qno);
        q = new JLabel(" ");
        q.setFont(new Font("Times New Roman", Font.BOLD, 20));
        q.setBounds(120,310,700,20);
        add(q);
        //Option 1
        opt1= new JRadioButton("");
        opt1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        opt1.setBounds(140,390,700,18);
        opt1.setBackground(Color.WHITE);
        add(opt1);
        //option 2
        opt2= new JRadioButton("");
        opt2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        opt2.setBounds(140,420,700,18);
        opt2.setBackground(Color.WHITE);
        add(opt2);
        //option 3
        opt3= new JRadioButton("");
        opt3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        opt3.setBounds(140,450,700,18);
        opt3.setBackground(Color.WHITE);
        add(opt3);
        //Option 4
        opt4= new JRadioButton("");
        opt4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        opt4.setBounds(140,480,700,18);
        opt4.setBackground(Color.WHITE);
        add(opt4);
        // Grouped all radio button , to select one option
        opt = new ButtonGroup();
        opt.add(opt1);
        opt.add(opt2);
        opt.add(opt3);
        opt.add(opt4);
        
        //Added next Button
        next= new JButton("Next");
        next.setFont(new Font("Times New Roman", Font.BOLD, 18));
        next.setBounds(850,410,100,30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        // Added back button
        back= new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.BOLD, 18));
        back.setBounds(850,450,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setEnabled(false); 
        back.addActionListener(this);
        add(back);
        
        //Add the submit button
        submit= new JButton("Submit");
        submit.setBounds(850,490,100,30);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 18));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false); // Submit button is not active
        submit.addActionListener(this);
        add(submit);
         
        setVisible(true);
        startquiz(0);
    }
    public void startquiz(int count)  //Start quiz method
    {
        qno.setText(""+(count+1)+".");
        q.setText(q1[count][0]);
        opt1.setText(q1[count][1]);
        opt1.setActionCommand(q1[count][1]);
        opt2.setText(q1[count][2]);
        opt2.setActionCommand(q1[count][2]);
        opt3.setText(q1[count][3]);
        opt3.setActionCommand(q1[count][3]);
        opt4.setText(q1[count][4]);
        opt4.setActionCommand(q1[count][4]);
        opt.clearSelection();
    }
    public void paint( Graphics g)
    {
        super.paint(g);
        String time ="Time Left:- "+timer +" Seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Copper Black", Font.BOLD,20));
        if(timer>0)
        {
            g.drawString(time,800,400);
        }
        else // Time is over
        {
            g.drawString("Time Up!!",850,400);
        }
        timer --;
        try{
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        if(count >0)
        {
            back.setEnabled(true);
               // submit.setEnabled(true);
        }
        if(ans_given == 1) //Answer is selected , againset timer
        {
            ans_given=0;
            timer=20;
            if(count == 0)
            {
                back.setEnabled(false);
                //submit.setEnabled(true);
            }
        }
        else if(timer <0) //answer not selected , times up
        {
            timer=20;   //Again set timer
            if(count == 0)
            {
                back.setEnabled(false);
               // submit.setEnabled(true);
            }
            if(count == 8)
            {
                next.setEnabled(false); //disable next button 
                submit.setEnabled(true); //enable submit button
            }
            if(count == 9) //for last question 
            {
                if(opt.getSelection() == null) // no option is selected
                {
                    ans[count][0]="";
                }
                else    //one option is selected
                {
                     ans[count][0] = opt.getSelection().getActionCommand();
                }
                for(int i=0;i<ans.length;i++)// checking the answer
                {
                    if(ans[i][0].equals(Rans[i][1])) //answer is correct
                    {
                        score=score+10;     //increment score
                    }
                    else // wrong answer
                    {
                        score=score+0;
                    }
                }
                try
                {
                    score_record(username,score,lang);
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                } 
                this.setVisible(false);// close quiz window 
                new Score(username,score,lang).setVisible(true); // score window opens
            }
            else
            {
                if(opt.getSelection() == null)  // no option is selected
                {
                    ans[count][0]="";
                }
                else    //one option is selected
                {
                     ans[count][0] = opt.getSelection().getActionCommand();
                }
                count++;
                startquiz(count);
            }
            
        }
    }
    public void actionPerformed(ActionEvent ae) //abstractmethod of interface ActionListener is implemented
    {
        if(ae.getSource() == next)  //When Next Button is clicked
        {
            repaint();
            ans_given=1;
            if(opt.getSelection() == null)// no option is selected
            {
                ans[count][0]="";
            }
            else    //one option is selected
            {
                 ans[count][0] = opt.getSelection().getActionCommand();
            }
            if(count == 8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            startquiz(count);
        }
        else if(ae.getSource() == submit) //When Submit Button is Clicked
        {
            ans_given =1;
            if(opt.getSelection() == null)  // no option is selected
            {
                ans[count][0]="";
            }
            else    //one option is selected
            {
                ans[count][0] = opt.getSelection().getActionCommand();
            }
            for(int i=0;i<ans.length;i++) // checking the answers
            {
                if(ans[i][0].equals(Rans[i][1])) //Answer is correct
                {
                    score=score+10; //increment score
                }
                else    //wrong answer
                {
                    score=score+0;
                }
            }
            try
            {
                score_record(username,score,lang);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ClassNotFoundException ex)
            {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } 
            this.setVisible(false);// quiz window is closed 
            new Score(username,score,lang).setVisible(true); //Score window is opened
        }
        else if(ae.getSource()==back)
        {
            repaint();
            ans_given=1;
            if(opt.getSelection() == null)// no option is selected
            {
                ans[count][0]="";
            }
            else    //one option is selected
            {
                 ans[count][0] = opt.getSelection().getActionCommand();
            }
            count--;
            if(count == 0)
            {
                back.setEnabled(false);
               // submit.setEnabled(true);
            }
            startquiz(count);
        }
    }
    private void score_record(String username,int score,String lang) throws SQLException, ClassNotFoundException
    {
        //Register the driver.i.e Adding mysql database driver to classpath
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connect to the database
        Connection dbconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "2001");
        //Query. It represents precomplied SQL statement.
        PreparedStatement st= dbconn.prepareStatement("INSERT INTO score (username,score,Programing_language)VALUES(?,?,?)");
        st.setString(1,username );
        st.setInt(2,score);
        st.setString(3, lang);
        //execute query
        int res =st.executeUpdate();     
        JOptionPane.showMessageDialog(this,"Score will be displayed ","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
        
    }
     public static void main(String[] args)
    {
        new Question_C("","");
        
    }
}
