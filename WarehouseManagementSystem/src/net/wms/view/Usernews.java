package net.wms.view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JLabel;

import net.wms.bean.User;
import net.wms.dao.LoginUseImp;

public class Usernews extends Index{
	//��������
	JLabel uname;
	JLabel pwd;
	JLabel style;
	//ΪUser���ʼ��user����
	User user = new User();
	
	//���캯��
	public Usernews(String name) {
		super(name);
		init();
		//���û������ý�user����
		user.setusername(name);
		LoginUseImp l = new LoginUseImp();
		try {
			//ִ�а��������ҵ����������
			l.Query1(user, "select * from users where username= '"+name+"'");
			uname.setText(user.getusername());
			pwd.setText(user.getuserpwd());
			//ͨ����־���ж���ͨ�û��͹���Ա
			if(user.getFlag().equals("1")) {
				style.setText("��ͨ�û�");
			} else {
				style.setText("����Ա");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void init() {
		//��ʼ������
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		//��ʼ������
		JLabel usertitle = new JLabel("������Ϣ");
		JLabel username = new JLabel("�û�����");
		uname = new JLabel();
		JLabel userpwd = new JLabel("��  �룺");
		pwd = new JLabel();
		JLabel userstyle = new JLabel("��  �ͣ�");
		style = new JLabel();
		//���ö����С��λ�ú�����
		usertitle.setBounds(130, 60, 200, 40);
		usertitle.setFont(d);
		username.setBounds(60, 130, 80, 30);
		username.setFont(f);
		uname.setBounds(140, 130, 150, 30);
		uname.setFont(f);
		userpwd.setBounds(60, 190, 80, 30);
		userpwd.setFont(f);
		pwd.setBounds(140, 190, 150, 30);
		pwd.setFont(f);
		userstyle.setBounds(60, 250, 80, 30);
		userstyle.setFont(f);
		style.setBounds(140, 250, 150, 30);
		style.setFont(f);
		//��������ӽ����
		index.add(usertitle);
		index.add(username);
		index.add(uname);
		index.add(userpwd);
		index.add(pwd);
		index.add(style);
		index.add(userstyle);
	}
}
