package soc.pj;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;

public class Sopj03 extends Frame implements ActionListener{
	private JTextArea ta;
	private TextField tfId, taTitle;
	JTextField tfComt, deltfCoPw, tfCoId, tfCoPrId;
	JPasswordField tfCoPw;
	JTextArea coPrTa;
	JPanel pComPr;
	
	File dir = new File("D:\\javaWork\\socketProject1\\shareBox");
	File[] files = dir.listFiles();
	JButton[] wrlist=new JButton[files.length];
	JButton delBtn, writeBtn, saveBtn, delchkBtn;
	JLabel[] tLa2;
	Object obj;
	
	JPanel allListP, delCheck;
	

	
	ArrayList<String> list=new ArrayList<>();	
	String str;
	
	File a=files[listNum];
	String fiPath=files[listNum].getPath();
	BufferedReader reader;
	

	static int listNum=0;

	public void deleteFile() {	// 게시글 삭제        
		String getPwchk=deltfCoPw.getText();
		try {
			reader = new BufferedReader(new FileReader(fiPath));
			while ((str = reader.readLine()) != null) {
				list.add(str);
			}

			String getTit=(list.get(0)).toString();	// 게시글에 저장된 제목 가져오기
			String getPw=(list.get(3)).toString();	// 게시글에 저장된 비밀번호 가져오기
			if(getPwchk.equals(getPw)){
				System.out.println("아이디와 비밀번호가 일치합니다. 게시글을 삭제합니다");
		        // 파일의 경로 + 파일명
		        String filePath = "D:\\javaWork\\socketProject1\\shareBox\\"+getTit;
		        File deleteFile = new File(filePath);
		        // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
		        if(deleteFile.exists()) {		            
		            // 파일을 삭제합니다.		        	
					System.gc();
//					System.runFinalization();
					deleteFile.delete();
					
					dispose();
		            /// refresh 새로고침	이건비밀번호
		            
					Sopj01 sp1=new Sopj01();

					this.removeAll();
					this.add(sp1);
					sp1.pContList.revalidate();
					sp1.pContList.repaint(); 
					sp1.setVisible(true);
					
//					
		            System.out.println("파일을 삭제하였습니다.");
		            
		        } else {
		            System.out.println("파일이 존재하지 않습니다.");
		        }

//		        @Test
//		        public void test() {
//		            File targetFolder = new File("D:/data/test/delete");
//		            boolean isDelete = deleteDirectoryAndFiles(targetFolder);
//		            log.info("isDelete >>> {}", isDelete);
//		        }
//		        
//		        private boolean deleteDirectoryAndFiles(File targetFolder) {
//		            if(!targetFolder.exists()) {
//		                log.info("{} >>> 경로가 존재하지 않습니다.", targetFolder);
//		                return false;
//		            }
//		            
//		            File[] files = targetFolder.listFiles();
//		            for(File file : files) {
//		                if(file.isDirectory()) {
//		                    log.info("{} >>> 파일은 디렉토리입니다. 하위 파일을 확인하겠습니다.", file);
//		                    deleteDirectoryAndFiles(file);
//		                }
//		                file.delete();
//		                log.info("{} >>> 파일이 삭제되었습니다.", file);
//		            }
//		            
//		            return targetFolder.delete();
//		        }
		        
		        
		        
						    	
		    	
			}else{
				System.out.println("아이디와 비밀번호가 일치하지 않습니다");
			}
			reader.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
        
 
        
    }

	public void Comment(){	// 댓글등록
//      저장할 댓글
//      tfCoId - 아이디
//      tfCoPw - 비번
//      tfComt - 내용
//      saveBtn - 등록버튼
//      --------------
//      출력할 댓글창
//      tfCoPrId - 아이디
//      coPrTa - 댓글내용출력
//      coPrTa.setEditable(false);   // 내용 수정 불가
      System.out.println("댓글등록 버튼입니다.");
      
      String commId=tfCoId.getText();   // tfCoId - 등록할 아이디
      tfCoPrId.setText(commId);      // tfCoPrId - 등록받은 아이디
      tfCoPrId.setEditable(false);
      tfCoId.setText("");
      
      tfCoPw.setText("");      // 비번
      
      String commMsg=tfComt.getText();   // 내용
      coPrTa.setText(commMsg);
      tfComt.setText("");
      coPrTa.setEditable(false);

      pComPr.setVisible(true);      

		
	}

	
	public Sopj03(){	// 게시글 list별 내용
		allListP=new JPanel(new BorderLayout());	// 전체패널
		
		JPanel listCoP=new JPanel();	// 게시글내용 전체패널 start
		listCoP.setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {		// p패널 창닫기
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Font topTitf=new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		Font topTitf2=new Font(Font.SANS_SERIF, Font.PLAIN, 16);		
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border lineBorder2 = BorderFactory.createLineBorder(Color.black, 0);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border emptyBorder3 = BorderFactory.createEmptyBorder(50, 0, 0, 0);
		
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
		
		try {
			reader = new BufferedReader(new FileReader(fiPath));
			while ((str = reader.readLine()) != null) {
				list.add(str);
			}
			tLa2[0].setText((list.get(0)).toString());	// topBp - 제목
			tLa2[1].setText((list.get(1)).toString());	// topBp - 작성자
			tLa2[2].setText((list.get(2)).toString());	// topBp - 날짜
			ta.setText((list.get(4)).toString());		// pBtt - 내용
			ta.setEditable(false);	// 내용 수정 불가
			reader.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		JPanel pBttBtn=new JPanel(new BorderLayout());	// 바텀 버튼패널 start
		pBttBtn.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 40 , 10)); //상하좌우 10씩 띄우기
		
		JPanel pBBTop=new JPanel(new BorderLayout());	// 바텀-탑 버튼패널 start		
		delBtn=new JButton("삭제하기");	// 삭제하기 버튼
		delBtn.setFont(topTitf2);
		delBtn.setForeground(Color.WHITE);	// j라벨 font색변경
		delBtn.setBackground(Color.DARK_GRAY);
		delBtn.addActionListener(this);
		pBBTop.add(delBtn, BorderLayout.WEST);
		
		writeBtn=new JButton("글쓰기");	// 글쓰기 버튼
		writeBtn.setFont(topTitf2);
		writeBtn.setForeground(Color.WHITE);	// j라벨 font색변경
		writeBtn.setBackground(Color.DARK_GRAY);
		writeBtn.addActionListener(this);
		pBBTop.add(writeBtn, BorderLayout.EAST);
		pBttBtn.add(pBBTop, BorderLayout.NORTH);	// 바텀-탑 버튼패널 end
		

		JPanel pBBBtt=new JPanel(new BorderLayout());	// 바텀-바텀 버튼패널 start		
		delCheck=new JPanel(new GridLayout(2,1));
		delCheck.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 10 , 0)); //상하좌우 10씩 띄우기
		JPanel delIdPw=new JPanel(new GridLayout(1,4));		// 아이디-비번 패널
		JLabel delcoLa1=new JLabel("작성글 아이디");
		delcoLa1.setForeground(Color.WHITE);	// j라벨 font색변경
		delcoLa1.setBackground(Color.DARK_GRAY);
		delcoLa1.setHorizontalAlignment(JLabel.CENTER);
		delcoLa1.setOpaque(true);
		delIdPw.add(delcoLa1);
		JTextField deltfCoId = new JTextField();	// 댓글아이디
		deltfCoId.setText(tLa2[1].getText());
		deltfCoId.setEditable(false);	// 내용 수정 불가
		delIdPw.add(deltfCoId);
		JLabel delcoLa2=new JLabel("작성글 비번");
		delcoLa2.setForeground(Color.WHITE);	// j라벨 font색변경
		delcoLa2.setBackground(Color.DARK_GRAY);
		delcoLa2.setOpaque(true);
		delcoLa2.setHorizontalAlignment(JLabel.CENTER);
		delIdPw.add(delcoLa2);
		deltfCoPw = new JTextField();	// 댓글비번
		delIdPw.add(deltfCoPw);
		delCheck.add(delIdPw);	
		
