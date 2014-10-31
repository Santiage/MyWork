package org.santiage.Crawler;

import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class Http_analysis {
	

	public ArrayList<String> http_links = new ArrayList<String>();
	private ArrayList<String> jpeg_links = new ArrayList<String>();
	private String head_url = new String();

	
	
	public Http_analysis ()
	{
		
	}
	
	public int analysis_data (InputStream is)
	{		
		InputStreamReader ir = new InputStreamReader (is);
		BufferedReader br = new BufferedReader (ir);
		String tmpline = null;
		
		int tmpn1, tmpn2;
		
		do{
			try {
				tmpline = br.readLine();
				if (tmpline == null)
					break;
				
				if(tmpline.contains("<div"))
				{
					String tmpbuf = new String();
					
					String tid = new String();
					String uid = new String();
					
					tmpbuf += tmpline;
					while (true)
					{
						tmpline = br.readLine();
						if (tmpline.contains("</div>"))
						{
							tmpbuf += tmpline;
							break;
						}
						else
							tmpbuf += tmpline;
						
					}
					
					// get http_links from tmpline;
					tmpn1 = tmpbuf.indexOf("tid=");
					tmpn2 = tmpbuf.indexOf("&", tmpn1);
					if (tmpn1 == -1 || tmpn2 == -1)
						continue;
					tid = tmpbuf.substring(tmpn1 + 4, tmpn2);
					tmpn1 = tmpbuf.indexOf("uid=");
					tmpn2 = tmpbuf.indexOf("&", tmpn1);
					if (tmpn1 == -1 || tmpn2 == -1)
						continue;
					uid = tmpbuf.substring(tmpn1 + 4, tmpn2);
					
					String suburl = new String();
//					suburl.format("f%s%s.html", tid, uid);
					suburl = "http://www.3412mm.com/" + "f" + tid + uid + ".html";
					System.out.println(suburl);
					
					http_links.add(suburl);
					
//					System.out.println(tmpline);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while (true);
		
		for (int i = 0; i < http_links.size(); i++)
		{
			System.out.println(http_links.get(i));
		}
		
		
		return 0;
	}
	
	public ArrayList<String> get_http_links ()
	{
		return http_links;
	}
	
	public String get_picture (InputStream subis)
	{
		String strret = null;
		InputStreamReader ir = new InputStreamReader (subis);
		BufferedReader br = new BufferedReader (ir);
		String tmpline = null;
		
		do{
			try {
				tmpline = br.readLine();
				if (tmpline == null)
					break;

//				System.out.println(tmpline);
				if (tmpline.contains("<a"))
				{
					int tmpn1, tmpn2;
					String tmpbuf;
					
					tmpn1 = tmpline.indexOf("href=\"");
					tmpn2 = tmpline.indexOf("\"", tmpn1 + 6);
					if (tmpn1 == -1 || tmpn2 == -1)
						continue;
					tmpbuf = tmpline.substring(tmpn1 + 6, tmpn2);
					
					if (!tmpbuf.contains(".jpg"))
							continue;
					tmpbuf = "http://www.3412mm.com/" + tmpbuf;
					jpeg_links.add (tmpbuf);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while (true);
		
		
		for (int i = 0; i < http_links.size(); i++)
		{
			System.out.println(jpeg_links.get(i));
			String imgUrl = jpeg_links.get(i);
			URL imgurl = null;
			HttpURLConnection imghc = null;
			InputStream imgis = null;
			
			try {
				imgurl = new URL(imgUrl);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				imghc = (HttpURLConnection) imgurl.openConnection ();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				imgis = imghc.getInputStream();
				int nc = jpeg_links.get(i).lastIndexOf("/");
				String fn = jpeg_links.get(i).substring(nc, jpeg_links.get(i).length());
				File ff = new File(fn);
				FileOutStrem
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return strret;
	}

}
