package oracleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "c##sahmyook";
	String password = "yukr1009";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo>list(String name){
		ArrayList<MemberVo>list = new ArrayList<MemberVo>();
		
		try {
			connDB();
			
			String query = "SELECT * FROM account";
			if(name != null) {
				query += " where id='" + name + "'";
			}
			System.out.println("SQL : " + query);
			
			
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if(rs.getRow() == 0) {
				System.out.println("해당 아이디가 존재하지 않습니다.");
			}else {
				System.out.println(rs.getRow() + "해당 아이디가 선택되었습니다.");
				rs.previous();
				while(rs.next()) {
					String id = rs.getString("id");
					String pwd = rs.getString("pwd");
					
					MemberVo data = new MemberVo(id, pwd);
					list.add(data);
					
				}	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success");
			
			// 입력값에 대한 데이터 조회를 위해 포인터 이동에 필요한 옵션
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
