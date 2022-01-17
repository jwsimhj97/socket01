package soc.pj;
// main â		

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.*;

public class Sopj01 extends JFrame implements ActionListener{
	JButton writeBtn, listBtn;
	static JPanel p;
	static Panel pCont,pContList;
	static JLabel jLtit;

	Font fmainTitle=new Font(Font.SANS_SERIF, Font.BOLD, 30);
	Font topTitf=new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	Font topTitf2=new Font(Font.SANS_SERIF, Font.PLAIN, 16);
	
	static File dir = new File("D:\\javaWork\\socketProject1\\shareBox");	
	static File[] files = dir.listFiles();
//	JButton[] wrlist=new JButton[files.length];
	static JButton[] listLine = new JButton[files.length];
	Object obj="";	
	
	public void ListCont(){		// �Խñ� list
//        for (int i = 0; i < bt.length; i++) {
//            bt[i] = new JButton("Button" + i);
//            pContList.add(bt[i]);
//        }
		
		for(int i=0; i<listLine.length; i++){
			listLine[i]=new JButton("Button" + i);
			listLine[i].setBackground(Color.WHITE);
			listLine[i].setLayout(new GridLayout(1,4));
			
			JLabel jLnum=new JLabel(Integer.toString(i+1));	// No.
			jLnum.setHorizontalAlignment(JLabel.CENTER);
			jLnum.setBackground(Color.WHITE);
			jLnum.setFont(topTitf2);
			jLnum.setOpaque(true);
			
			jLtit=new JLabel(files[i].getName());	// ����
			jLtit.setHorizontalAlignment(JLabel.CENTER);
			jLtit.setBackground(Color.WHITE);
			jLtit.setFont(topTitf2);
			jLtit.setOpaque(true);
			
//			Sopj03.listNum=i;
//			new Sopj03();
			JLabel jLwrit=new JLabel("�ۼ���");				// �ۼ���
			jLwrit.setHorizontalAlignment(JLabel.CENTER);
			jLwrit.setBackground(Color.WHITE);
			jLwrit.setFont(topTitf2);
			jLwrit.setOpaque(true);
			
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			long lastModified = files[i].lastModified(); // date		
			Date lastModifiedDate = new Date( lastModified );
			JLabel jLdate=new JLabel(simpleDateFormat.format( lastModifiedDate ));				// ��¥
			jLdate.setHorizontalAlignment(JLabel.CENTER);
			jLdate.setBackground(Color.WHITE);
			jLdate.setFont(topTitf2);
			jLdate.setOpaque(true);
			
			listLine[i].add(jLnum);
			listLine[i].add(jLtit);
			listLine[i].add(jLwrit);
			listLine[i].add(jLdate);
			listLine[i].addActionListener(this);
			pContList.add(listLine[i]);

			
		}
		
	}
	
	public Sopj01(){	
		
		p=new JPanel();	// ��ü�г�
		p.setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {		// p�г� â�ݱ�
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Panel pTop=new Panel(new GridLayout(2,1));				// ž�г� start

		Panel pTopTit=new Panel(new GridLayout(1,1));			// ž�г�-����title
		JLabel mainTitle=new JLabel("IDEA SHARE BOX");
		mainTitle.setFont(fmainTitle);
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		pTopTit.add(mainTitle);
		pTop.add(pTopTit);		
		
		Panel pTopListTit=new Panel();		// ž�г�-���title
		pTopListTit.setLayout(new GridLayout(1,4));		
		JLabel[] tLa=new JLabel[4];		
		tLa[0]=new JLabel("No.");
		tLa[0].setFont(topTitf);
		tLa[1]=new JLabel("����");
		tLa[1].setFont(topTitf);
		tLa[2]=new JLabel("�ۼ���");
		tLa[2].setFont(topTitf);
		tLa[3]=new JLabel("��¥");
		tLa[3].setFont(topTitf);
		for(int i=0; i<4; i++){
			tLa[i].setHorizontalAlignment(JLabel.CENTER);
			tLa[i].setForeground(Color.WHITE);	// j�� font������
			tLa[i].setBackground(Color.DARK_GRAY);
			tLa[i].setOpaque(true);
			pTopListTit.add(tLa[i]);
		}
		pTop.add(pTopListTit);
		p.add(pTop, BorderLayout.NORTH);	// ž�г� end
		
		
		
		
		pCont=new Panel(new GridLayout(1,1));					// �������г� start
		pContList=new Panel(new GridLayout(10,1));
//		pContList.setLayout(new GridLayout(wrlist.length,4));
		ListCont();		// ������ - �Խñ�list
		pCont.add(pContList);
		p.add(pCont, BorderLayout.CENTER);	// �������г� end
		
		
		
		
		
		Panel pBotn=new Panel();			// �����г� start
		
		
		writeBtn=new JButton("�۾���");
		writeBtn.addActionListener(this);
		pBotn.add(writeBtn);
		p.add(pBotn, BorderLayout.SOUTH);	// �����г� end
		
		
				
		add(p);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		
	}

	public static void main(String[] args) {	
		new Sopj01();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		obj=e.getSource();
		
		if(obj==writeBtn){		// �۾����ư
			new Sopj02();
			setVisible(false);
			
		}

//		JButton[] listLine = new JButton[files.length];
		for(int i=0; i<listLine.length; i++){
			if(obj==listLine[i]){
//				System.out.println(i);
				Sopj03.listNum=i;
				new Sopj03();
				setVisible(false);
			}			
		}
	}

}
