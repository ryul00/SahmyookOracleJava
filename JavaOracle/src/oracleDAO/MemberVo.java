package oracleDAO;

public class MemberVo {
//	private String empno;
//	private String ename;
//	private int sal;
	
	private String id;
	private String pwd;
	
	public MemberVo() {
		
	}
	
	public MemberVo(String id, String pwd) {
//		this.empno = empno;
//		this.ename = ename;
//		this.sal = sal;
		this.id = id;
		this.pwd = pwd;
		
	}
	
//	public String getEmpno(){
//		return empno;
//	}
//	
//	public String getEname(){
//		return ename;
//	}
//	
//	public int getSal(){
//		return sal;
//	}
	
	public String getId(){
		return id;
	}
	
	public String getPwd(){
		return pwd;
	}
	


}
