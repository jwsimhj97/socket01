package soc.pj;
// main 창		

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
	
	public void ListCont(){		// 게시글 list		
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
//        	String alistNum=String.valueOf(i+1);	// list의 인덱스번호
//			String alistTitle=files[i].getName();	// list의 주제
//        	
//			String alistWriter=null;
//			String alistDate=simpleDateFormat.format(myList.get(i));	// list의 만든날짜
//			
//			System.out.println(alistNum+alistTitle+alistWriter+alistDate);
//        }	
		

		//////////////////////////////////////////////////
		listLineLa=new JLabel[listLength][4];
		for(int i=0; i<listLineLa.length; i++) {
			for(int j=0; j<listLineLa[i].length; j++) {				
				listLineLa[i][j]=new JLabel("아");
				
				listLineLa[i][0]=new JLabel(String.valueOf(i+1));	// No. 부분
				listLineLa[i][1]=new JLabel(files[i].getName());
				listLineLa[i][2]=new JLabel("ddddd"); // Sopj02 - laId->tfId 
				
//				listLineLa[i][3]=new JLabel("라");			
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				long lastModified = files[i].lastModified(); // date		
				Date lastModifiedDate = new Date( lastModified );
				listLineLa[i][3]=new JLabel(simpleDateFormat.format( lastModifiedDate ));
				

				listLineLa[i][j].addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	obj=e.getSource();		            	
		            	System.out.println("클릭");		
		            }
		        });
				pContList.add(listLineLa[i][j]);
			}
		}
		
	}
	
	public CopyOfSopj01_0113(){	
		
		JPanel p=new JPanel();	// 전체패널
		p.setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {		// p패널 창닫기
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Font topTitf=new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		Panel pTop=new Panel();				// 탑패널 start
		pTop.setLayout(new GridLayout(1,4));
		JLabel[] tLa=new JLabel[4];
		
		tLa[0]=new JLabel("No.");
		tLa[0].setFont(topTitf);
		tLa[1]=new JLabel("제목");
		tLa[1].setFont(topTitf);
		tLa[2]=new JLabel("작성자");
		tLa[2].setFont(topTitf);
		tLa[3]=new JLabel("날짜");
		tLa[3].setFont(topTitf);
		for(int i=0; i<4; i++){
			tLa[i].setHorizontalAlignment(JLabel.CENTER);
			tLa[i].setForeground(Color.WHITE);	// j라벨 font색변경
			tLa[i].setBackground(Color.DARK_GRAY);
			tLa[i].setOpaque(true);
			pTop.add(tLa[i]);
		}
		p.add(pTop, BorderLayout.NORTH);	// 탑패널 end
		
		
		
		
		pCont=new Panel();					// 컨텐츠패널 start
		pContList=new Panel();
		pContList.setLayout(new GridLayout(wrlist.length,4));
		ListCont();		// 컨텐츠 - 게시글list
		pCont.add(pContList);
		p.add(pCont, BorderLayout.CENTER);	// 컨텐츠패널 end
		
		
		
		
		Panel pBotn=new Panel();			// 바텀패널 start
		
		
		writeBtn=new JButton("글쓰기");
		writeBtn.addActionListener(this);
		pBotn.add(writeBtn);
		p.add(pBotn, BorderLayout.SOUTH);	// 바텀패널 end

		

//		Thread nt = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (true) {
////					ListCont();
//					pContList.revalidate();
//					pContList.repaint(); // 그림 다시그리기
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		nt.start(); // 스레드 실행
				
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
		
		if(obj==writeBtn){		// 글쓰기버튼
			new Sopj02();
		}		
		
//		for(int i=0; i<wrlist.length; i++){	// 리스트별 버튼
//			if(obj==wrlist[i]){
//				Sopj03.listNum=i;
//				new Sopj03();
//			}
//		}
	}

}
