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

	public void deleteFile() {	// �Խñ� ����        
		String getPwchk=deltfCoPw.getText();
		try {
			reader = new BufferedReader(new FileReader(fiPath));
			while ((str = reader.readLine()) != null) {
				list.add(str);
			}

			String getTit=(list.get(0)).toString();	// �Խñۿ� ����� ���� ��������
			String getPw=(list.get(3)).toString();	// �Խñۿ� ����� ��й�ȣ ��������
			if(getPwchk.equals(getPw)){
				System.out.println("���̵�� ��й�ȣ�� ��ġ�մϴ�. �Խñ��� �����մϴ�");
		        // ������ ��� + ���ϸ�
		        String filePath = "D:\\javaWork\\socketProject1\\shareBox\\"+getTit;
		        File deleteFile = new File(filePath);
		        // ������ �����ϴ��� üũ �����Ұ�� true, ��������������� false
		        if(deleteFile.exists()) {		            
		            // ������ �����մϴ�.		        	
					System.gc();
//					System.runFinalization();
					deleteFile.delete();
					
					dispose();
		            /// refresh ���ΰ�ħ	�̰Ǻ�й�ȣ
		            
					Sopj01 sp1=new Sopj01();

					this.removeAll();
					this.add(sp1);
					sp1.pContList.revalidate();
					sp1.pContList.repaint(); 
					sp1.setVisible(true);
					
//					
		            System.out.println("������ �����Ͽ����ϴ�.");
		            
		        } else {
		            System.out.println("������ �������� �ʽ��ϴ�.");
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
//		                log.info("{} >>> ��ΰ� �������� �ʽ��ϴ�.", targetFolder);
//		                return false;
//		            }
//		            
//		            File[] files = targetFolder.listFiles();
//		            for(File file : files) {
//		                if(file.isDirectory()) {
//		                    log.info("{} >>> ������ ���丮�Դϴ�. ���� ������ Ȯ���ϰڽ��ϴ�.", file);
//		                    deleteDirectoryAndFiles(file);
//		                }
//		                file.delete();
//		                log.info("{} >>> ������ �����Ǿ����ϴ�.", file);
//		            }
//		            
//		            return targetFolder.delete();
//		        }
		        
		        
		        
						    	
		    	
			}else{
				System.out.println("���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			}
			reader.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
        
 
        
    }

	public void Comment(){	// ��۵��
//      ������ ���
//      tfCoId - ���̵�
//      tfCoPw - ���
//      tfComt - ����
//      saveBtn - ��Ϲ�ư
//      --------------
//      ����� ���â
//      tfCoPrId - ���̵�
//      coPrTa - ��۳������
//      coPrTa.setEditable(false);   // ���� ���� �Ұ�
      System.out.println("��۵�� ��ư�Դϴ�.");
      
      String commId=tfCoId.getText();   // tfCoId - ����� ���̵�
      tfCoPrId.setText(commId);      // tfCoPrId - ��Ϲ��� ���̵�
      tfCoPrId.setEditable(false);
      tfCoId.setText("");
      
      tfCoPw.setText("");      // ���
      
      String commMsg=tfComt.getText();   // ����
      coPrTa.setText(commMsg);
      tfComt.setText("");
      coPrTa.setEditable(false);

      pComPr.setVisible(true);      

		
	}

	
	public Sopj03(){	// �Խñ� list�� ����
		allListP=new JPanel(new BorderLayout());	// ��ü�г�
		
		JPanel listCoP=new JPanel();	// �Խñ۳��� ��ü�г� start
		listCoP.setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {		// p�г� â�ݱ�
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
		
		try {
			reader = new BufferedReader(new FileReader(fiPath));
			while ((str = reader.readLine()) != null) {
				list.add(str);
			}
			tLa2[0].setText((list.get(0)).toString());	// topBp - ����
			tLa2[1].setText((list.get(1)).toString());	// topBp - �ۼ���
			tLa2[2].setText((list.get(2)).toString());	// topBp - ��¥
			ta.setText((list.get(4)).toString());		// pBtt - ����
			ta.setEditable(false);	// ���� ���� �Ұ�
			reader.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		JPanel pBttBtn=new JPanel(new BorderLayout());	// ���� ��ư�г� start
		pBttBtn.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 40 , 10)); //�����¿� 10�� ����
		
		JPanel pBBTop=new JPanel(new BorderLayout());	// ����-ž ��ư�г� start		
		delBtn=new JButton("�����ϱ�");	// �����ϱ� ��ư
		delBtn.setFont(topTitf2);
		delBtn.setForeground(Color.WHITE);	// j�� font������
		delBtn.setBackground(Color.DARK_GRAY);
		delBtn.addActionListener(this);
		pBBTop.add(delBtn, BorderLayout.WEST);
		
		writeBtn=new JButton("�۾���");	// �۾��� ��ư
		writeBtn.setFont(topTitf2);
		writeBtn.setForeground(Color.WHITE);	// j�� font������
		writeBtn.setBackground(Color.DARK_GRAY);
		writeBtn.addActionListener(this);
		pBBTop.add(writeBtn, BorderLayout.EAST);
		pBttBtn.add(pBBTop, BorderLayout.NORTH);	// ����-ž ��ư�г� end
		

		JPanel pBBBtt=new JPanel(new BorderLayout());	// ����-���� ��ư�г� start		
		delCheck=new JPanel(new GridLayout(2,1));
		delCheck.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 10 , 0)); //�����¿� 10�� ����
		JPanel delIdPw=new JPanel(new GridLayout(1,4));		// ���̵�-��� �г�
		JLabel delcoLa1=new JLabel("�ۼ��� ���̵�");
		delcoLa1.setForeground(Color.WHITE);	// j�� font������
		delcoLa1.setBackground(Color.DARK_GRAY);
		delcoLa1.setHorizontalAlignment(JLabel.CENTER);
		delcoLa1.setOpaque(true);
		delIdPw.add(delcoLa1);
		JTextField deltfCoId = new JTextField();	// ��۾��̵�
		deltfCoId.setText(tLa2[1].getText());
		deltfCoId.setEditable(false);	// ���� ���� �Ұ�
		delIdPw.add(deltfCoId);
		JLabel delcoLa2=new JLabel("�ۼ��� ���");
		delcoLa2.setForeground(Color.WHITE);	// j�� font������
		delcoLa2.setBackground(Color.DARK_GRAY);
		delcoLa2.setOpaque(true);
		delcoLa2.setHorizontalAlignment(JLabel.CENTER);
		delIdPw.add(delcoLa2);
		deltfCoPw = new JTextField();	// ��ۺ��
		delIdPw.add(deltfCoPw);
		delCheck.add(delIdPw);	
		
		JPanel delChk=new JPanel(new BorderLayout());		// ���̵�-��� Ȯ�ι�ư �г�
		delchkBtn=new JButton("Ȯ��");
		delchkBtn.addActionListener(this);
		delChk.add(delchkBtn, BorderLayout.EAST);
		delCheck.add(delChk);	

		pBBBtt.add(delCheck);
		delCheck.setVisible(false);
		pBttBtn.add(pBBBtt, BorderLayout.SOUTH);	// ����-���� ��ư�г� end
		
		listCoP.add(pBttBtn, BorderLayout.SOUTH);	// ���� ��ư�г� end			
		allListP.add(listCoP, BorderLayout.CENTER);	// �Խñ۳��� ��ü�г� end
		
		
		
		/////// ���
		JPanel pComent=new JPanel(new BorderLayout());	// ����г� start	
		
		////����ۼ�����
		JPanel pcoSet=new JPanel(new GridLayout(3,1));	// ����ۼ����� �г� start	
		pcoSet.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10)); //�����¿� 10�� ����
//		pcoSet.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder2));
		JPanel pcoSetTop=new JPanel(new GridLayout(1,4));
		JLabel coLa1=new JLabel("���̵�");
		coLa1.setForeground(Color.WHITE);	// j�� font������
		coLa1.setBackground(Color.DARK_GRAY);
		coLa1.setHorizontalAlignment(JLabel.CENTER);
		coLa1.setOpaque(true);
		pcoSetTop.add(coLa1);
		tfCoId = new JTextField();	// ��۾��̵�
		pcoSetTop.add(tfCoId);
		JLabel coLa2=new JLabel("���");
		coLa2.setForeground(Color.WHITE);	// j�� font������
		coLa2.setBackground(Color.DARK_GRAY);
		coLa2.setOpaque(true);
		coLa2.setHorizontalAlignment(JLabel.CENTER);
		pcoSetTop.add(coLa2);
		tfCoPw = new JPasswordField();	// ��ۺ��
		tfCoPw.setEchoChar('*');
		pcoSetTop.add(tfCoPw);
		pcoSet.add(pcoSetTop);
		
		JPanel pBcoSetBtt=new JPanel(new GridLayout(1,1));
		tfComt = new JTextField();	// ��۳���
		pBcoSetBtt.add(tfComt);
		pcoSet.add(pBcoSetBtt);	
		
		JPanel pBcoSetSaveBtn=new JPanel(new BorderLayout());	// ��� �����ư
		saveBtn=new JButton("���");
		saveBtn.addActionListener(this);
		pBcoSetSaveBtn.add(saveBtn, BorderLayout.EAST);
		pcoSet.add(pBcoSetSaveBtn);	
		pComent.add(pcoSet, BorderLayout.NORTH);		// ����ۼ����� �г� end	
		
		
		////�����¹����г�		
		pComPr=new JPanel(new BorderLayout());	// �����¹����г� start
		pComPr.setBorder(BorderFactory.createCompoundBorder(lineBorder2, emptyBorder3));
		
		JPanel comentNum=new JPanel(new BorderLayout());	// ��� ������Ȳ
		comentNum.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10)); //�����¿� 10�� ����
		JPanel coNumLeft=new JPanel();		
		JLabel coNum=new JLabel("��� ");
		coNumLeft.add(coNum);
		comentNum.add(coNumLeft, BorderLayout.WEST);
		pComPr.add(comentNum, BorderLayout.NORTH);

		JPanel pComPrSet=new JPanel(new GridLayout(2,1));	// �����¹���Set start
		pComPr.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 20 , 10)); //�����¿� 10�� ����
