package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Index {
	//��������
	public  JFrame index;
	private JMenuBar management;
	private JMenu user;
	private JMenu goods;
	private JMenu storage;
	private JMenuItem exit;
	private JMenuItem usernews;
	private JMenuItem userupdate;
	private JMenuItem goodsselect;
	private JMenuItem storageselect;
	
	//�������캯��
	public Index(String name) {
		indexadmin();
		//��Ӷ���
		user.add(usernews);
		user.add(userupdate);
		user.add(exit);
		goods.add(goodsselect);
		storage.add(storageselect);
		management.add(user);
		management.add(goods);
		management.add(storage);
		init(name);
		action(name);
	}
	
	
	private void init(String name) {
		//��ʼ����index
		index = new JFrame("��ӭ�û�"+name+"ʹ�ñ�ϵͳ");
		//���ÿ�ܴ�С��λ��
		index.setBounds(500, 100, 400, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���˵������ý����
		index.setJMenuBar(management);
		index.setLayout(null);
		//�����������
		((JComponent) index.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		Random r = new Random();
		int i = r.nextInt(5);
		switch (i) {
		case 0:
			img = new ImageIcon("Images//������.jpg");
			break;
		case 1:
			img = new ImageIcon("Images//������1.jpg");
			break;
		case 2:
			img = new ImageIcon("Images//������2.jpg");
			break;
		case 3:
			img = new ImageIcon("Images//������3.jpg");
			break;
		case 4:
			img = new ImageIcon("Images//������4.jpg");
			break;
		default:
			break;
		}
		JLabel background = new JLabel(img);
		index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		index.setVisible(true);
	}
	
	public void indexadmin() {
		//��ʼ������
		Font f = new Font("����", Font.BOLD, 15);
		management = new JMenuBar();
		user = new JMenu(" �û�����");
		user.setFont(f);
		goods = new JMenu(" ��Ʒ����");
		goods.setFont(f);
		storage = new JMenu(" �ֿ����");
		storage.setFont(f);
		exit = new JMenuItem("�����û�");
		exit.setFont(f);
		usernews = new JMenuItem("������Ϣ");
		usernews.setFont(f);
		userupdate = new JMenuItem("�����޸�");
		userupdate.setFont(f);
		goodsselect = new JMenuItem("��Ʒ���");
		goodsselect.setFont(f);
		storageselect = new JMenuItem("�ֿ����");
		storageselect.setFont(f);
	}
	
	//Ϊ���еĲ˵���Ŀ���ü����¼�
	private void action(final String name) {
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				Login.main(null);
			}
		});
		usernews.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Usernews(name);
			}
		});
		userupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Userupdate(name);
			}
		});
		goodsselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new GoodsSelect(name);
			}
		});
		storageselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Storageselect(name);
			}
		});
	}
}
