package org.santiage.Crawler.tester;

import org.santiage.Crawler.Crawler_Engine;

public class Main 
{

	public static Crawler_Engine CE = null;


	public static void main (String[] args)
	{
		System.out.println ("enter main function.");

		CE = new Crawler_Engine ("http://www.cankaoxiaoxi.com");
		CE.run();

	}

}
