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

	
	public CopyOfSopj030114(){	// 게시글 list별 내용
		JPanel allListP=new JPanel();	// 전체패널
		
		JPanel listCoP=new JPanel();	// 게시글내용 전체패널
		listCoP.setLayout(new BorderLayout());
//		listCoP.setLayout(new BorderLayout());
//		listCoP.setLayout(new GridLayout(10,1));
		addWindowListener(new WindowAdapter() {		// p패널 창닫기
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Font topTitf=new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		Font topTitf2=new Font(Font.SANS_SERIF, Font.PLAIN, 16);		
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		
		JPanel pTop=new JPanel();	// 탑패널
		pTop.setLayout(new BorderLayout());		
		Panel topTp=new Panel();		// 탑-탑패널 start
		topTp.setLayout(new GridLayout(1,3));
		JLabel[] tLa=new JLabel[3];			
//		tLa[0]=new JLabel("No.");
//		tLa[0].setFont(topTitf);
		tLa[0]=new JLabel("제목");
		tLa[0].setFont(topTitf);
		tLa[1]=new JLabel("작성자");
		tLa[1].setFont(topTitf);
		tLa[2]=new JLabel("날짜");
		tLa[2].setFont(topTitf);
		for(int i=0; i<3; i++){
			tLa[i].setHorizontalAlignment(JLabel.CENTER);
			tLa[i].setForeground(Color.WHITE);	// j라벨 font색변경
			tLa[i].setBackground(Color.DARK_GRAY);
			tLa[i].setOpaque(true);
			topTp.add(tLa[i]);
		}	
		pTop.add(topTp, BorderLayout.NORTH);	// 탑-탑패널 end
	
		Panel topBp=new Panel();		// 탑-바텀패널 start
		topBp.setLayout(new GridLayout(1,3));
		tLa2=new JLabel[3];			
//		tLa2[0]=new JLabel("dd");
//		tLa2[0].setFont(topTitf2);
		tLa2[0]=new JLabel("제목");
		tLa2[0].setFont(topTitf2);
		tLa2[1]=new JLabel("작성자");
		tLa2[1].setFont(topTitf2);
		tLa2[2]=new JLabel("날짜");
		tLa2[2].setFont(topTitf2);
		for(int i=0; i<3; i++){
			tLa2[i].setHorizontalAlignment(JLabel.CENTER);
			tLa2[i].setBackground(Color.WHITE);
			tLa2[i].setOpaque(true);
			topBp.add(tLa2[i]);
		}	
		pTop.add(topBp, BorderLayout.SOUTH);	// 탑-바텀패널 end
		listCoP.add(pTop, BorderLayout.NORTH);	// 탑패널 end
		

		Panel pBtt=new Panel();	// 내용패널
		pBtt.setLayout(new GridLayout(1,1));
		ta = new JTextArea("");
		ta.setLayout(new BorderLayout());
		ta.setFont(topTitf2);
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
	    // TextArea에 스크롤 기능을 추가한 후 Panel안에 집어 넣습니다.
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
			tLa2[0].setText((list.get(0)).toString());	// topBp - 제목
			tLa2[1].setText((list.get(1)).toString());	// topBp - 작성자
			tLa2[2].setText((list.get(2)).toString());	// topBp - 날짜
			ta.setText((list.get(4)).toString());		// pBtt - 내용
//			(list.get(3)).toString()	// 비밀번호
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
		
		
		
		
		JPanel pComent=new JPanel(new BorderLayout());	// 댓글패널 start
		
		
		JPanel pBcoSet=new JPanel(new GridLayout(3,1));	// 댓글한묶음 패널 start		
		JPanel pBcoSetTop=new JPanel(new GridLayout(1,4));
		JLabel coLa1=new JLabel("아이디");
		pBcoSetTop.add(coLa1);
		JTextField tfCoId = new JTextField();	// 댓글아이디
		pBcoSetTop.add(tfCoId);
		JLabel coLa2=new JLabel("비번");
		pBcoSetTop.add(coLa2);
		JTextField tfCoPw = new JTextField();	// 댓글비번
		pBcoSetTop.add(tfCoPw);
		pBcoSet.add(pBcoSetTop);
		
		JPanel pBcoSetBtt=new JPanel(new GridLayout(1,1));
		JTextField tfComt = new JTextField();	// 댓글내용
		pBcoSetBtt.add(tfComt);
		pBcoSet.add(pBcoSetBtt);	
		
		JPanel pBcoSetSaveBtn=new JPanel(new BorderLayout());	// 댓글 저장버튼
		JButton saveBtn=new JButton("등록");
		pBcoSetSaveBtn.add(saveBtn, BorderLayout.EAST);
		pBcoSet.add(pBcoSetSaveBtn);	
		pComent.add(pBcoSet);		// 댓글한묶음 패널 end	
		
		allListP.add(new JScrollPane(pComent), BorderLayout.SOUTH);		// 댓글패널 end
		
		add(allListP);
		setBounds(100,100,600,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CopyOfSopj030114();
	}

}