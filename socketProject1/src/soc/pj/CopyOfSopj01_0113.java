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

public class CopyOfSopj01_0113 extends JFrame implements ActionListener{
	JButton writeBtn, listBtn;
	Panel pCont,pContList;
	
	File dir = new File("D:\\javaWork\\socketProject1\\shareBox");	
	File[] files = dir.listFiles();
	JButton[] wrlist=new JButton[files.length];
	JLabel[][] listLineLa;
	int listLength=files.length;
	String listLng=Integer.toString(listLength);

	Object obj="";	
	
	public void ListCont(){		// �Խñ� list		
		//////////////////////////////////////////////////
//		java.util.List<Date> myList = new ArrayList<>();
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
////		myList.sort(c);
//		for(int i=0; i<listLength; i++){			
//			long lastModified = files[i].lastModified(); // date		
//			Date lastModifiedDate = new Date( lastModified );
//
//			myList.add(new Date( lastModified ));
//		}
//		Collections.sort(myList, new Comparator<Date>(){
//            @Override
//            public int compare(Date o1, Date o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        for(int i = 0; i < myList.size(); i++){
//        	String alistNum=String.valueOf(i+1);	// list�� �ε�����ȣ
//			String alistTitle=files[i].getName();	// list�� ����
//        	
//			String alistWriter=null;
//			String alistDate=simpleDateFormat.format(myList.get(i));	// list�� ���糯¥
//			
//			System.out.println(alistNum+alistTitle+alistWriter+alistDate);
//        }	
		

		//////////////////////////////////////////////////
		listLineLa=new JLabel[listLength][4];
		for(int i=0; i<listLineLa.length; i++) {
			for(int j=0; j<listLineLa[i].length; j++) {				
				listLineLa[i][j]=new JLabel("��");
				
				listLineLa[i][0]=new JLabel(String.valueOf(i+1));	// No. �κ�
				listLineLa[i][1]=new JLabel(files[i].getName());
				listLineLa[i][2]=new JLabel("ddddd"); // Sopj02 - laId->tfId 
				
//				listLineLa[i][3]=new JLabel("��");			
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				long lastModified = files[i].lastModified(); // date		
				Date lastModifiedDate = new Date( lastModified );
				listLineLa[i][3]=new JLabel(simpleDateFormat.format( lastModifiedDate ));
				

				listLineLa[i][j].addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	obj=e.getSource();		            	
		            	System.out.println("Ŭ��");		
		            }
		        });
				pContList.add(listLineLa[i][j]);
			}
		}
		
	}
	
	public CopyOfSopj01_0113(){	
		
		JPanel p=new JPanel();	// ��ü�г�
		p.setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {		// p�г� â�ݱ�
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Font topTitf=new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		Panel pTop=new Panel();				// ž�г� start
		pTop.setLayout(new GridLayout(1,4));
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
			pTop.add(tLa[i]);
		}
		p.add(pTop, BorderLayout.NORTH);	// ž�г� end
		
		
		
		
		pCont=new Panel();					// �������г� start
		pContList=new Panel();
		pContList.setLayout(new GridLayout(wrlist.length,4));
		ListCont();		// ������ - �Խñ�list
		pCont.add(pContList);
		p.add(pCont, BorderLayout.CENTER);	// �������г� end
		
		
		
		
		Panel pBotn=new Panel();			// �����г� start
		
		
		writeBtn=new JButton("�۾���");
		writeBtn.addActionListener(this);
		pBotn.add(writeBtn);
		p.add(pBotn, BorderLayout.SOUTH);	// �����г� end

		

//		Thread nt = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (true) {
////					ListCont();
//					pContList.revalidate();
//					pContList.repaint(); // �׸� �ٽñ׸���
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		nt.start(); // ������ ����
				
		add(p);
		setBounds(100, 100, 800, 600);
		setVisible(true);

		
	}

	public static void main(String[] args) {	
		new CopyOfSopj01_0113();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		obj=e.getSource();
		
		if(obj==writeBtn){		// �۾����ư
			new Sopj02();
		}		
		
//		for(int i=0; i<wrlist.length; i++){	// ����Ʈ�� ��ư
//			if(obj==wrlist[i]){
//				Sopj03.listNum=i;
//				new Sopj03();
//			}
//		}
	}

}
