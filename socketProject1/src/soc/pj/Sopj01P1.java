package soc.pj;
// main 창

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Sopj01P1 extends Frame implements ActionListener{
	JButton delBtn,creBtn;
	
	public Sopj01P1(){
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		Panel p=new Panel();
		p.setLayout(new BorderLayout());
		
		Border border = LineBorder.createGrayLineBorder();

		Font f=new Font("SansSerif", Font.BOLD,30);	
		
		Panel pTitle=new Panel();
		p.add(pTitle, BorderLayout.NORTH);
//		pTitle.setLayout(new GridLayout(1,1));	
		Label laTitle=new Label("IDEA SHARE BOX");		
		laTitle.setFont(f);
		pTitle.add(laTitle);

		Font f2=new Font("SansSerif", Font.PLAIN,18);	
		Panel pList=new Panel();
		p.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout());
		Panel pListTitle=new Panel();
		pList.add(pListTitle, BorderLayout.NORTH);
//		pListTitle.setLayout(new GridLayout(1,4));
		pListTitle.setLayout(new GridBagLayout());
		JLabel listT1=new JLabel("No.");
		JLabel listT2=new JLabel("제목");
		JLabel listT3=new JLabel("작성자");
		JLabel listT4=new JLabel("날짜");		
		gbc.weightx=0.5;
		listT1.setFont(f2);
		pListTitle.add(listT1,gbc);
		listT1.setHorizontalAlignment(JLabel.CENTER);
		listT1.setBorder(border);
		
		gbc.weightx=3.0;
		gbc.gridx=1;
		listT2.setFont(f2);
		pListTitle.add(listT2,gbc);
		listT2.setHorizontalAlignment(JLabel.CENTER);
		listT2.setBorder(border);
		
		gbc.weightx=0.5;
		gbc.gridx=2;
		listT3.setFont(f2);
		pListTitle.add(listT3,gbc);
		listT3.setHorizontalAlignment(JLabel.CENTER);
		listT3.setBorder(border);
		
		gbc.weightx=1.0;
		gbc.gridx=3;
		listT4.setFont(f2);
		pListTitle.add(listT4,gbc);
		listT4.setHorizontalAlignment(JLabel.CENTER);
		listT4.setBorder(border);
		
		Panel pListContent=new Panel();
		pList.add(pListContent, BorderLayout.CENTER);
		
		Panel pBottom=new Panel();
		p.add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(1,4));
		delBtn=new JButton("삭제하기");
		delBtn.addActionListener(this);
		creBtn=new JButton("글쓰기");
		creBtn.addActionListener(this);
		delBtn.setFont(f2);	
		creBtn.setFont(f2);
		pBottom.add(delBtn);
		pBottom.add(new Label());
		pBottom.add(new Label());
		pBottom.add(creBtn);
		
		
		add(p);
		setBounds(200, 100, 800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Sopj01P1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==creBtn){
			new Sopj02();
//			System.out.println("글쓰기버튼을 누름");
		}else if(obj==delBtn){
			System.out.println("삭제하기버튼을 누름");
		}
		
	}

}
