import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// 

public class OracleInsert2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@BOOK-6I2Q8VAVHO:1521/orcl";
		String user = "c##sahmyook";
		String password = "yukr1009";
		
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();
			
			String sq1 = "SELECT Max(deptno) FROM dept";
			ResultSet rs1 = stmt.executeQuery(sq1);
			
			rs1.next();
			int ideptno = rs1.getInt("Max(deptno)");
			System.out.println(ideptno);
			
			
			
			String sdname = "IT",sloc = "SEOUL"; 
			String sql2 ="INSERT INTO dept VALUES('" + (ideptno+10) + "','" + sdname + "','" + sloc + "')";
			System.out.println(sql2);
			boolean b = stmt.execute(sql2); 
			if(!b) {
				System.out.println("Insert success.\n"); 
			}else {
				System.out.println("Insert fail.\n"); 
			}
			
			
			// 3. select --------------------------------------
			String sql3 = "SELECT deptno, dname, loc FROM dept ORDER BY deptno";
			ResultSet rs2 = stmt.executeQuery(sql3);
			while (rs2.next()) {
				System.out.print(rs2.getString("deptno") + "\t");
				System.out.print(rs2.getString("dname") + "\t");
				System.out.println(rs2.getString("loc"));
			}
			 				
			
			
			
			
			
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		

	}

}
