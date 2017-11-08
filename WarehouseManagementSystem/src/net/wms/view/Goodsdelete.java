package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.wms.dao.GoodsmanagementImp;

public class Goodsdelete extends IndexAdmin{
	int id ;
	//�������
	private JTable table;
	
	public Goodsdelete(String name) {
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
		try {
			g.Query("select * from goods");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//�������
		table = new JTable(g.vec,c);
		table.setFont(f);
		//Ϊ��������굥���¼�
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��ȡ����е�ID
				id = (int) table.getValueAt(
				table.getSelectedRow(), 0);
				System.out.println(id);
				super.mouseClicked(e);
			}
		});
		//����Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(40, 120, 300, 200);
		//����ɾ����ť
		final JButton delete = new JButton("ɾ��");
		//Ϊ��ť���������¼�
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�ж�Id�Ƿ����б���
				if(id == 0){
					JOptionPane.showMessageDialog(null, "ɾ��ʧ����ѡ����Ҫɾ���ļ�¼��");
				}else{
				try {
					//������ʾ
					//4��������1.null 2.��ʾ���� 3.���� 4.��ť����
					int mess = JOptionPane.showConfirmDialog(
							null,"ȷ��ɾ����¼��","������ʾ��",
							JOptionPane.YES_NO_OPTION );
					//���ȷ����ť֮����¼�
					//0 == ȷ�� ��1 == ȡ��
					if(mess == 0){
						//����ɾ������
						g.Delete("delete from goods where id ="+id);
						//��ʾɾ���ɹ�
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						g.Query("select * from goods");
						//�������
						JTable new_table = new JTable(g.vec,c);
						new_table.setFont(f);
						//����Jscrollpane
						JScrollPane p = new JScrollPane(new_table);
						//�������齨�Ĵ�С
						p.setBounds(40, 120, 300, 200);
						//�Ƴ������
						index.remove(js);
						//��������
						index.add(p);
						//�ػ����
						index.repaint();
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}
			}
		});
		//����λ�ü���С
		delete.setBounds(150, 350, 80,30);
		index.add(title);
		index.add(js);
		//��Ӱ�ť
		index.add(delete);
	}
}
