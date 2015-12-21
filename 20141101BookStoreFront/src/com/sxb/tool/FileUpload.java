package com.sxb.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.sxb.service.GoodService;
import com.sxb.service.IService;
import com.sxb.service.OperatorService;
import com.sxb.service.UserService;

/**
 * 
 * @author 小小镔
 * @Title 处理图片上传
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 需要图片上传的操作业务层
	private OperatorService operatorService = new OperatorService();
	private UserService userService = new UserService();
	private GoodService goodService = new GoodService();
	// 字节流
	private File file;
	private FileOutputStream outputStream;
	// 图片文件路径
	private String photoPath ="";
	// 操作对象
	private IService iService;
	private String objectName = "";
	private String objectID = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 判断是否是图片上传的请求
		boolean isUploadFile = ServletFileUpload.isMultipartContent(req);
		if (isUploadFile) {
			try {
				// 文件写入操作
				ServletFileUpload upload = new ServletFileUpload();
				FileItemIterator iterator = upload.getItemIterator(req);
				byte buffer[] = new byte[1024];
				while(iterator.hasNext()){
					FileItemStream item = iterator.next();
					String name = item.getFieldName();
					InputStream input = item.openStream();
					// 判断是否是file字段，如果是就写入文件
					if (item.isFormField()) {
						String sNameString = Streams.asString(input);
						System.out.println("From field: " + name + " value " + sNameString);
					} else {
						System.out.println("File field: " + name + " value " + item.getName());
						// 更新图片路径
						photoPath = item.getName();
						// 获取文件类型
						int indexOfFileType = photoPath.lastIndexOf(".");
						String fileType = photoPath.substring(indexOfFileType + 1);
						// 使用上传时间来命名文件
						String fileName = IDFactory.createId() + fileType;
						// 判断是上传图片的具体操作对象
						objectName = fileToObject(req);
						// 创建新文件
						file = new File(SysConfig.HEAD_UPLOAD +File.separator + File.separator + objectName +fileName);
						// 再次更新图片的路径
						photoPath = fileName;
						// 覆盖文件
						if (file.exists()) {
							file.createNewFile();
						}
						// 使用字节流写入服务器
						outputStream = new FileOutputStream(file);
						int byteTemp;
						while((byteTemp = input.read(buffer)) != -1){
							outputStream.write(buffer, 0, byteTemp);
						}
						// 关闭字节流
						outputStream.flush();
						outputStream.close();
						input.close();
					}
				}
				// 调用接口方法更新数据到数据库
				iService.uploadPhoto(objectID, photoPath);
			} catch (Exception e) {
				// 捕获到异常就删除文件并关闭字节流
				String waringString = "上传图片出错，删除写入的文件！";
				System.out.println("DEBUG: " + waringString);
				try {
					if (file.exists()) {
						file.delete();
					}
					outputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	// 判断图片的存取对象
	public String fileToObject(HttpServletRequest request){
		String toObject = request.getParameter("toObject");
		System.out.println("DEBUG:" + "上传的操作对象是" + toObject);
		objectID = request.getParameter("ID");
		if (toObject.equals("Operator") || toObject.equals("operator")) {
			objectName = "Operator";
			iService = operatorService;
		}
		if (toObject.equals("User") || toObject.equals("user")) {
			objectName = "User";
			iService = userService;
		}
		if (toObject.equals("Good") || toObject.equals("good")) {
			objectName = "Good";
			iService = goodService;
		}
		return toObject;
	}

}
