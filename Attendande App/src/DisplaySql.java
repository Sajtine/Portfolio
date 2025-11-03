import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DisplaySql extends Display{
	
	
	
	public static void display(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance","root","");
			Statement stmt = con.createStatement();
			String sql = "SELECT last_name, first_name, Section, subject, date FROM fc2_bsit2_1 WHERE Section = '" + selectedSection + "' AND subject = '"
			+ selectedSub + "' AND date = '" + date + "' ORDER BY last_name ASC";
			ResultSet rs = stmt.executeQuery(sql);
			//ResultSetMetaData rsmd = rs.getMetaData();
			
			String Lname,Fname,sub,date;
			
			while(rs.next()) {
				Lname = rs.getString(1);
				Fname = rs.getString(2);
				//sec = rs.getString(3);
				sub = rs.getString(4);
				date = rs.getString(5);
				String[] row = {Lname,Fname,sub,date};
				tableModel.addRow(row);
			}
			stmt.close();
			con.close();
			
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}

}
