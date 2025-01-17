import java.sql.*;


public class OracleInsert {

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
			
			
			
			String ideptno = "52", sdname = "IT", sloc = "SEOUL";
			String sq0 = "SELECT COUNT(deptno) FROM dept WHERE deptno = '" + ideptno + "'";
			ResultSet crs = stmt.executeQuery(sq0);
			crs.next();
			int count = crs.getInt(1); // 쿼리문 결과(crs)의 첫번째 값을 int형태로 가져옴 -> 여기서는 deptno가 동일한 개체 수를 의미 
			if(count > 0) {
				System.out.println("중복된 deptno입니다.");
			}else {
				String sql = "INSERT INTO dept VALUES('" + ideptno + "','" + sdname + "','" + sloc + "')"; 
				boolean b = stmt.execute(sql);
				if(!b) {
					System.out.println("Insert success.\n");
				}else {
					System.out.println("Insert fail.\n");
				}
				
			}
			
			
			String sql2 = "SELECT deptno, dname, loc FROM dept";
			ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("loc") + " ");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		

	}

}
