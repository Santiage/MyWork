package org.santiage.Crawler;

import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class Http_analysis {
	

	private ArrayList<String> http_links = new ArrayList<String>();
	private ArrayList<String> jpeg_links = new ArrayList<String>();

	
	
	public Http_analysis ()
	{
		
	}
	
	public int analysis_data (InputStream is)
	{
		InputStreamReader ir = new InputStreamReader (is);
		BufferedReader br = new BufferedReader (ir);
		String tmpline = null;
		
		do{
			try {
				tmpline = br.readLine();
				if (tmpline == null)
					break;
				
				if(tmpline.contains("<a"))
				{
					String tmpbuf = new String();
					int tmpn1, tmpn2;
					
					tmpn1 = tmpline.indexOf("href=\"") + 6;
					tmpn2 = tmpline.indexOf("\"", tmpn1);
					tmpbuf = tmpline.substring(tmpn1, tmpn2);
					http_links.add(tmpbuf);
//					System.out.println(tmpline);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while (true);
		
//		for (int i = 0; i < aaa.size(); i++)
//		{
//			System.out.println(aaa.get(i));
//		}
		
		
		return 0;
	}
	
	public ArrayList<String> get_http_links ()
	{
		return http_links;
	}

}
