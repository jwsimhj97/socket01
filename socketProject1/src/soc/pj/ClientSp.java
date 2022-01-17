package soc.pj;

import java.io.*;
import java.net.*;

public class ClientSp {

	public static void main(String[] args) {
		String ip="127.0.0.1";
		int port=5001;	//
		Socket sock=null;
		InputStream is=null;
		InputStreamReader isr=null;
		try {
			sock=new Socket(ip, port);
//			System.out.println("client> 접속요청했습니다");
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			int su=-1;
			while((su=isr.read())!=-1){
				System.out.print((char)su);
			}

			new Sopj01();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				isr.close();
				is.close();
				sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
