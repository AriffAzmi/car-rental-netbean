package carrental;

import carrental.services.CurrentUserService;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
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

public class Home {

    public static void main(String[] args) {

    }

    public static void show() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container panel = frame.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel pnlTop = new JPanel();
        pnlTop.setPreferredSize(new Dimension(10, 50));
        panel.add(pnlTop);

        JLabel lblUser = new JLabel("Welcome, " + CurrentUserService.getName());
        JPanel pnlUser = new JPanel(new FlowLayout());
        pnlUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlUser.add(lblUser);
        panel.add(pnlUser);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
                Index.loginForm();
            }
        });
        panel.add(btnLogout);

        JPanel pnlBottom = new JPanel();
        pnlBottom.setPreferredSize(new Dimension(10, 50));
        panel.add(pnlBottom);

        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