		JPanel delChk=new JPanel(new BorderLayout());		// 아이디-비번 확인버튼 패널
		delchkBtn=new JButton("확인");
		delchkBtn.addActionListener(this);
		delChk.add(delchkBtn, BorderLayout.EAST);
		delCheck.add(delChk);	

		pBBBtt.add(delCheck);
		delCheck.setVisible(false);
		pBttBtn.add(pBBBtt, BorderLayout.SOUTH);	// 바텀-바텀 버튼패널 end
		
		listCoP.add(pBttBtn, BorderLayout.SOUTH);	// 바텀 버튼패널 end			
		allListP.add(listCoP, BorderLayout.CENTER);	// 게시글내용 전체패널 end
		
		
		
		/////// 댓글
		JPanel pComent=new JPanel(new BorderLayout());	// 댓글패널 start	
		
		////댓글작성묶음
		JPanel pcoSet=new JPanel(new GridLayout(3,1));	// 댓글작성묶음 패널 start	
		pcoSet.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10)); //상하좌우 10씩 띄우기
//		pcoSet.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder2));
		JPanel pcoSetTop=new JPanel(new GridLayout(1,4));
		JLabel coLa1=new JLabel("아이디");
		coLa1.setForeground(Color.WHITE);	// j라벨 font색변경
		coLa1.setBackground(Color.DARK_GRAY);
		coLa1.setHorizontalAlignment(JLabel.CENTER);
		coLa1.setOpaque(true);
		pcoSetTop.add(coLa1);
		tfCoId = new JTextField();	// 댓글아이디
		pcoSetTop.add(tfCoId);
		JLabel coLa2=new JLabel("비번");
		coLa2.setForeground(Color.WHITE);	// j라벨 font색변경
		coLa2.setBackground(Color.DARK_GRAY);
		coLa2.setOpaque(true);
		coLa2.setHorizontalAlignment(JLabel.CENTER);
		pcoSetTop.add(coLa2);
		tfCoPw = new JPasswordField();	// 댓글비번
		tfCoPw.setEchoChar('*');
		pcoSetTop.add(tfCoPw);
		pcoSet.add(pcoSetTop);
		
		JPanel pBcoSetBtt=new JPanel(new GridLayout(1,1));
		tfComt = new JTextField();	// 댓글내용
		pBcoSetBtt.add(tfComt);
		pcoSet.add(pBcoSetBtt);	
		
		JPanel pBcoSetSaveBtn=new JPanel(new BorderLayout());	// 댓글 저장버튼
		saveBtn=new JButton("등록");
		saveBtn.addActionListener(this);
		pBcoSetSaveBtn.add(saveBtn, BorderLayout.EAST);
		pcoSet.add(pBcoSetSaveBtn);	
		pComent.add(pcoSet, BorderLayout.NORTH);		// 댓글작성묶음 패널 end	
		
		
		////댓글출력묶음패널		
		pComPr=new JPanel(new BorderLayout());	// 댓글출력묶음패널 start
		pComPr.setBorder(BorderFactory.createCompoundBorder(lineBorder2, emptyBorder3));
		
		JPanel comentNum=new JPanel(new BorderLayout());	// 댓글 갯수현황
		comentNum.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10)); //상하좌우 10씩 띄우기
		JPanel coNumLeft=new JPanel();		
		JLabel coNum=new JLabel("댓글 ");
		coNumLeft.add(coNum);
		comentNum.add(coNumLeft, BorderLayout.WEST);
		pComPr.add(comentNum, BorderLayout.NORTH);

		JPanel pComPrSet=new JPanel(new GridLayout(2,1));	// 댓글출력묶음Set start
		pComPr.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 20 , 10)); //상하좌우 10씩 띄우기
