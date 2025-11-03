import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ConSql extends Form{
	
	static Font font;
	
	public static void Sec2_2_1(){
		
		font = new Font("Verdana", Font.PLAIN, 15);
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance","root","");
		Statement stmt = con.createStatement();
		String sql2 = "SELECT * FROM fc2_bsit2_1 WHERE id_number = '" + ID + "'";
		int rs;
		ResultSet rs2 = stmt.executeQuery(sql2);
		
		
		if(rs2.next()) {
			JOptionPane.showMessageDialog(null, "Data duplicated!", "Registration Form", JOptionPane.INFORMATION_MESSAGE);
			
		}else if (Fname.isEmpty() ) {
			
			// Set Font
			UIManager.put("OptionPane.messageFont", font);
			JOptionPane.showMessageDialog(null, "Please check and fill up all the needed information. Thank you!", "Registration Form", JOptionPane.INFORMATION_MESSAGE);
			
		}else {
		
							
			rs = stmt.executeUpdate("insert into fc2_bsit2_1 values('" + Fname +"', '" + Lname + "', '"  + ID + "', '" + genderValue +"', '"
			+ formattedDate +"', '" + Section + "', '" + sub + "')");
			JOptionPane.showMessageDialog(null, "Your form has been submitted successfully!", "Registration Form", JOptionPane.INFORMATION_MESSAGE);
		}
		
	
	}catch(Exception e1) {
		System.out.print(e1);
	
	}
	}
	
	public static void Sec2_2_2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance","root","");
			Statement stmt = con.createStatement();
			String sql2 = "SELECT * FROM fc2_bsit2_2 WHERE id_number = '" + ID + "'";
			int rs;
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			
			if(rs2.next()) {
				JOptionPane.showMessageDialog(null, "Data duplicated!", "Registration Form", JOptionPane.INFORMATION_MESSAGE);
				
			}else if (Fname.isEmpty() ) {
				
				JOptionPane.showMessageDialog(null, "Your form was not been submitted successfully!", "Registration Form", JOptionPane.INFORMATION_MESSAGE);
				
			}else {
			
								
				rs = stmt.executeUpdate("insert into fc2_bsit2_2 values('" + Fname +"', '" + Lname + "', '"  + ID + "', '" + genderValue +"', '"
				+ formattedDate +"', '" + Section + "', '" + sub + "')");
				
				
				JOptionPane.showMessageDialog(null, "Your form has been submitted successfully!", "Registration Form", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		
		}catch(Exception e1) {
			System.out.print(e1);
		
		}
			
	}
}
