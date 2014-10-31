package org.santiage.Crawler_3412;

import org.santiage.Crawler.Crawler_Engine;

public class Main {

	public static void main (String[] args)
	{
		System.out.println ("enter main function.");

		Crawler_Engine CE = new Crawler_Engine ("http://www.3412mm.com/mm391.html");
		CE.run();

	}
}
