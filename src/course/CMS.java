package course;            // Package name 

import java.awt.Color;     // Java Swing library
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Image;

public class CMS  {     
	 private JTextField userText = new JTextField(); 
	 private JPasswordField passwordText = new JPasswordField();
	@SuppressWarnings("rawtypes")
	 private JComboBox combcms = new JComboBox();//
	 private JPanel panelcms = new JPanel();
	 private JFrame framecms = new JFrame(); 
	 private JButton button1 = new JButton("Exit");
	 private JButton buttonlog = new JButton("Login");
	 private JLabel passwordLabel =new JLabel("Password:");
	 private JLabel Userlabel =new JLabel("Username:");
     private ImageIcon Herald = new ImageIcon("img.jpg"); // adding the image at the top 
     private final JLabel lblNewLabel = new JLabel("Login");
     private final JLabel iijj = new JLabel("Welcom to the Herald College Course_work_Management ");
     
	

 void Logincms() {                  // method for creating frame for login

		// Creating a frame
		
		framecms.setTitle("Course Management System");// Title of frame
		framecms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit our application
		framecms.setResizable(false);//size code
		framecms.setSize(730,630);//set the dimension for X and Y for  our frame
		
	
	     // login image box 
		ImageIcon img = new ImageIcon("login.png");
		
		panelcms.setForeground(new Color(0, 128, 0));
		
	
		framecms.setIconImage(Herald.getImage()); //change image
		framecms.getContentPane().setBackground(new Color(0, 255, 0));// 0,255,255 Change color in background
        framecms.getContentPane().add(panelcms);
        
        
        // for LEVEL 
        String[] levelcms3= {"Student","Administration","Instructor"};
        panelcms.setLayout(null);
        combcms = new JComboBox(levelcms3);
        combcms.setBounds(326, 432, 147, 35);
        panelcms.add(combcms);
        combcms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) { 
                System.out.println(combcms.getSelectedItem());

              }

          });
        Userlabel.setBounds(170, 316, 200, 35);
        Userlabel.setForeground(new Color(255, 255, 255));
        
        
        // for User and user login box for printing name user

        Userlabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        panelcms.add(Userlabel);
        userText.setBounds(290, 320, 225, 35);
        panelcms.add(userText);
        passwordLabel.setBounds(172, 371, 100, 35);
        passwordLabel.setForeground(new Color(255, 255, 255));
        
        // for password and password login box  
    
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        panelcms.add(passwordLabel);
        passwordText.setBounds(290, 375, 225, 35);
        panelcms.add(passwordText);
        buttonlog.setBounds(510, 517, 100, 35);
        buttonlog.setBackground(new Color(192, 192, 192));
        
        
        // for Buttons  for word login 

        buttonlog.setFont(new Font("Verdana", Font.PLAIN, 20));
       // buttonlog.setBackground(Color.ORANGE);
        panelcms.add(buttonlog);
        buttonlog.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ee){
               
           // Connection for login different classes student, instructor and admin.
               try {
                   Connection con=null;
                   PreparedStatement pst=null;
                   ResultSet rs=null;
                   String query="SELECT * FROM `login` WHERE username=? and password=? and usertype=?";
                   con=DriverManager.getConnection("jdbc:mysql://localhost/connection","root","");
                   pst=con.prepareStatement(query);
                   pst.setString(1, userText.getText());
                   pst.setString(2, passwordText.getText());
                   pst.setString(3, String.valueOf(combcms.getSelectedItem()));
                   rs=pst.executeQuery();
                   if(rs.next()) {
                       JOptionPane.showMessageDialog(null,"Login Sucessfully");
                       
                   if(combcms.getSelectedIndex()==0) {
                       Student  std =new Student();
                      
               		   std.student();
                       
                       std.setVisible(true);
                       framecms.setVisible(false);
                      
                       }
                   else if(combcms.getSelectedIndex()==1) {
                	   
                        Administration  ad = new Administration();
                        ad.Adminiad();
            			ad.Tablead();
                       ad.setVisible(true);
                       framecms.setVisible(false);
                	   
                       }
                   else if(combcms.getSelectedIndex()==2) {
                	   Instructor ins = new Instructor();
                	   ins.Instructor1();
                	   ins.InsConn();
                       ins.setVisible(true);
                       framecms.setVisible(false);
                       }
                  
                   }
                   else {
                       JOptionPane.showMessageDialog(null,"Invalid username and password");
                   }
                   
  // Exception handling                  
               }catch(Exception ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage());
               }
               
                   
               
            }
        });
        button1.setBounds(102, 517, 87, 35);
     
    
        // For exit  word exit 
  
        button1.setFont(new Font("Verdana", Font.PLAIN, 20));
       button1.setBackground(new Color(192, 192, 192));
        panelcms.add(button1);
        // Method Overriding 
        button1.addActionListener((ActionListener) new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) { 
              JOptionPane.showMessageDialog(null,"After this dialog box is closed your program is terminated");
              System.exit(0);

            }

        });
        
        
    	
		// for border 
		panelcms.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), null)); 
        // to make all visible and should be kept at button only 
        framecms.setVisible(true);//Make Frame Visible 
        panelcms.setOpaque(true);
		
		panelcms.setBackground(new Color(0, 64, 128));
		lblNewLabel.setBounds(304, 238, 161, 43);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelcms.add(lblNewLabel);
		iijj.setForeground(new Color(64, 0, 0));
		iijj.setBackground(new Color(255, 128, 255));
		iijj.setHorizontalAlignment(SwingConstants.CENTER);
		iijj.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 25));
		iijj.setBounds(10, 109, 706, 129);
		
		panelcms.add(iijj);
        
        

	}
	  
		   
		  public static void main(String args[]) {
			CMS cms = new CMS();
			cms.Logincms();
			
			
		}
		
		 public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
	   }

		



