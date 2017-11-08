package net.wms.view;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.wms.dao.StoragemanagementImp;

public class Storageselect extends Index{

	int id;
	private JTable table;
	
	public Storageselect(String name) {
		super(name);
		init();
	}
	@SuppressWarnings("unchecked")
	public void init() {
		Font t = new Font("����",Font.BOLD, 24);
		final Font f = new Font("����",Font.BOLD, 15);
		JLabel title = new JLabel("�ֿ���Ϣ");
		title.setFont(t);
		title.setBounds(130, 40, 100, 40);
		Vector v = new Vector();
		v.add("���");
		v.add("�ֿ�����");
		v.add("�ֿ�����");
		v.add("�ֿ���");
		StoragemanagementImp s = new StoragemanagementImp();
		table = new JTable(s.vec,v);
		table.setFont(f);
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(40, 120, 300, 200);
		try {
			s.Query("select * from storage");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		index.add(title);
		index.add(jp);
	}
}
