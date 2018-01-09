package com.xbss.system.log;

import org.apache.log4j.Logger;


public class LogTool implements ILogTool {
	
	Logger logger;
	
	public LogTool(Class<?> clazz) {
		logger  =  Logger.getLogger(clazz);
	}
	
	public void  error(Object message) {
		logger.error(message);
	}
}
