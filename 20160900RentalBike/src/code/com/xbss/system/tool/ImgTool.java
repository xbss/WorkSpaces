package com.xbss.system.tool;

public class ImgTool {
	
	static String imgPath = SystemConfig.getSystemPram("imgPath");
	
	public static String  getImgPath(String imgName){
		return imgPath + imgName;
	}

}
