import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomePage implements ActionListener
{
	
	JFrame frame;
	JLabel imageBg;
	JPanel titleBar;
	JTextField name;
	JButton closeButton, attenButton, checkButton, view;
	JLabel imageLabel, attendance, Penpals, logoLabel, desc, UILabel, atten, attendanceShadow;
	JLayeredPane layer;
	ImageIcon image, logo, UI;

	HomePage(){
		
	    frame = new JFrame();
        frame.setUndecorated(true); // Removes the default title bar
        
        // JLayered pane
        
        image = new ImageIcon("black2.jpg");
        logo = new ImageIcon("layers.png");
        UI = new ImageIcon("PHINMA-UI.png");
        
        closeButton = new JButton("X");
        closeButton.setFont(new Font("Verdana", Font.PLAIN,25));
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(e -> System.exit(0));
        closeButton.setForeground(Color.decode("#F8F0E5"));
        closeButton.setBounds(520,-20,100,100);
        
        attenButton = new JButton("Attendance");
        attenButton.setFont(new Font("Arial", Font.BOLD, 19));
        attenButton.setFocusable(false);
        attenButton.addActionListener(this);
        attenButton.setFocusPainted(false);
        attenButton.setBorderPainted(false);
        attenButton.setForeground(Color.decode("#0F0F0F"));
        attenButton.setBackground(Color.decode("#86A3B8"));
        attenButton.setBounds(310,430,140,50);
        
        view = new JButton("View Presence");
        view.setBounds(120,430,140,50);
        view.setFont(new Font("Arial", Font.BOLD, 17));
        view.setForeground(Color.decode("#0F0F0F"));
        view.setBackground(Color.decode("#86A3B8"));
        view.setFocusPainted(false);
        view.setBorderPainted(false);
        view.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        view.setFocusable(false);
        view.addActionListener(this);
        
        
        desc = new JLabel("University of Iloilo");
        desc.setBounds(188,253,300,100);
        desc.setFont(new Font("Algerian", Font.PLAIN, 22));
        desc.setForeground(Color.WHITE);
        
        atten = new JLabel("Attendance Form");
        atten.setForeground(Color.WHITE);
        atten.setFont(new Font("Verdana", Font.PLAIN, 20));
        atten.setBounds(214,285,300,100);
        
        attendance = new JLabel("Welcome");
        attendance.setForeground(Color.WHITE);
        attendance.setFont(new Font("Monotype Corsiva", Font.BOLD, 75));
        attendance.setBounds(169,15,300,200);
        
        attendanceShadow = new JLabel("Welcome");
        attendanceShadow.setFont(new Font("Monotype Corsiva", Font.BOLD, 75));
        attendanceShadow.setBounds(220,17,300,200);
        
        Penpals = new JLabel("Pen Pals");
        Penpals.setForeground(Color.decode("#79AC78"));
        Penpals.setFont(new Font("Arial", Font.BOLD, 18));
        Penpals.setBounds(35,10,100,100);
                
        imageLabel = new JLabel(image);
        imageLabel.setBounds(0,-250,image.getIconWidth(), image.getIconHeight());
        
        logoLabel = new JLabel(logo);
        logoLabel.setBounds(20,-18,100,100);
        
        UILabel = new JLabel(UI);
        UILabel.setBackground(Color.WHITE);
        UILabel.setBounds(234,150,UI.getIconWidth(),UI.getIconHeight());
        
        
        layer =  new JLayeredPane();
        layer.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        layer.setLayout(null);
        layer.add(imageLabel, Integer.valueOf(0));	
        layer.add(attendance, Integer.valueOf(1));
        layer.add(closeButton, Integer.valueOf(1));
        layer.add(attenButton, Integer.valueOf(1));
        layer.add(Penpals, Integer.valueOf(1));
        layer.add(logoLabel, Integer.valueOf(1));
        layer.add(desc, Integer.valueOf(1));
        layer.add(UILabel, Integer.valueOf(1));
        layer.add(atten, Integer.valueOf(1));
        layer.add(view, Integer.valueOf(1));
        //layer.add(attendanceShadow, Integer.valueOf(1));
        
        
        frame.add(layer);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
       
        
        
	}
	
	public static void main(String[] args) {
		new HomePage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == attenButton) {
			new Form();
			frame.dispose();
		}
		
		if(e.getSource() == view) {
			new Display();
			frame.dispose();
		}
	}
}
