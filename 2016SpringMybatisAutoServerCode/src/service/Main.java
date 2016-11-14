package service;

public class Main {

	public static void main(String[] args) {
		
		CreatorService service = new CreatorService();
		// 本地存储位置
		String targetDiskPth = "E:\\Documents\\办公文档\\其他类\\桌面\\RentalBike";
		// xml扫描文件夹
		String targetXML = "src/rentalBike/CompensationRecord.xml";
		service.createInPath(targetXML, targetDiskPth);
	}
}
