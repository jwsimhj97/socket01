package soc.pj;
//글쓰기창

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Sopj02 extends Frame implements ActionListener{

	static MenuItem mi1,mi2,mi3,mi4,mi5;
	static TextField tfId,tfPw,taTitle;
	TextArea ta;
	String title="제목없음";
	
	
	public Sopj02(){
		Panel p=new Panel();
		p.setLayout(new BorderLayout());
//		p.setLayout(new GridLayout(2,1));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		MenuBar bar=new MenuBar();
		Menu mn1=new Menu("파일");
		Menu mn2=new Menu("도움말");
		bar.add(mn1);
		bar.add(mn2);
		mi1=new MenuItem("새파일");
		mi3=new MenuItem("저장");
		mi4=new MenuItem("취소");
		mi5=new MenuItem("정보");
		mn1.add(mi1);
		mn1.addSeparator();
		mn1.add(mi3);
		mn1.addSeparator();
		mn1.add(mi4);
		mn2.add(mi5);		
		mi1.addActionListener(this);	
		mi3.addActionListener(this);	
		mi4.addActionListener(this);		
		mi5.addActionListener(this);			
		setTitle(title);
		setMenuBar(bar);
		
		Font f=new Font(Font.SANS_SERIF, Font.PLAIN, 16);
		
		JPanel p1=new JPanel();	// 아이디비번패널
		p1.setLayout(new GridLayout(1,4));
		
		JLabel laId=new JLabel("아이디 >>");
		laId.setHorizontalAlignment(JLabel.CENTER);
		laId.setForeground(Color.WHITE);	// j라벨 font색변경
		laId.setBackground(Color.DARK_GRAY);
		laId.setOpaque(true);
		tfId=new TextField();		
		
		JLabel laPw=new JLabel("비밀번호 >>");
		laPw.setHorizontalAlignment(JLabel.CENTER);
		laPw.setForeground(Color.WHITE);	// j라벨 font색변경
		laPw.setBackground(Color.DARK_GRAY);
		laPw.setOpaque(true);        
		tfPw=new TextField();
		tfPw.setEchoChar('*');
		
		p1.add(laId);
		p1.add(tfId);
		p1.add(laPw);
		p1.add(tfPw);
		p1.setFont(f);
		p.add(p1, BorderLayout.NORTH);
		
		
		JPanel p2=new JPanel();	// 제목패널
		p2.setLayout(new BorderLayout());
//		p2.setLayout(new GridLayout(1,4));
		JLabel laTitle=new JLabel("  제목 >>  ");
		laTitle.setHorizontalAlignment(JLabel.CENTER);
		laTitle.setForeground(Color.WHITE);	// j라벨 font색변경
		laTitle.setBackground(Color.DARK_GRAY);
		laTitle.setOpaque(true);
		taTitle = new TextField();
		p2.add(laTitle, BorderLayout.WEST);
		p2.add(taTitle, BorderLayout.CENTER);
		p2.setFont(f);
		p.add(p2, BorderLayout.CENTER);
		
		
		Panel p3=new Panel();	// 내용패널
		p3.setLayout(new GridLayout(1,1));
		ta=new TextArea();
		p3.add(ta);
		p.add(p3, BorderLayout.SOUTH);
		
		
		
		add(p);
		setBounds(100, 100, 600, 400);
		setVisible(true);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==mi1){
			tfId.setText("초기화");
			tfId.setText("");
			tfPw.setText("초기화");
			tfPw.setText("");
			taTitle.setText("초기화");
			taTitle.setText("");
			ta.setText("초기화");
			ta.setText("");
			this.setTitle(title);
		}else if(obj==mi3){
			dispose();
			System.out.println("저장");
			
			title=taTitle.getText();	// 제목
			this.setTitle(title);
			
			File file=new File(".\\shareBox\\"+taTitle.getText());
			System.out.println(file);
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}	
			String idSt=tfId.getText();	// id
			String idPw=tfPw.getText();	// pw
			String fileName=taTitle.getText();	// 파일이름 (제목)
			///날짜
			GregorianCalendar gc = new GregorianCalendar();
	        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	        Date d = gc.getTime();
	        String wrDate = sf.format(d).substring(0,4)+"-"+sf.format(d).substring(4,6)+"-"+sf.format(d).subSequence(6, 8);
	        
			
			
			String msg=ta.getText();	// 내용
//			String idtt="아이디 : ";
//			String pwtt="비밀번호 : ";
//			String fileNamett="제목 : ";
//			String msgtt="내용 : ";
			try {
				FileOutputStream out=new java.io.FileOutputStream(file);
				byte[] arridSt=idSt.getBytes();	// id
				byte[] arridPw=idPw.getBytes();	// pw
				byte[] arrFiName=fileName.getBytes();	// 제목
				byte[] arrDate=wrDate.getBytes();	// 날짜
				byte[] arrMsg=msg.getBytes();	// 내용
//				for(int i=0; i<arridSt2.length; i++){	// id
//					out.write(arridSt2[i]);
//				};
				for(int i=0; i<arrFiName.length; i++){	// 제목
					out.write(arrFiName[i]);
				};
		        out.write('\n');    // 줄바꿈
				for(int i=0; i<arridSt.length; i++){	// id
					out.write(arridSt[i]);
				};
		        out.write('\n');    // 줄바꿈
				for(int i=0; i<arrDate.length; i++){	// 날짜
					out.write(arrDate[i]);
				};
		        out.write('\n');    // 줄바꿈
				for(int i=0; i<arridPw.length; i++){	// pw
					out.write(arridPw[i]);
				};
		        out.write('\n');    // 줄바꿈
				for(int i=0; i<arrMsg.length; i++){		// 내용
					out.write(arrMsg[i]);
				};				
				out.close();
				System.out.println("작성완료");
				

                
				/// refresh 새로고침
				Sopj01 sp1=new Sopj01();
				this.removeAll();
				this.add(sp1);
				sp1.pContList.revalidate();
				sp1.pContList.repaint();
				sp1.setVisible(true);
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(obj==mi4){
			dispose();
			
			new Sopj01();
			
		}else if(obj==mi5){
			Dialog dia=new Dialog(this,"정보",true);
			dia.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
//					dispose();
					dia.setVisible(false); 
				}
			});
			Panel p=new Panel();
			Panel p2=new Panel();
			p2.setLayout(new GridLayout(4,1));
			p2.add(new Label("1. 작성할 문서의 일회성 아이디와 비밀번호를 넣고, 제목과 내용을 작성합니다."));
			p2.add(new Label("2. 작성이 완료되면 상단메뉴바의 파일-저장 버튼을 눌러 문서를 저장할 수 있습니다."));
			p2.add(new Label("3. 파일-새파일 버튼은 작성하던 내용을 삭제해줍니다."));
			p2.add(new Label("4. 파일-취소 버튼은 작성하던 내용을 취소하고 창을 닫습니다."));
			p.setLayout(new BorderLayout());
			p.add(p2,BorderLayout.CENTER);
			Button btn=new Button("확인");
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dia.dispose();
				}			
			});
			p.add(btn,BorderLayout.SOUTH);
			dia.add(p);
			dia.setBounds(150, 150, 500, 200);
			dia.setVisible(true);
		}
	}

}
