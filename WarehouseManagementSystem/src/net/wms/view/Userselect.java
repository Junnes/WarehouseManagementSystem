package net.wms.view;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.wms.dao.LoginUseImp;

public class Userselect extends IndexAdmin{
	//��������
	int id;
	private JTable table;
	
	//���캯��
	public Userselect(String name) {
		super(name);
		init();
	}
	
	public void init() {
		//��ʼ������
		Font t = new Font("����",Font.BOLD, 24);
		final Font f = new Font("����",Font.BOLD, 15);
		//��ʼ������
		JLabel title = new JLabel("�û���Ϣ");
		title.setFont(t);
		title.setBounds(130, 40, 100, 40);
		//��ʼ��Vector����
		Vector v = new Vector();
		//Ϊ��������ֶ�
		v.add("���");
		v.add("�û���");
		v.add("�û�����");
		LoginUseImp l = new LoginUseImp();
		//��ʼ�����
		table = new JTable(l.vec,v);
		table.setFont(f);
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(40, 120, 300, 200);
		try {
			l.Select("select * from users");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		index.add(title);
		index.add(jp);
	}
}
