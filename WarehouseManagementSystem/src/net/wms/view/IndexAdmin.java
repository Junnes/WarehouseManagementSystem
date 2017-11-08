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

public class IndexAdmin {
	//��������
	public  JFrame index;
	private JMenuBar management;
	private JMenu user;
	private JMenu goods;
	private JMenu storage;
	private JMenuItem exit;
	private JMenuItem useradd;
	private JMenuItem userdelete;
	private JMenuItem userupdate;
	private JMenuItem userselect;
	private JMenuItem goodsadd;
	private JMenuItem goodsdelete;
	private JMenuItem goodsupdate;
	private JMenuItem storageadd;
	private JMenuItem storagedelete;
	private JMenuItem storageupdate;
	Font f = new Font("����", Font.BOLD, 15);
	
	//���캯��
	public IndexAdmin(String name) {
		indexadmin();
		//�˵������
		//���û��˵������Ŀ
		user.add(useradd);
		user.add(userselect);
		user.add(userdelete);
		user.add(userupdate);
		user.add(exit);
		//����Ʒ�˵������Ŀ
		goods.add(goodsadd);
		goods.add(goodsdelete);
		goods.add(goodsupdate);
		//���ֿ�˵������Ŀ
		storage.add(storageadd);
		storage.add(storagedelete);
		storage.add(storageupdate);
		//���˵���ӵ��˵�����
		management.add(user);
		management.add(goods);
		management.add(storage);
		init(name);
		action(name);
	}
	
	private void init(String name) {
		//��ʼ�����
		index = new JFrame("��ӭ����Ա"+name+"ʹ�ñ�ϵͳ");
		//���ÿ�ܴ�С��λ��
		index.setBounds(500, 100, 400, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���˵������ý����
		index.setJMenuBar(management);
		//��տ�ܸ�ʽ
		index.setLayout(null);
		//�����ת��Ϊ����
		((JComponent) index.getContentPane()).setOpaque(false);
		//����ͼƬ����
		ImageIcon img = null;
		//���������
		Random r = new Random();
		int i = r.nextInt(5);
		//���������ֵ��ȡ��ͬ��ͼƬ
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
		//��ʼ����ǩ
		JLabel background = new JLabel(img);
		//����ǩ��ӽ����index����ӽ������У�
		index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		//���ñ�ǩ��С
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		//���ÿ��ӻ�
		index.setVisible(true);
	}

	public void indexadmin() {
		//�����ʼ���Լ���������
		management = new JMenuBar();
		//�˵���ʼ��
		user = new JMenu(" �û�����");
		user.setFont(f);
		goods = new JMenu(" ��Ʒ����");
		goods.setFont(f);
		storage = new JMenu(" �ֿ����");
		storage.setFont(f);
		//�˵���Ŀ��ʼ��
		exit = new JMenuItem("�����û�");
		exit.setFont(f);
		useradd = new JMenuItem("����û�");
		useradd.setFont(f);
		userdelete = new JMenuItem("ɾ���û�");
		userdelete.setFont(f);
		userupdate = new JMenuItem("�����޸�");
		userupdate.setFont(f);
		userselect = new JMenuItem("��ѯ�û�");
		userselect.setFont(f);
		goodsadd = new JMenuItem("��Ʒ���");
		goodsadd.setFont(f);
		goodsdelete = new JMenuItem("��Ʒɾ��");
		goodsdelete.setFont(f);
		goodsupdate = new JMenuItem("��Ʒ����");
		goodsupdate.setFont(f);
		storageadd = new JMenuItem("�ֿ����");
		storageadd.setFont(f);
		storagedelete = new JMenuItem("�ֿ�ɾ��");
		storagedelete.setFont(f);
		storageupdate = new JMenuItem("�ֿ����");
		storageupdate.setFont(f);
	}
	
	//�����еĲ˵���Ŀ���ü����¼�
	private void action(final String name) {
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				//��ԭ��ҳ������Ϊ���ɼ�
				index.setVisible(false);
				//���ú���ת����½ҳ��
				Login.main(null);
			}
		});
		useradd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				//��ԭ��ҳ������Ϊ���ɼ�
				index.setVisible(false);
				//�ù��캯����ȡ��ҳ��
				new Useradd(name); 
			}
		});
		userselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Userselect(name);
			}
		});
		userdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Userdelete(name);
			}
		});
		userupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Adminupdate(name);
			}
		});
		goodsadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Goodsadd(name);
			}
		});
		goodsdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Goodsdelete(name);
			}
		});
		goodsupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new GoodsUpdate(name);
			}
		});
		storageadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Storageadd(name);
			}
		});
		storagedelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Storagedelete(name);
			}
		});
		storageupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ת��
				index.setVisible(false);
				new Storageupdate(name);
			}
		});
	}
}