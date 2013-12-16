package com.cpseeker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main 
{
	private static final Logger logger = LoggerFactory.getLogger("main");
	public static void main(String[] args) 
	{
		logger.trace("Program start");
		long start = System.currentTimeMillis();
		CommandLineInterface cli = new CommandLineInterface(args);
		cli.start();
		long end = System.currentTimeMillis();
		logger.trace("Program end");
		logger.info("Time elasped(ms): {}", end - start);
	}
}
