package org.santiage.Crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.htmlparser.Parser;
import org.htmlparser.visitors.HtmlPage;

public class Crawler_Engine // implements Runnable
{
	
	Http_analysis ha = new Http_analysis ();

	private String ms_start_url = null;
	
	public Crawler_Engine ()
	{

	}

	public Crawler_Engine (String start_url)
	{
		this.SetStartUrl (start_url);
	}


	public int SetStartUrl (String start_url)
	{
		ms_start_url = start_url;
		return 0;
	}

	public void run() {
		// TODO Auto-generated method stub
		HttpURLConnection hc = null;
		InputStream is = null;
		
		if (ms_start_url == null)
			return ;

		String currentUrl = ms_start_url;
		URL url = null;
		try {
			url = new URL(currentUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			hc = (HttpURLConnection) url.openConnection ();
			is = hc.getInputStream ();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(hc.InputStream()));
		ha.input_data(is);
		
		
	}

}
