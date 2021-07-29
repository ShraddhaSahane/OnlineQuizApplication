package quizapplication;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
public class Login extends JFrame  //Login class
{
    public Login() //Default Constructor
    { 
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tf_username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtRegister = new javax.swing.JButton();
        bt_login = new javax.swing.JButton();
        tf_password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login | XEMACSCOOE");

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizapplication/icons/Username.jpg"))); // NOI18N
        jLabel1.setLabelFor(jLabel1);
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizapplication/icons/Password.jpg"))); // NOI18N
        jLabel2.setLabelFor(jLabel2);
        jLabel2.setText("jLabel2");

        BtRegister.setBackground(new java.awt.Color(255, 153, 0));
        BtRegister.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        BtRegister.setText("Register");
        BtRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegisterActionPerformed(evt);
            }
        });

        bt_login.setBackground(new java.awt.Color(255, 153, 0));
        bt_login.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        bt_login.setText("Login ");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setText("Login  Page");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Username and Password Should contain exactly 6 Characters");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel4)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegisterActionPerformed
      //When register button is clicked
       dispose();   //Login page will be closed
       Registration r =new Registration(); 
       r.setTitle("Registration Page"); // used to change title of JFrame
       r.setLocationRelativeTo(null);//centre the form
       r.setVisible(true); //Registration page will appear
    }//GEN-LAST:event_BtRegisterActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
       // When login button is clicked
        String username =tf_username.getText();
        String userpassword =String.valueOf(tf_password.getPassword());
        if(username.isEmpty() || userpassword.isEmpty())//validation
        {
             JOptionPane.showMessageDialog(this,"Username / Password Should not be empty.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(username.length()!=6 || userpassword.length()!=6)// validation for username and password(should contain 6 characters only)
            {
                JOptionPane.showMessageDialog(this,"Username and password should contain 6 characters","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try 
                {
                    UserLogin(username ,userpassword);
                } 
                catch (SQLException ex) 
                {
                    System.out.println(ex);
                   // Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (ClassNotFoundException ex) 
                {
                    System.out.println(ex);
                   // Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }//GEN-LAST:event_bt_loginActionPerformed
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Login().setVisible(true);   // Login class object created
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtRegister;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
    private void UserLogin(String username, String userpassword) throws SQLException, ClassNotFoundException  
    {
        //Register the driver.i.e Adding mysql database driver to classpath.
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connect to the database
        Connection dbconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "2001");
        //Query. It represents precomplied SQL statement.
        PreparedStatement st=dbconn.prepareStatement("Select * from user WHERE username = ? AND userpassword=?");
        st.setString(1, username);
        st.setString(2, userpassword);
        //execute query
        ResultSet res =st.executeQuery();// returns the table in resultset object
        //process the result set
        if(res.next()) //data found
        {
            JOptionPane.showMessageDialog(this,"Login Successfully ","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();// login page closes
            Quiz q =new Quiz();
            q.setVisible(true);//Quiz page opens
        }
        else   // data  not found
        {
            System.out.println("username "+username);
            System.out.println("password "+userpassword);
            JOptionPane.showMessageDialog(this,"Username / Password not found","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}   
