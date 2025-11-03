import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


public class Form implements ActionListener, KeyListener{
		
	static JFrame frame;
	private JLabel registration,nameLabel,lastnameLabel,idLabel,genderLabel,ageLabel,SubjectLabel,SectionLabel;
	JButton submit, close, back;
	static JTextField name,lastname,id,age;
	static JRadioButton gender1, gender2;
	JPanel panel;
	static String s1;
	static int age1;
	static ButtonGroup group;
	static String genderValue;
	static String Fname, Lname, ID, sub, Section;
	static String Male, Female;
	ImageIcon image;
	JLayeredPane layer;
	JLabel design;
	JDateChooser dateChooser;
	SimpleDateFormat dateFormat;
	static String formattedDate;
	Date selectedDate;
	static String holder;
	static String sec, sec2;
	Object section, subject;
	static JComboBox<String> sections, subjectDropdown;
	
	Form(){
		
    
		
		frame();
		setBounds();
		setFont();
		setColor();
		setBorder();
		addKeyListener();
		setHolder();
		PlaceHolder.listener();
        
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void frame() {
		
	    registration = new JLabel("Student Attendance Form");
		nameLabel = new JLabel("First Name");
		lastnameLabel = new JLabel("Last Name");
		idLabel = new JLabel("ID No.");
		genderLabel = new JLabel("Gender");
		ageLabel = new JLabel("Date");
		SubjectLabel = new JLabel("Subject");
		SectionLabel = new JLabel("Section");
		name = new JTextField();
		lastname = new JTextField();
		id = new JTextField();
		age = new JTextField();
		subject = new JTextField();
		
		gender1 = new JRadioButton("Male");
		gender1.setFocusable(false);
		gender1.addActionListener(this);
		
		gender2 = new JRadioButton("Female");
		gender2.setFocusable(false);
		gender2.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(gender1);
		group.add(gender2);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#3F2E3E"));
		panel.add(registration);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setFocusable(false);
		submit.setFocusPainted(false);
	    submit.setBorderPainted(false);
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.decode("#04364A"));
		
		close = new JButton("X");
		close.setFont(new Font("Verdana", Font.BOLD, 25));
		close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setForeground(Color.white);
        close.addActionListener(e -> System.exit(0));
        
        back = new JButton("Back");
        back.setFont(new Font("Verdana", Font.BOLD, 20));
        back.setForeground(Color.white);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setBounds(230,520,150,50);
		back.addActionListener(this);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBorder(new EmptyBorder(0,0,0,0));
		
		String[] secs = {"Select Section","UI-FC2-BSIT2-1","UI-FC2-BSIT2-2","UI-FC2-BSIT2-3"};
		sections = new JComboBox(secs);
		sections.setBounds(290,400,170,35);
		sections.addActionListener(this);
		sections.setFocusable(false);
		sections.setFont(new Font("Verdana", Font.BOLD, 14));
		
		String[] subs = {"Select Subject", "ITE 300", "ITE 292", "ITE 083", "ITE 031", "ITE 298"};
		subjectDropdown = new JComboBox(subs);
		subjectDropdown.setBounds(290,350,170,35);
		subjectDropdown.setFocusable(false);
		subjectDropdown.setFont(new Font("Verdana",Font.BOLD,14));
		subjectDropdown.addActionListener(this);
		
		/*selectedDate = dateChooser.getDate();
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		formattedDate = dateFormat.format(selectedDate);*/
		
		
		frame = new JFrame();
		frame.setUndecorated(true);
		
		
		image = new ImageIcon("workspace-with-glasses-notebook.jpg");
		
		design = new JLabel(image);
		design.setBounds(0,-200,image.getIconHeight(),image.getIconWidth());
		
		layer = new JLayeredPane();
		layer.setBounds(-200, -250, image.getIconHeight(), image.getIconWidth());
		layer.setLayout(null);
		layer.add(design, Integer.valueOf(0));
		layer.add(nameLabel, Integer.valueOf(1));
		layer.add(lastnameLabel, Integer.valueOf(1));
		layer.add(idLabel, Integer.valueOf(1));
		layer.add(genderLabel,Integer.valueOf(1));
		layer.add(ageLabel, Integer.valueOf(1));
		layer.add(SubjectLabel, Integer.valueOf(1));
		layer.add(SectionLabel, Integer.valueOf(1));
		layer.add(name, Integer.valueOf(1));
		layer.add(lastname, Integer.valueOf(1));
		layer.add(id, Integer.valueOf(1));
		layer.add(dateChooser, Integer.valueOf(1));
		layer.add(subjectDropdown, Integer.valueOf(1));
		layer.add(sections, Integer.valueOf(1));
		layer.add(gender1, Integer.valueOf(1));
		layer.add(gender2, Integer.valueOf(1));
		layer.add(submit, Integer.valueOf(1));
		layer.add(back, Integer.valueOf(1));
		
		
		
		
		
		layer.add(close, Integer.valueOf(1));
		
		
		
		
		frame.setTitle("Registration Form");
		frame.setFont(new Font("Verdana", Font.BOLD, 25));
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
		frame.add(layer);
	
	}
	