//		pComPrSet.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder2));
		
		JPanel pComPrTop=new JPanel(new BorderLayout());	// 댓글출력 탑 패널	start	
		JPanel pComPrTopLeft=new JPanel(new BorderLayout());	// 탑-왼쪽
		tfCoPrId = new JTextField(10);	// 댓글아이디출력
		pComPrTopLeft.add(tfCoPrId);
		pComPrTop.add(pComPrTopLeft, BorderLayout.WEST);

		JPanel pComPrTopRight=new JPanel(new GridLayout(1,2));	// 탑-오른쪽
		JButton coCorrectBtn =new JButton("수정");	// 수정버튼
		pComPrTopRight.add(coCorrectBtn);
		JButton coDelBtn =new JButton("삭제");	// 삭제버튼
		pComPrTopRight.add(coDelBtn);
		pComPrTop.add(pComPrTopRight, BorderLayout.EAST);
		pComPrSet.add(pComPrTop);	// 댓글출력 탑 패널	end
		

		JPanel pComPrBtt=new JPanel(new BorderLayout());	// 댓글출력 바텀 패널	start	
		coPrTa=new JTextArea();	// 댓글내용출력
		pComPrBtt.add(coPrTa, BorderLayout.CENTER);	
		JButton coPrReCoTa=new JButton("답글");	// 댓글의 댓글출력
		pComPrBtt.add(coPrReCoTa, BorderLayout.EAST);
		pComPrSet.add(pComPrBtt);	// 댓글출력 바텀 패널	end
		
		pComPr.add(pComPrSet, BorderLayout.CENTER);
		pComPr.setVisible(false);
		pComent.add(pComPr, BorderLayout.CENTER);// 댓글출력묶음패널 end	
	          		
		

		allListP.add(pComent, BorderLayout.SOUTH);		// 댓글패널 end		
		
		add(new JScrollPane(allListP));
		setBounds(100,100,800,600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Sopj03();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		obj=e.getSource();
		
		if(obj==delBtn){
//			System.out.println("삭제하기 버튼입니다.");
//			delList();

			delCheck.setVisible(true);		
			
			
		}else if(obj==writeBtn){
			System.out.println("글쓰기 버튼입니다.");	
			new Sopj02();
			setVisible(false);		
		}
		
		if(obj==saveBtn){
			Comment();
		}
		
		
		if(obj==delchkBtn){
			System.out.println("아이디와 비밀번호가 일치하는 버튼을 눌렀습니다.");
			deleteFile();
		}
		
	}

}