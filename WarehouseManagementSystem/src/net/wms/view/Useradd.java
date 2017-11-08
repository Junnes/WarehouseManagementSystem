package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.wms.bean.User;
import net.wms.dao.LoginUseImp;

public class Useradd extends IndexAdmin{
	//�������ֶ���
	JTextField name;
	JTextField pwd;
	JTextField style;
	//ΪUser���ʼ������user
	User user = new User();
	
	//���캯��
	public Useradd(String name) {
		super(name);
		init();
	}
	
	
	public void init() {
		//��ʼ������
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		//��ʼ������
		JLabel usertitle = new JLabel("����û�");
		JLabel username = new JLabel("�û�����");
		name = new JTextField();
		JLabel userpwd = new JLabel("��  �룺");
		pwd = new JTextField();
		JLabel userstyle = new JLabel("��  �ͣ�");
		style = new JTextField();
		JButton submit = new JButton("�ύ");
		JButton reset = new JButton("����");
		//���ö����λ�á���С������
		usertitle.setBounds(130, 60, 100, 40);
		usertitle.setFont(d);
		username.setBounds(60, 140, 80, 30);
		username.setFont(f);
		name.setBounds(140, 140, 150, 30);
		name.setFont(f);
		userpwd.setBounds(60, 200, 80, 30);
		userpwd.setFont(f);
		pwd.setBounds(140, 200, 150, 30);
		pwd.setFont(f);
		userstyle.setBounds(60, 260, 80, 30);
		userstyle.setFont(f);
		style.setBounds(140, 260, 150, 30);
		style.setFont(f);
		submit.setBounds(90, 320, 80, 30);
		submit.setFont(f);
		reset.setBounds(200, 320, 80, 30);
		reset.setFont(f);
		//��������ӵ�������
		index.add(usertitle);
		index.add(username);
		index.add(name);
		index.add(userpwd);
		index.add(pwd);
		index.add(style);
		index.add(userstyle);
		index.add(submit);
		index.add(reset);
		
		//Ϊ���ð�ť���ü����¼�
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����û�����������û�����
				name.setText("");
				pwd.setText("");
				style.setText("");
			}
		});
		
		//δ�ύ��ť���ü����¼�
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�ж��ı����Ƿ�Ϊ��
				if(name.getText().equals("") || pwd.getText().equals("") || style.getText().equals("")) {
					//Ϊ�գ�������ʾ��
					JOptionPane.showMessageDialog(null,"����������");
				} else {
					//��Ϊ��
					//���ı�������ȡ���ݲ���ŵ�user������
					user.setusername(name.getText());
					user.setuserpwd(pwd.getText());
					user.setFlag(style.getText());
					//Ϊ��½�ӿ�ʵ�����ʼ������
					LoginUseImp l = new LoginUseImp();
					try {
						//ִ��sql���
						l.Add(user, "insert into users(username,userpwd,flag) values(?,?,?)");
						//����ı���
						name.setText("");
						pwd.setText("");
						style.setText("");
						//��ӳɹ���ʾ��
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
