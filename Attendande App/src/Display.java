
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Display implements ActionListener{
	
	JFrame frame;
	ImageIcon image;
	JLabel backGround, subjectLabel,sectionLabel, dateLabel;
	JButton exit, display, clear;
	JLayeredPane layer;
	JComboBox<String> subject, section;
	Font font;
	JDateChooser dateChooser;
	SimpleDateFormat dateFormat;
	static DefaultTableModel tableModel;
	JTable table;
	Object[][] data;
	JScrollPane scrollPane;
	static Object selectedSection, selectedSub;
	Date selectedDate;
	static String date;
	
	Display(){
		frame();
	}
	
	public void frame() {
		frame = new JFrame();
		frame.setUndecorated(true);
		
		String[] subs = {"Select Subject", "ITE 300", "ITE 292", "ITE 083", "ITE 031", "ITE 298"};
		subject = new JComboBox<String>(subs);
		subject.setFocusable(false);
		subject.setBounds(100,270,130,35);
		subject.setFont(new Font("Verdana", Font.BOLD, 13));
		subject.setSelectedItem("Select Subject");
		
		String[] secs = {"Select Section","UI-FC2-BSIT2-1","UI-FC2-BSIT2-2","UI-FC2-BSIT2-3"};
		section = new JComboBox<String>(secs);
		section.setFocusable(false);
		section.setFont(new Font("Verdana", Font.BOLD, 11));
		section.setBounds(100,210,130,35);
		
		image = new ImageIcon("workspace-with-glasses-notebook.jpg");
		
		backGround = new JLabel(image);
		backGround.setBounds(0,-200,image.getIconHeight(),image.getIconWidth());
		
		font = new Font("Verdana", Font.PLAIN, 15);
		
		
		sectionLabel = new JLabel("Section");
		sectionLabel.setBounds(10,210,120,35);
		sectionLabel.setFont(new Font("Verdana", Font.BOLD, 19));
		sectionLabel.setForeground(Color.white);
		
		subjectLabel = new JLabel("Subject");
		subjectLabel.setFont(new Font("Verdana", Font.BOLD, 19));
		subjectLabel.setForeground(Color.white);
		subjectLabel.setBounds(10,270,120,30);
		
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Verdana", Font.BOLD, 19));
		dateLabel.setBounds(10,155,120,30);
		dateLabel.setForeground(Color.white);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBorder(new EmptyBorder(0,0,0,0));
		dateChooser.setBounds(100,150,130,35);
		
		String[] headers = {"Lastname","Firstname","Subject","Date"};
		tableModel = new DefaultTableModel(data,headers);
		
		table = new JTable(tableModel);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(250,100,390,480);
		
		exit = new JButton("Back");
		exit.setBounds(75,435,100,30);
		exit.setFocusable(false);
		exit.setFont(new Font("Verdana", Font.PLAIN, 15));
		exit.addActionListener(this);
		exit.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		display = new JButton("Display");
		display.setFont(new Font("Verdana", Font.PLAIN, 15));
		display.setBounds(75,350,100,30);
		display.setFocusable(false);
		display.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		display.addActionListener(this);
		
		clear = new JButton("Clear");
		clear.setFont(new Font("Verdana", Font.PLAIN, 15));
		clear.setBounds(75,395,100,30);
		clear.setFocusable(false);
		clear.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		clear.addActionListener(this);
				
		layer = new JLayeredPane();
		layer.setLayout(null);
		layer.setBounds(0,0,image.getIconHeight(),image.getIconWidth());
		layer.add(subject, Integer.valueOf(1));
		layer.add(section, Integer.valueOf(1));
		layer.add(backGround, Integer.valueOf(0));
		layer.add(exit, Integer.valueOf(1));
		layer.add(sectionLabel, Integer.valueOf(1));
		layer.add(dateChooser, Integer.valueOf(1));
		layer.add(subjectLabel, Integer.valueOf(1));
		layer.add(display, Integer.valueOf(1));
		layer.add(scrollPane, Integer.valueOf(1));
		layer.add(clear, Integer.valueOf(1));
		layer.add(dateLabel, Integer.valueOf(1));
		
		frame.setVisible(true);
		frame.setSize(660,600);
		frame.add(layer);
		frame.setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		new Display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		selectedSection = section.getSelectedItem();
		selectedSub = subject.getSelectedItem();
		
		 if (dateChooser != null) {
	            // Get selected date
	            selectedDate = dateChooser.getDate();
	            if (selectedDate != null) {
	                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                date = dateFormat.format(selectedDate);
	            } else {
	            }
	        }

		if(e.getSource() == exit) {
			new HomePage();
			frame.dispose();
		}
		
		if(e.getSource() == display) {
			DisplaySql.display();
		}
		
		if(e.getSource() == clear) {
			tableModel.setRowCount(0);
		}
	}
  
}
