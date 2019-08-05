package org.first;

import org.apache.log4j.BasicConfigurator;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

public class Class3 {
	private final Logger logger = Logger.getLogger(Class3.class.getName());
	public void method3() {
		Class2 class2 = new Class2();
		
		try {
			class2.method2();
		} catch (Exception e) {
			BasicConfigurator.configure();
	    	logger.debug("Hello world.");
	    	logger.info("What a beatiful day.");
			
		}
		
	}
}
