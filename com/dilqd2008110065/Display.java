import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.HeadlessException;
public class Display extends JFrame {
    public  Display(String title) throws HeadlessException {
        super(title);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel labelUsername = new JLabel("Username");
        JLabel labelPassword = new JLabel("Password");
        JTextField txtUsername = new JTextField(50);
        JPasswordField txtPassword = new JPasswordField(50);
        JButton btnLogin = new JButton("Login");
        JButton btnExit = new JButton("Exit");    




    }
    public static void main(String[] args) {
       new Display("Manager").setVisible(true);
      
       

}}