	public void setBounds() {
		registration.setBounds(65,-25,270,100);
		nameLabel.setBounds(140,95,150,40);
		lastnameLabel.setBounds(140,145,150,40);
		idLabel.setBounds(140,195,90,40);
		genderLabel.setBounds(140,245,90,40);
		ageLabel.setBounds(140,295,90,40);
		SubjectLabel.setBounds(140,345,150,40);
		SectionLabel.setBounds(140,395,90,40);
		name.setBounds(290,100,170,30);
		lastname.setBounds(290,150,170,30);
		id.setBounds(290,200,170,30);
		gender1.setBounds(290,250,80,30);
		gender2.setBounds(370,250,90,30);
		dateChooser.setBounds(290,300,170,30);
		close.setBounds(420, 0, 150, 50);
		panel.setBounds(0,0,400,50);
		submit.setBounds(230,470,150,50);
		
		
		
	}
	
	public void setFont() {
		registration.setFont(new Font("Verdana", Font.BOLD,18));
		registration.setForeground(Color.decode("#D4E2D4"));
		nameLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lastnameLabel.setFont(new Font("Arial", Font.BOLD, 25));
		idLabel.setFont(new Font("Arial", Font.BOLD, 25));
		genderLabel.setFont(new Font("Arial", Font.BOLD, 25));
		ageLabel.setFont(new Font("Arial", Font.BOLD, 25));
		SubjectLabel.setFont(new Font("Arial", Font.BOLD, 25));
		SectionLabel.setFont(new Font("Arial", Font.BOLD, 25));
		name.setFont(new Font("Verdana", Font.PLAIN, 15));
		lastname.setFont(new Font("Verdana", Font.PLAIN, 15));
		id.setFont(new Font("Verdana", Font.PLAIN, 15));
		gender1.setFont(new Font("Verdana", Font.BOLD, 15));
		gender2.setFont(new Font("Verdana", Font.BOLD, 15));
		age.setFont(new Font("Verdana", Font.PLAIN, 15));
		dateChooser.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		submit.setFont(new Font("Verdana", Font.BOLD, 20));
	}
	
	public void setColor() {
		nameLabel.setForeground(Color.white);
		lastnameLabel.setForeground(Color.white);
		idLabel.setForeground(Color.white);
		genderLabel.setForeground(Color.white);
		ageLabel.setForeground(Color.white);
		SubjectLabel.setForeground(Color.white);
		SectionLabel.setForeground(Color.white);
		
		// Font Color TextField
		
		name.setForeground(Color.BLACK);
		lastname.setForeground(Color.BLACK);
		id.setForeground(Color.GRAY);
		
		
	}
	
	
	public void setBorder() {
		name.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		lastname.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		id.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		age.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
	}
	
	public void addKeyListener() {
		name.addKeyListener(this);
		lastname.addKeyListener(this);
	}
	
	public void setHolder() {

		sec = "UI-FC2-BSIT2-1"; 
		sec2 = "UI-FC2-BSIT2-2";
		
		holder = "ex. 04-2223-036502";
		id.setText(holder);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Male = gender1.getText();
		Female = gender2.getText();
		
		Fname = name.getText();
		Lname = lastname.getText();
		ID = id.getText();
		section = sections.getSelectedItem();
		Section = section.toString();
		subject = subjectDropdown.getSelectedItem();
		sub = subject.toString();
		
		
		
		 if (dateChooser != null) {
	            // Get selected date
	            selectedDate = dateChooser.getDate();
	            if (selectedDate != null) {
	                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                formattedDate = dateFormat.format(selectedDate);
	            } else {
	            }
	        }
	        
		 
		
		if(e.getSource() == gender1) {
			genderValue = Male;
		}
		if(e.getSource() == gender2) {
			genderValue = Female;
		}
		
		if(e.getSource() == submit) {
			
			if (Section.equals(sec)) {
				ConSql.Sec2_2_1();
				frame.dispose();
				new Form();
			}else if(Section.equals(sec2)) {
				ConSql.Sec2_2_2();
				
			}else {
				JOptionPane.showMessageDialog(null, "Please Fill up all the needed Information!", "Registration Form", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource() == back) {
			new HomePage();
			frame.dispose();
		}
		
		if (e.getSource() == sections) {
			sections.removeItem("Select Section");
		}
		
		if(e.getSource() == subjectDropdown) {
			subjectDropdown.removeItem("Select Subject");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Fname = name.getText();
		Lname = lastname.getText();
		
		name.setText(Fname.toUpperCase());
		lastname.setText(Lname.toUpperCase());
		
		
	}

}
