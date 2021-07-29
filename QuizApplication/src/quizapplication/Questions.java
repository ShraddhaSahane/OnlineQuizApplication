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
public class Questions extends JFrame implements ActionListener
{
    // Declare  Variables
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
    int userid=0;
    Questions(String username,String lang)   // Parameterized  Constructor
    {
        this.username=username;
        this.lang=lang;
        //question and its options
        q1[0][0] = "In java, jar stands for?";
        q1[0][1] = "Java Archive Runner";
        q1[0][2] = "Java Archive";
        q1[0][3] = "Java Application Resource";
        q1[0][4] = "Java Application Runner";
        
        q1[1][0] = "Which keyword is used for accessing the features of a package?";
        q1[1][1] = "import";
        q1[1][2] = "package";
        q1[1][3] = "extends";
        q1[1][4] = "export";

        q1[2][0] = "What is the initial quantity of the ArrayList list?";
        q1[2][1] = "5";
        q1[2][2] = "10";
        q1[2][3] = "0";
        q1[2][4] = "100";

        q1[3][0] = "In Java Thread can be created by ....";
        q1[3][1] = "Extending the thread class.";
        q1[3][2] = "Implementing Runnable interface.";
        q1[3][3] = "Both of the above" ;
        q1[3][4] = "None of these";

        q1[4][0] = "What will be return type of method that will not return anything?";
        q1[4][1] = "void";
        q1[4][2] = "int";
        q1[4][3] = "double";
        q1[4][4] = "none of these";

        q1[5][0] = "Which package contains the Random class?";
        q1[5][1] = "java.util package";
        q1[5][2] = "java.lang package";
        q1[5][3] = "java.awt package";
        q1[5][4] = "java.io package";

        q1[6][0] = "Which of the following is correct Interface ?";
        q1[6][1] = "interface A { void print() { } }";
        q1[6][2] = "abstract interface A { print(); }";
        q1[6][3] = "abstract interface A { abstract void print(); { }}";
        q1[6][4] = "interface A { void print(); }";

        q1[7][0] = "Which class is at thr top of exception class ?";
        q1[7][1] = "ArithmeticException";
        q1[7][2] = "Throwable";
        q1[7][3] = "Object";
        q1[7][4] = "Exception";
        
        q1[8][0] = "The object is created by new keyword ...";
        q1[8][1] = "At Compile-time";
        q1[8][2] = "At run-time";
        q1[8][3] = "Depends on the code";
        q1[8][4] = "None of these";

        q1[9][0] = " Which of the modifier can't be used for constructor?";
        q1[9][1] = "private";
        q1[9][2] = "public";
        q1[9][3] = "static";
        q1[9][4] = "protected";
        //Correct answer to question
        Rans[0][1] = "Java Archive";
        Rans[1][1] = "import";
        Rans[2][1] = "10";
        Rans[3][1] = "Both of the above" ;
        Rans[4][1] = "void";
        Rans[5][1] = "java.util package";
        Rans[6][1] ="interface A { void print(); }";
        Rans[7][1] ="Throwable";
        Rans[8][1] ="At run-time";
        Rans[9][1] = "static";

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
        //Register the driver.i.e Adding mysql database driver to classpath.
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connect to the database
        Connection dbconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "2001");
        //Query. It represents precomplied SQL statement.
        PreparedStatement st= dbconn.prepareStatement("INSERT INTO score (username,score,Programing_Language)VALUES(?,?,?)");
        st.setString(1,username );
        st.setInt(2,score);
        st.setString(3, lang);
        //execute query
        int res =st.executeUpdate(); 
        JOptionPane.showMessageDialog(this,"Score will be displayed ","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
        
    }
    public static void main(String[] args)// main class
    {
        new Questions("","");
        
    }
}
