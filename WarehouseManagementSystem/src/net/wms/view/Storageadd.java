package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.wms.bean.Storage;
import net.wms.dao.StoragemanagementImp;

public class Storageadd extends IndexAdmin{
	
	JTextField name;
	JTextField style;
	JTextField id;
	Storage storage = new Storage();
	
	public Storageadd(String name) {
		super(name);
		init();
	}
	public void init() {
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		JLabel storagetitle = new JLabel("�ֿ����");
		JLabel storagename = new JLabel("�ֿ�����");
		name = new JTextField();
		JLabel storagestyle = new JLabel("��  �ͣ�");
		style = new JTextField();
		JLabel storageid = new JLabel("��  �ţ�");
		id = new JTextField();
		JButton submit = new JButton("�ύ");
		JButton reset = new JButton("����");
		storagetitle.setBounds(130, 60, 100, 40);
		storagetitle.setFont(d);
		storagename.setBounds(60, 140, 80, 30);
		storagename.setFont(f);
		name.setBounds(140, 140, 150, 30);
		name.setFont(f);
		storagestyle.setBounds(60, 200, 80, 30);
		storagestyle.setFont(f);
		style.setBounds(140, 200, 150, 30);
		style.setFont(f);
		storageid.setBounds(60, 260, 80, 30);
		storageid.setFont(f);
		id.setBounds(140, 260, 150, 30);
		id.setFont(f);
		submit.setBounds(90, 320, 80, 30);
		submit.setFont(f);
		reset.setBounds(200, 320, 80, 30);
		reset.setFont(f);
		index.add(storagetitle);
		index.add(storagename);
		index.add(name);
		index.add(storagestyle);
		index.add(style);
		index.add(storageid);
		index.add(id);
		index.add(submit);
		index.add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				name.setText("");
				style.setText("");
				id.setText("");
			}
		});
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(name.getText().equals("") || style.getText().equals("") || id.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"����������");
				} else {
					storage.setStoragename(name.getText());
					storage.setStoragestyle(style.getText());
					storage.setStorageID(Integer.parseInt(id.getText()));
					StoragemanagementImp s = new StoragemanagementImp();
					try {
						s.Add(storage, "insert into storage(storagename,storagestyle,storageID)" + "values(?,?,?)");
						name.setText("");
						style.setText("");
						id.setText("");
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
