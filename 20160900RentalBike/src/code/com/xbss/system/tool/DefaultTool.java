package com.xbss.system.tool;

public class DefaultTool {
	
	static String defaultComponentID=SystemConfig.getSystemPram("defaultComponentID");
	
	public static String getDefaultComponentID(){
		return defaultComponentID;
	}
	
}