//		pComPrSet.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder2));
		
		JPanel pComPrTop=new JPanel(new BorderLayout());	// ������ ž �г�	start	
		JPanel pComPrTopLeft=new JPanel(new BorderLayout());	// ž-����
		tfCoPrId = new JTextField(10);	// ��۾��̵����
		pComPrTopLeft.add(tfCoPrId);
		pComPrTop.add(pComPrTopLeft, BorderLayout.WEST);

		JPanel pComPrTopRight=new JPanel(new GridLayout(1,2));	// ž-������
		JButton coCorrectBtn =new JButton("����");	// ������ư
		pComPrTopRight.add(coCorrectBtn);
		JButton coDelBtn =new JButton("����");	// ������ư
		pComPrTopRight.add(coDelBtn);
		pComPrTop.add(pComPrTopRight, BorderLayout.EAST);
		pComPrSet.add(pComPrTop);	// ������ ž �г�	end
		

		JPanel pComPrBtt=new JPanel(new BorderLayout());	// ������ ���� �г�	start	
		coPrTa=new JTextArea();	// ��۳������
		pComPrBtt.add(coPrTa, BorderLayout.CENTER);	
		JButton coPrReCoTa=new JButton("���");	// ����� ������
		pComPrBtt.add(coPrReCoTa, BorderLayout.EAST);
		pComPrSet.add(pComPrBtt);	// ������ ���� �г�	end
		
		pComPr.add(pComPrSet, BorderLayout.CENTER);
		pComPr.setVisible(false);
		pComent.add(pComPr, BorderLayout.CENTER);// �����¹����г� end	
	          		
		

		allListP.add(pComent, BorderLayout.SOUTH);		// ����г� end		
		
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
//			System.out.println("�����ϱ� ��ư�Դϴ�.");
//			delList();

			delCheck.setVisible(true);		
			
			
		}else if(obj==writeBtn){
			System.out.println("�۾��� ��ư�Դϴ�.");	
			new Sopj02();
			setVisible(false);		
		}
		
		if(obj==saveBtn){
			Comment();
		}
		
		
		if(obj==delchkBtn){
			System.out.println("���̵�� ��й�ȣ�� ��ġ�ϴ� ��ư�� �������ϴ�.");
			deleteFile();
		}
		
	}

}