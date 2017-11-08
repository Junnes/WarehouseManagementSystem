package net.wms.view;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.wms.dao.GoodsmanagementImp;

public class GoodsSelect extends Index{
	
	private JTable table;
	int id ;
	
	public GoodsSelect(String name) {
		super(name);
		init();
	}
	public void init() {
		Font t = new Font("����",Font.BOLD, 24);
		final Font f = new Font("����",Font.BOLD, 15);
		JLabel title = new JLabel("��Ʒ��Ϣ");
		title.setFont(t);
		title.setBounds(130, 40, 100, 40);
		final Vector c = new Vector();
		//�������
		c.add("���");
		c.add("��Ʒ����");
		c.add("��Ʒ����");
		c.add("��Ʒ����");
		c.add("�ֿ���");
		final GoodsmanagementImp g = new GoodsmanagementImp();
		//�������
		table = new JTable(g.vec,c);
		table.setFont(f);
		//����Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(40, 120, 300, 200);
		try {
			g.Query("select * from goods");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		index.add(title);
		index.add(js);
	}
}
