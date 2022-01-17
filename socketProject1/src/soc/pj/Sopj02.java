package soc.pj;
//�۾���â

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
	String title="�������";
	
	
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
		Menu mn1=new Menu("����");
		Menu mn2=new Menu("����");
		bar.add(mn1);
		bar.add(mn2);
		mi1=new MenuItem("������");
		mi3=new MenuItem("����");
		mi4=new MenuItem("���");
		mi5=new MenuItem("����");
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
		
		JPanel p1=new JPanel();	// ���̵����г�
		p1.setLayout(new GridLayout(1,4));
		
		JLabel laId=new JLabel("���̵� >>");
		laId.setHorizontalAlignment(JLabel.CENTER);
		laId.setForeground(Color.WHITE);	// j�� font������
		laId.setBackground(Color.DARK_GRAY);
		laId.setOpaque(true);
		tfId=new TextField();		
		
		JLabel laPw=new JLabel("��й�ȣ >>");
		laPw.setHorizontalAlignment(JLabel.CENTER);
		laPw.setForeground(Color.WHITE);	// j�� font������
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
		
		
		JPanel p2=new JPanel();	// �����г�
		p2.setLayout(new BorderLayout());
//		p2.setLayout(new GridLayout(1,4));
		JLabel laTitle=new JLabel("  ���� >>  ");
		laTitle.setHorizontalAlignment(JLabel.CENTER);
		laTitle.setForeground(Color.WHITE);	// j�� font������
		laTitle.setBackground(Color.DARK_GRAY);
		laTitle.setOpaque(true);
		taTitle = new TextField();
		p2.add(laTitle, BorderLayout.WEST);
		p2.add(taTitle, BorderLayout.CENTER);
		p2.setFont(f);
		p.add(p2, BorderLayout.CENTER);
		
		
		Panel p3=new Panel();	// �����г�
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
			tfId.setText("�ʱ�ȭ");
			tfId.setText("");
			tfPw.setText("�ʱ�ȭ");
			tfPw.setText("");
			taTitle.setText("�ʱ�ȭ");
			taTitle.setText("");
			ta.setText("�ʱ�ȭ");
			ta.setText("");
			this.setTitle(title);
		}else if(obj==mi3){
			dispose();
			System.out.println("����");
			
			title=taTitle.getText();	// ����
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
			String fileName=taTitle.getText();	// �����̸� (����)
			///��¥
			GregorianCalendar gc = new GregorianCalendar();
	        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	        Date d = gc.getTime();
	        String wrDate = sf.format(d).substring(0,4)+"-"+sf.format(d).substring(4,6)+"-"+sf.format(d).subSequence(6, 8);
	        
			
			
			String msg=ta.getText();	// ����
//			String idtt="���̵� : ";
//			String pwtt="��й�ȣ : ";
//			String fileNamett="���� : ";
//			String msgtt="���� : ";
			try {
				FileOutputStream out=new java.io.FileOutputStream(file);
				byte[] arridSt=idSt.getBytes();	// id
				byte[] arridPw=idPw.getBytes();	// pw
				byte[] arrFiName=fileName.getBytes();	// ����
				byte[] arrDate=wrDate.getBytes();	// ��¥
				byte[] arrMsg=msg.getBytes();	// ����
//				for(int i=0; i<arridSt2.length; i++){	// id
//					out.write(arridSt2[i]);
//				};
				for(int i=0; i<arrFiName.length; i++){	// ����
					out.write(arrFiName[i]);
				};
		        out.write('\n');    // �ٹٲ�
				for(int i=0; i<arridSt.length; i++){	// id
					out.write(arridSt[i]);
				};
		        out.write('\n');    // �ٹٲ�
				for(int i=0; i<arrDate.length; i++){	// ��¥
					out.write(arrDate[i]);
				};
		        out.write('\n');    // �ٹٲ�
				for(int i=0; i<arridPw.length; i++){	// pw
					out.write(arridPw[i]);
				};
		        out.write('\n');    // �ٹٲ�
				for(int i=0; i<arrMsg.length; i++){		// ����
					out.write(arrMsg[i]);
				};				
				out.close();
				System.out.println("�ۼ��Ϸ�");
				

                
				/// refresh ���ΰ�ħ
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
			Dialog dia=new Dialog(this,"����",true);
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
			p2.add(new Label("1. �ۼ��� ������ ��ȸ�� ���̵�� ��й�ȣ�� �ְ�, ����� ������ �ۼ��մϴ�."));
			p2.add(new Label("2. �ۼ��� �Ϸ�Ǹ� ��ܸ޴����� ����-���� ��ư�� ���� ������ ������ �� �ֽ��ϴ�."));
			p2.add(new Label("3. ����-������ ��ư�� �ۼ��ϴ� ������ �������ݴϴ�."));
			p2.add(new Label("4. ����-��� ��ư�� �ۼ��ϴ� ������ ����ϰ� â�� �ݽ��ϴ�."));
			p.setLayout(new BorderLayout());
			p.add(p2,BorderLayout.CENTER);
			Button btn=new Button("Ȯ��");
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
