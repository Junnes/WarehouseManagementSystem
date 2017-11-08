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
import javax.swing.JTextField;

import net.wms.bean.Goods;
import net.wms.bean.Storage;
import net.wms.dao.GoodsmanagementImp;
import net.wms.dao.StoragemanagementImp;

public class Storageupdate extends IndexAdmin{
	int id ;
	//�������
	private JTable table;
	JTextField name;
	JTextField style;
	JTextField s_id;
	
	public Storageupdate(String name) {
		super(name);
		init();
	}
	public void init() {
		Font t = new Font("����",Font.BOLD, 24);
		final Font f = new Font("����",Font.BOLD, 15);
		JLabel title = new JLabel("�ֿ���Ϣ");
		JLabel storagename = new JLabel("�ֿ����ƣ�");
		storagename.setBounds(60, 220, 80, 30);
		storagename.setFont(f);
		name = new JTextField();
		name.setBounds(140, 220, 150, 30);
		name.setFont(f);
		JLabel storagestyle = new JLabel("�ֿ����ͣ�");
		storagestyle.setBounds(60, 270, 80, 30);
		storagestyle.setFont(f);
		style = new JTextField();
		style.setBounds(140, 270, 150, 30);
		style.setFont(f);
		JLabel storageid = new JLabel("�ֿ��ţ�");
		storageid.setBounds(60, 320, 80, 30);
		storageid.setFont(f);
		s_id = new JTextField();
		s_id.setBounds(140, 320, 150, 30);
		s_id.setFont(f);
		title.setFont(t);
		title.setBounds(130, 30, 100, 30);
		final Vector c = new Vector();
		//�������
		c.add("���");
		c.add("�ֿ�����");
		c.add("�ֿ�����");
		c.add("�ֿ���");
		final StoragemanagementImp s = new StoragemanagementImp();
		try {
			s.Query("select * from storage");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//�������
		table = new JTable(s.vec,c);
		table.setFont(f);
		//Ϊ��������굥���¼�
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��ȡ����е�ID
				//��ȡÿ����¼����Ӧ��id
				id = (int)table.getValueAt(table.getSelectedRow(), 0);
				//��ȡ��������
				String sname = (String)table.getValueAt(table.getSelectedRow(), 1);
				//��ȡ���ű��
				String sstyle =(String)table.getValueAt(table.getSelectedRow(), 2);
				//��ȡ��������
				String sid=(String)table.getValueAt(table.getSelectedRow(), 3).toString();
				//���������ý��ı���
				name.setText(sname);
				style.setText(sstyle);
				s_id.setText(sid);
				super.mouseClicked(e);
			}
		});
		//����Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(40, 70, 300, 130);
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
						Storage storage = new Storage();
						storage.setStoragename(name.getText());
						storage.setStoragestyle(style.getText());
						storage.setStorageID(Integer.parseInt(s_id.getText()));
						s.Update(storage,"update storage set storagename = ?,storagestyle=?,storageID=? where id = "+ id);
						//��ʾɾ���ɹ�
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						s.Query("select * from storage");
						//ԭ���Ƴ�ԭ�������������
						//�������
						JTable new_table = new JTable(s.vec,c);
						new_table.setFont(f);
						//����Jscrollpane
						JScrollPane p = new JScrollPane(new_table);
						//�������齨�Ĵ�С
						p.setBounds(40, 70, 300, 130);
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
		index.add(storagename);
		index.add(name);
		index.add(storagestyle);
		index.add(style);
		index.add(storageid);
		index.add(s_id);
		index.add(js);
		//��Ӱ�ť
		index.add(update);
	}
}
