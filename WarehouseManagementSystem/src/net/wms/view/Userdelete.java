package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.wms.bean.User;
import net.wms.dao.LoginUseImp;

public class Userdelete extends IndexAdmin {
	//�������ֶ���
	JLabel name;
	JLabel pwd;
	JLabel style;
	JTextField dname;
	//ΪUser���ʼ������
	User user = new User();
	
	//���캯��
	public Userdelete(String name) {
		super(name);
		init();
	}
	
	public void init() {
		//��ʼ������
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		//��ʼ������
		JLabel userdelete = new JLabel("�û�ɾ��");
		JLabel deletename = new JLabel("�����û�����");
		dname = new JTextField();
		JLabel usertitle = new JLabel("ɾ�����û���Ϣ");
		JLabel username = new JLabel("�û�����");
		name = new JLabel();
		JLabel userpwd = new JLabel("��  �룺");
		pwd = new JLabel();
		JLabel userstyle = new JLabel("��  �ͣ�");
		style = new JLabel();
		JButton submit = new JButton("ȷ��");
		JButton delete = new JButton("ɾ��");
		//���ö���
		userdelete.setBounds(130, 30, 100, 40);
		userdelete.setFont(d);
		deletename.setBounds(20, 90, 120, 30);
		deletename.setFont(f);
		dname.setBounds(130, 90, 150, 30);
		dname.setFont(f);
		usertitle.setBounds(100, 140, 200, 40);
		usertitle.setFont(d);
		username.setBounds(60, 200, 80, 30);
		username.setFont(f);
		name.setBounds(140, 200, 150, 30);
		name.setFont(f);
		userpwd.setBounds(60, 260, 80, 30);
		userpwd.setFont(f);
		pwd.setBounds(140, 260, 150, 30);
		pwd.setFont(f);
		userstyle.setBounds(60, 320, 80, 30);
		userstyle.setFont(f);
		style.setBounds(140, 320, 150, 30);
		style.setFont(f);
		submit.setBounds(290, 90, 80, 30);
		submit.setFont(f);
		delete.setBounds(150, 380, 80, 30);
		delete.setFont(f);
		//��Ӷ���
		index.add(userdelete);
		index.add(deletename);
		index.add(dname);
		index.add(submit);
		index.add(usertitle);
		index.add(username);
		index.add(name);
		index.add(userpwd);
		index.add(pwd);
		index.add(style);
		index.add(userstyle);
		index.add(delete);
		
		//Ϊȷ����ť��Ӽ����¼�
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ı�����ȡ���û������ý�user������
				user.setusername(dname.getText());
				LoginUseImp l = new LoginUseImp();
				boolean b;
				try {
					//ִ��sql���
					b = l.Query1(user, "select * from users where username= '"+dname.getText()+"'");
					if(b){
						//�����ݿ��е�ֵ���ý��ı���
						name.setText(user.getusername());
						pwd.setText(user.getuserpwd());
						style.setText(user.getFlag());
					} else {
						//δ���ҵ���ʾ��
						JOptionPane.showMessageDialog(null,"δ�鵽���û�");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//Ϊɾ����ť��Ӽ����¼�
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ѡ�е�������ӽ��ı���
				user.setusername(dname.getText());
				LoginUseImp l = new LoginUseImp();
				try {
					//ִ��ɾ����sql���
					l.Delete(user, "delete from users where username='"+dname.getText()+"'");
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
	}
}