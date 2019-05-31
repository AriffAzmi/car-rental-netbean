package carrental;

import carrental.services.AuthService;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Index {

    public static void main(String[] args) {
        loginForm();
    }

    public static void loginForm() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container panel = frame.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel pnlTop = new JPanel();
        pnlTop.setPreferredSize(new Dimension(10, 50));
        panel.add(pnlTop);

        JLabel lblUser = new JLabel("Username :");
        lblUser.setPreferredSize(new Dimension(100, 30));

        JTextField tfUser = new JTextField();
        tfUser.setPreferredSize(new Dimension(200, 30));

        JPanel pnlUser = new JPanel(new FlowLayout());
        pnlUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlUser.add(lblUser);
        pnlUser.add(tfUser);
        panel.add(pnlUser);

        JLabel lblPass = new JLabel("Password :");
        lblPass.setPreferredSize(new Dimension(100, 30));

        JPasswordField pfPass = new JPasswordField();
        pfPass.setPreferredSize(new Dimension(200, 30));

        JPanel pnlPass = new JPanel(new FlowLayout());
        pnlPass.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlPass.add(lblPass);
        pnlPass.add(pfPass);
        panel.add(pnlPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnRegister = new JButton("Register");
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfUser.getText();
                String pass = new String(pfPass.getPassword());
                
                if (!AuthService.login(user, pass)) {
                    JOptionPane.showMessageDialog(null, "Invalid username and/or password.", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Login OK.", "OK!", JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(false);
                    Home.show();
                }
            }

        });
        
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                registrationForm();
            }

        });
        
        panel.add(btnLogin);
        panel.add(btnRegister);

        JPanel pnlBottom = new JPanel();
        pnlBottom.setPreferredSize(new Dimension(10, 50));
        panel.add(pnlBottom);

        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void registrationForm() {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container panel = frame.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel pnlTop = new JPanel();
        pnlTop.setPreferredSize(new Dimension(10, 50));
        panel.add(pnlTop);

        JLabel lblUser = new JLabel("Username :");
        lblUser.setPreferredSize(new Dimension(100, 30));

        JTextField tfUser = new JTextField();
        tfUser.setPreferredSize(new Dimension(200, 30));

        JPanel pnlUser = new JPanel(new FlowLayout());
        pnlUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlUser.add(lblUser);
        pnlUser.add(tfUser);
        panel.add(pnlUser);

        JLabel lblPass = new JLabel("Password :");
        lblPass.setPreferredSize(new Dimension(100, 30));

        JPasswordField pfPass = new JPasswordField();
        pfPass.setPreferredSize(new Dimension(200, 30));

        JPanel pnlPass = new JPanel(new FlowLayout());
        pnlPass.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlPass.add(lblPass);
        pnlPass.add(pfPass);
        panel.add(pnlPass);

        JButton btnRegister = new JButton("Register");
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnLogin = new JButton("Login");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfUser.getText();
                String pass = new String(pfPass.getPassword());
                
                try {
                    if (!AuthService.register(user, pass)) {
                        JOptionPane.showMessageDialog(null, "Registration failed.", "Error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration success.", "OK!", JOptionPane.INFORMATION_MESSAGE);
                        frame.setVisible(false);
                        Home.show();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                loginForm();
            }

        });
        
        panel.add(btnRegister);
        panel.add(btnLogin);

        JPanel pnlBottom = new JPanel();
        pnlBottom.setPreferredSize(new Dimension(10, 50));
        panel.add(pnlBottom);

        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
