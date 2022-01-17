package soc.pj;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class CopyOfSopj030114 extends Frame{
	private JTextArea ta;
	private TextField tfId, taTitle;
	
	File dir = new File("D:\\javaWork\\socketProject1\\shareBox");
	File[] files = dir.listFiles();
	JButton[] wrlist=new JButton[files.length];
	JLabel[] tLa2;
	

	static int listNum=0;

	
	public CopyOfSopj030114(){	// �Խñ� list�� ����
		JPanel allListP=new JPanel();	// ��ü�г�
		
		JPanel listCoP=new JPanel();	// �Խñ۳��� ��ü�г�
		listCoP.setLayout(new BorderLayout());
//		listCoP.setLayout(new BorderLayout());
//		listCoP.setLayout(new GridLayout(10,1));
		addWindowListener(new WindowAdapter() {		// p�г� â�ݱ�
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Font topTitf=new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		Font topTitf2=new Font(Font.SANS_SERIF, Font.PLAIN, 16);		
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		
		JPanel pTop=new JPanel();	// ž�г�
		pTop.setLayout(new BorderLayout());		
		Panel topTp=new Panel();		// ž-ž�г� start
		topTp.setLayout(new GridLayout(1,3));
		JLabel[] tLa=new JLabel[3];			
//		tLa[0]=new JLabel("No.");
//		tLa[0].setFont(topTitf);
		tLa[0]=new JLabel("����");
		tLa[0].setFont(topTitf);
		tLa[1]=new JLabel("�ۼ���");
		tLa[1].setFont(topTitf);
		tLa[2]=new JLabel("��¥");
		tLa[2].setFont(topTitf);
		for(int i=0; i<3; i++){
			tLa[i].setHorizontalAlignment(JLabel.CENTER);
			tLa[i].setForeground(Color.WHITE);	// j�� font������
			tLa[i].setBackground(Color.DARK_GRAY);
			tLa[i].setOpaque(true);
			topTp.add(tLa[i]);
		}	
		pTop.add(topTp, BorderLayout.NORTH);	// ž-ž�г� end
	
		Panel topBp=new Panel();		// ž-�����г� start
		topBp.setLayout(new GridLayout(1,3));
		tLa2=new JLabel[3];			
//		tLa2[0]=new JLabel("dd");
//		tLa2[0].setFont(topTitf2);
		tLa2[0]=new JLabel("����");
		tLa2[0].setFont(topTitf2);
		tLa2[1]=new JLabel("�ۼ���");
		tLa2[1].setFont(topTitf2);
		tLa2[2]=new JLabel("��¥");
		tLa2[2].setFont(topTitf2);
		for(int i=0; i<3; i++){
			tLa2[i].setHorizontalAlignment(JLabel.CENTER);
			tLa2[i].setBackground(Color.WHITE);
			tLa2[i].setOpaque(true);
			topBp.add(tLa2[i]);
		}	
		pTop.add(topBp, BorderLayout.SOUTH);	// ž-�����г� end
		listCoP.add(pTop, BorderLayout.NORTH);	// ž�г� end
		

		Panel pBtt=new Panel();	// �����г�
		pBtt.setLayout(new GridLayout(1,1));
		ta = new JTextArea("");
		ta.setLayout(new BorderLayout());
		ta.setFont(topTitf2);
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
	    // TextArea�� ��ũ�� ����� �߰��� �� Panel�ȿ� ���� �ֽ��ϴ�.
		pBtt.add(new JScrollPane(ta));
		listCoP.add(pBtt, BorderLayout.CENTER);		
		
		File a=files[listNum];
		String fiPath=files[listNum].getPath();
		BufferedReader reader;
		
		ArrayList<String> list=new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(fiPath));
			String str;
			while ((str = reader.readLine()) != null) {
				list.add(str);
//				ta = new JTextArea(str);	
//				JScrollPane scrollPane = new JScrollPane(ta);		
//				pBtt.add(ta);
			}
			
//			for(int i=0; i<list.size(); i++){
//				System.out.println(list.get(i));
//			}
//			tLa2[1]=new JLabel((list.get(0)).toString());
//			tLa2[0].setText();	// topBp - no.
			tLa2[0].setText((list.get(0)).toString());	// topBp - ����
			tLa2[1].setText((list.get(1)).toString());	// topBp - �ۼ���
			tLa2[2].setText((list.get(2)).toString());	// topBp - ��¥
			ta.setText((list.get(4)).toString());		// pBtt - ����
//			(list.get(3)).toString()	// ��й�ȣ
//			System.out.println((list.get(0)).toString());
//			System.out.println((list.get(1)).toString());
//			System.out.println((list.get(2)).toString());
//			System.out.println((list.get(3)).toString());
//			System.out.println((list.get(4)).toString());
			
//			tLa2[1].add(list.get(0));
			
//			String[] array = "fffff".split("\n");
//			for (int i = 0; i < array.length; i++) {
//				System.out.println(array[1]);
//			}
			reader.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		allListP.add(listCoP);
		
		
		
		
		JPanel pComent=new JPanel(new BorderLayout());	// ����г� start
		
		
		JPanel pBcoSet=new JPanel(new GridLayout(3,1));	// ����ѹ��� �г� start		
		JPanel pBcoSetTop=new JPanel(new GridLayout(1,4));
		JLabel coLa1=new JLabel("���̵�");
		pBcoSetTop.add(coLa1);
		JTextField tfCoId = new JTextField();	// ��۾��̵�
		pBcoSetTop.add(tfCoId);
		JLabel coLa2=new JLabel("���");
		pBcoSetTop.add(coLa2);
		JTextField tfCoPw = new JTextField();	// ��ۺ��
		pBcoSetTop.add(tfCoPw);
		pBcoSet.add(pBcoSetTop);
		
		JPanel pBcoSetBtt=new JPanel(new GridLayout(1,1));
		JTextField tfComt = new JTextField();	// ��۳���
		pBcoSetBtt.add(tfComt);
		pBcoSet.add(pBcoSetBtt);	
		
		JPanel pBcoSetSaveBtn=new JPanel(new BorderLayout());	// ��� �����ư
		JButton saveBtn=new JButton("���");
		pBcoSetSaveBtn.add(saveBtn, BorderLayout.EAST);
		pBcoSet.add(pBcoSetSaveBtn);	
		pComent.add(pBcoSet);		// ����ѹ��� �г� end	
		
		allListP.add(new JScrollPane(pComent), BorderLayout.SOUTH);		// ����г� end
		
		add(allListP);
		setBounds(100,100,600,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CopyOfSopj030114();
	}

}