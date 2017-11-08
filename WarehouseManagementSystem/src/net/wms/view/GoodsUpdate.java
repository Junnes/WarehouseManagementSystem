package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.wms.bean.Goods;
import net.wms.dao.GoodsmanagementImp;
import net.wms.dao.StoragemanagementImp;

public class GoodsUpdate extends IndexAdmin{
	int id ;
	//�������
	private JTable table;
	JTextField name;
	JTextField style;
	JTextField number;
	JComboBox s_id;
	
	public GoodsUpdate(String name) {
		super(name);
		init();
	}
	public void init() {
		Font t = new Font("����",Font.BOLD, 24);
		final Font f = new Font("����",Font.BOLD, 15);
		JLabel title = new JLabel("��Ʒ��Ϣ");
		JLabel goodsname = new JLabel("��Ʒ���ƣ�");
		goodsname.setBounds(60, 180, 80, 30);
		name = new JTextField();
		name.setBounds(140, 180, 150, 30);
		JLabel goodsstyle = new JLabel("��Ʒ���ͣ�");
		goodsstyle.setBounds(60, 230, 80, 30);
		style = new JTextField();
		style.setBounds(140, 230, 150, 30);
		JLabel goodsnumber = new JLabel("��Ʒ������");
		goodsnumber.setBounds(60, 280, 80, 30);
		number = new JTextField();
		number.setBounds(140, 280, 150, 30);
		JLabel storageid = new JLabel("�ֿ��ţ�");
		storageid.setBounds(60, 330, 80, 30);
		StoragemanagementImp s = new StoragemanagementImp();
		try {
			s.Query1("select storageID from storage");
			s_id = new JComboBox(StoragemanagementImp.vr);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		s_id.setBounds(140, 330, 150, 30);
		title.setFont(t);
		title.setBounds(130, 10, 100, 30);
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
				//��ȡÿ����¼����Ӧ��id
				id = (int)table.getValueAt(table.getSelectedRow(), 0);
				//��ȡ��������
				String gname = (String)table.getValueAt(table.getSelectedRow(), 1);
				//��ȡ���ű��
				String gstyle = (String)table.getValueAt(table.getSelectedRow(), 2);
				//��ȡ��������
				String gnumber=table.getValueAt(table.getSelectedRow(), 3).toString();
				//���������ý��ı���
				name.setText(gname);
				style.setText(gstyle);
				number.setText(gnumber);
				super.mouseClicked(e);
			}
		});
		//����Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(40, 60, 300, 100);
		//����ɾ����ť
		final JButton update = new JButton("�޸�");
		//Ϊ��ť���������¼�
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�ж�Id�Ƿ����б���
				if(id == 0){
					JOptionPane.showMessageDialog(null, "�޸�ʧ����ѡ����Ҫ�޸ĵļ�¼��");
				}else{
				try {
					//������ʾ
					//4��������1.null 2.��ʾ���� 3.���� 4.��ť����
					int mess = JOptionPane.showConfirmDialog(
							null,"ȷ���޸ļ�¼��","������ʾ��",
							JOptionPane.YES_NO_OPTION );
					//���ȷ����ť֮����¼�
					//0 == ȷ�� ��1 == ȡ��
					if(mess == 0){
						//����ɾ������
						Goods goods = new Goods();
						goods.setGoodsname(name.getText());
						goods.setGoodsstyle(style.getText());
						goods.setGoodsnumber(Integer.parseInt(number.getText()));
						goods.setStorageID(s_id.getSelectedItem().toString());
						g.Update(goods,"update goods set goodsname = ?,goodsstyle=?,goodsnumber=?,storageID=? where id = "+ id);
						//��ʾɾ���ɹ�
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						name.setText("");
						style.setText("");
						number.setText("");
						g.Query("select * from goods");
						//ԭ���Ƴ�ԭ�������������
						//�������
						JTable new_table = new JTable(g.vec,c);
						new_table.setFont(f);
						//����Jscrollpane
						JScrollPane p = new JScrollPane(new_table);
						//�������齨�Ĵ�С
						p.setBounds(40, 60, 300, 100);
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
		update.setBounds(150, 380, 80,30);
		index.add(title);
		index.add(goodsname);
		index.add(name);
		index.add(goodsstyle);
		index.add(style);
		index.add(goodsnumber);
		index.add(number);
		index.add(storageid);
		index.add(s_id);
		index.add(js);
		index.add(update);
	}
}
