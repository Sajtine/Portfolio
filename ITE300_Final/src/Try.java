import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Try implements ActionListener{
	
	Try(){
		comboBox();
	}
	JComboBox<String> dropdown = new JComboBox<>();
	
	public void comboBox() {
		   // Create a new JFrame
        JFrame frame = new JFrame("Dropdown Example");

        // Create a new JComboBox

        // Add items to the dropdown
        dropdown.addItem("Please Select");
        dropdown.addItem("Item 1");
        dropdown.addItem("Item 2");
        dropdown.addItem("Item 3");
        dropdown.addItem("Item 4");
        
        //dropdown.setSize(50,50);

        // Set the initial selected item
        Object item = dropdown.getSelectedItem();
        String items = item.toString();
        dropdown.setBounds(100, 50, 150, 30);
        dropdown.setFont(new Font("Verdana", Font.PLAIN, 12));
        dropdown.setBackground(Color.white);
        dropdown.addActionListener(this);
        
        //System.out.println(items);
        // Add the dropdown to the frame
        frame.add(dropdown);
        frame.setLayout(null);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Set the close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to be visible
        frame.setVisible(true);
	}
	
    public static void main(String[] args) {
    	new Try();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == dropdown) {
			dropdown.removeItem("Please Select");
		}
	}
}
