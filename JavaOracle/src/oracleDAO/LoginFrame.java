package oracleDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginFrame extends WindowAdapter implements ActionListener {
	private Frame f;
	private Label lid, lpwd;
	private TextField tfid, tfpwd, tfmsg;
	private Button btn;
	
	public LoginFrame() {
		f = new Frame("Login");
		f.setSize(400, 180);
		f.setLayout(null);
		f.addWindowListener(this);
		
		
		lid = new Label("ID : ", Label.RIGHT);
		lid.setBounds(10,50,100,20);
		
		lpwd = new Label("PW : ", Label.RIGHT);
		lpwd.setBounds(10,80,100,20);
		
		tfid = new TextField(10);
		tfid.setBounds(120,50,150,20);
		
		tfpwd = new TextField(10);
		tfpwd.setEchoChar('*');
		tfpwd.setBounds(120,80,150,20);
		
		tfmsg = new TextField(10);
		tfmsg.setBounds(40,110,300,20);
		
		btn = new Button("Login");
		btn.setBounds(290,50,50,50);
		btn.addActionListener(this);
	
		
		f.add(lid);
		f.add(lpwd);
		f.add(tfid);
		f.add(tfpwd);
		f.add(tfmsg);
		f.add(btn);
		f.setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		new LoginFrame();

		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Login")) {
			String sid = tfid.getText();
			String spwd = tfpwd.getText();
			MemberDAO dao = new MemberDAO();
			MemberVo vo = new MemberVo();
			
			if(sid.isEmpty()) {
				tfmsg.setText("아이디와 패스워드를 입력해주세요.");
			}
			else {
				ArrayList<MemberVo> list = dao.list(sid); 
				
				
				if(list.size() != 0) {
					MemberVo data = (MemberVo) list.get(0);
					String dbid = data.getId();
					String dbpwd = data.getPwd();
					
					if(sid.equals(dbid) && spwd.equals(dbpwd)) {
						tfmsg.setText("로그인 성공");
					}else {
						tfmsg.setText("아디이 혹은 패스워드가 다릅니다.");
					}
					
				}
		
			}
			
			
		}
	
		
	}

}
