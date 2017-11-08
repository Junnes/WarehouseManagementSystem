package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.wms.bean.User;
import net.wms.dao.LoginUseImp;
/**
 * 		��½����
 *	1��������½���棬��ʼ������Ķ���
 *	2��������½���棬���ø�������Ĵ�С��λ�á������Լ�����ı���
 *	3������ť���ü����¼�
 *
 */

public class Login {
	    //��ʼ������
		Font d = new Font("����", Font.BOLD, 22);
		Font f = new Font("����", Font.BOLD, 15);
		// ��ʼ������
		JFrame logingui = new JFrame("�û���¼����");
		JLabel userlogin = new JLabel("�û���¼");
		JLabel username = new JLabel("�û�����");
		JLabel password = new JLabel("�� �룺");
		JLabel usertyle = new JLabel("�û�����");
		JTextField name = new JTextField();
		JTextField pwd = new JPasswordField();
		JComboBox box = new JComboBox(new String[]{"����Ա","��ͨ�û�"} );
		JButton login = new JButton("��½");
		//��User���ʼ������user
		User user = new User();
	public void LoginGui() {
		// ���ö���
		logingui.setBounds(450, 200, 400, 300);
		//�����˳�
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ȡ����ܸ�ʽ
		logingui.setLayout(null);
		//����λ�á���С������
		userlogin.setBounds(140, 30, 150, 30);
		userlogin.setFont(d);
		username.setBounds(50, 80, 100, 30);
		username.setFont(f);
		password.setBounds(50, 120, 100, 30);
		password.setFont(f);
		usertyle.setBounds(70, 160, 100, 30);
		usertyle.setFont(f);
		name.setBounds(140, 80, 180, 30);
		name.setFont(f);
		pwd.setBounds(140, 120, 180, 30);
		box.setBounds(170, 160, 100, 30);
		box.setFont(f);
		login.setBounds(150, 200, 80, 30);
		login.setFont(f);
		// ��Ӷ���
		logingui.add(userlogin);
		logingui.add(username);
		logingui.add(password);
		logingui.add(usertyle);
		logingui.add(name);
		logingui.add(pwd);
		logingui.add(box);
		logingui.add(login);
		// ������ӻ�
		logingui.setVisible(true);
		//���õ�¼ͼ�ν���ı���ͼƬ
		((JComponent) logingui.getContentPane()).setOpaque(false); //�����ǿתΪ����          
        ImageIcon img = new ImageIcon("Images//��¼����.jpg"); //���뱳��ͼƬ·��
		JLabel background = new JLabel(img);//��ͼƬ�Ž���ǩ��
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));//����ǩ�Ž�������
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());//���ñ�ǩ�Ĵ�С
		//������������ѡ������¼�
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�ж�ѡ��ѡ���Ƿ������������һ��
				if(box.getSelectedItem().equals("����Ա")){
					//���ñ�־����ֵ
					user.setFlag("2");
				}else{
					user.setFlag("1");
				}
			}
		});
		//����¼��ť���ü����¼�
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					//��ȡ�ı�������û���������
					String name_text = name.getText();
					String pwd_text = pwd.getText();
					//���õ���ֵ����user��������
					user.setusername(name_text);
					user.setuserpwd(pwd_text);
					//����½�ӿ�ʵ�����ʼ������
					LoginUseImp l = new LoginUseImp();
					//��ȡ��־��
					String state = user.getFlag();
					//�жϱ�־���������ı����Ĭ��ֵΪ����Ա
					if(state != "1" && state != "2") {
						state = "2";
					}
					//�ж��ı���ֵ�ǲ��ǹ���Ա
					if(state == "2") {
						try {
							//ִ��sql��䣬�������ݿ����
							boolean flag = l.Query(user, "select * from users where username=? and userpwd=? and flag="+state);
							if(flag) {
								//�ı���ʾ��
								JOptionPane.showMessageDialog(null, "��½�ɹ�");
								//����ת��������ԭ������
								logingui.setVisible(false);
								//�����µĽ���
								new IndexAdmin(name_text);
							} else {
								//�ı���ʾ��
								JOptionPane.showMessageDialog(null, "��½ʧ�ܣ������û���������");
								//�����û������������ֵΪ��
								name.setText("");
								pwd.setText("");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
				//�ж��ǲ�����ͨ�û�
				} else if(state == "1") {
					try {
						//ִ��sql���
						boolean flag = l.Query(user, "select * from users where username=? and userpwd=? and flag="+state);
						if(flag) {
							JOptionPane.showMessageDialog(null, "��½�ɹ�");
							logingui.setVisible(false);	
							new Index(name_text);
						} else {
							JOptionPane.showMessageDialog(null, "��½ʧ�ܣ������û���������");
							name.setText("");
							pwd.setText("");
						}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
	}
	//��������ִ�е����
	public static void main(String[] args) {
		Login l = new Login();
		l.LoginGui();
	}
}
