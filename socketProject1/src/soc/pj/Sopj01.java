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
	
	public void ListCont(){		// 게시글 list
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
			
			jLtit=new JLabel(files[i].getName());	// 제목
			jLtit.setHorizontalAlignment(JLabel.CENTER);
			jLtit.setBackground(Color.WHITE);
			jLtit.setFont(topTitf2);
			jLtit.setOpaque(true);
			
//			Sopj03.listNum=i;
//			new Sopj03();
			JLabel jLwrit=new JLabel("작성자");				// 작성자
			jLwrit.setHorizontalAlignment(JLabel.CENTER);
			jLwrit.setBackground(Color.WHITE);
			jLwrit.setFont(topTitf2);
			jLwrit.setOpaque(true);
			
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			long lastModified = files[i].lastModified(); // date		
			Date lastModifiedDate = new Date( lastModified );
			JLabel jLdate=new JLabel(simpleDateFormat.format( lastModifiedDate ));				// 날짜
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
		
		p=new JPanel();	// 전체패널
		p.setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {		// p패널 창닫기
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Panel pTop=new Panel(new GridLayout(2,1));				// 탑패널 start

		Panel pTopTit=new Panel(new GridLayout(1,1));			// 탑패널-메인title
		JLabel mainTitle=new JLabel("IDEA SHARE BOX");
		mainTitle.setFont(fmainTitle);
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		pTopTit.add(mainTitle);
		pTop.add(pTopTit);		
		
		Panel pTopListTit=new Panel();		// 탑패널-목록title
		pTopListTit.setLayout(new GridLayout(1,4));		
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
			pTopListTit.add(tLa[i]);
		}
		pTop.add(pTopListTit);
		p.add(pTop, BorderLayout.NORTH);	// 탑패널 end
		
		
		
		
		pCont=new Panel(new GridLayout(1,1));					// 컨텐츠패널 start
		pContList=new Panel(new GridLayout(10,1));
//		pContList.setLayout(new GridLayout(wrlist.length,4));
		ListCont();		// 컨텐츠 - 게시글list
		pCont.add(pContList);
		p.add(pCont, BorderLayout.CENTER);	// 컨텐츠패널 end
		
		
		
		
		
		Panel pBotn=new Panel();			// 바텀패널 start
		
		
		writeBtn=new JButton("글쓰기");
		writeBtn.addActionListener(this);
		pBotn.add(writeBtn);
		p.add(pBotn, BorderLayout.SOUTH);	// 바텀패널 end
		
		
				
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
		
		if(obj==writeBtn){		// 글쓰기버튼
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
