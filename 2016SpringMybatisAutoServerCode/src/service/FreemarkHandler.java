package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Entity;
import entity.Field;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkHandler {
	//处理模板
	Configuration config ;

	public FreemarkHandler() {
		config = new Configuration();
		config.setClassForTemplateLoading(this.getClass() , "/template" ); //指定模板所在的classpath目录   
	}
	
	
	public void createCode(Entity entity,String exportPath) throws IOException, TemplateException{
		System.out.println("生成 ：" + entity.getClassName());
		
        Map<String, Object> data = getData(entity);		//得到源数据
        

        //生成entity
        OutputStreamWriter entityWriter = new OutputStreamWriter(
        		new FileOutputStream(createEntityFile(entity,exportPath)), "utf-8");
        config.getTemplate("Entity.temp" ).process(data, entityWriter);
        entityWriter.close();
        
        //生成dao
        OutputStreamWriter daoWriter = new OutputStreamWriter(
        		new FileOutputStream(createDaoFile(entity,exportPath)), "utf-8");
        config.getTemplate("Dao.temp" ).process(data, daoWriter);
        daoWriter.close();
        
        //生成 Mapper
        OutputStreamWriter mapperWrite = new OutputStreamWriter(
        		new FileOutputStream(createMapperFile(entity,exportPath)), "utf-8");
        config.getTemplate("Mapper.temp" ).process(data,mapperWrite );
        mapperWrite.close();
        
        //生成IService
        OutputStreamWriter IServiceWrite = new OutputStreamWriter(
        		new FileOutputStream(createIServiceFile(entity,exportPath)), "utf-8");
        config.getTemplate("IService.temp" ).process(data,IServiceWrite);
        IServiceWrite.close();
        
        //生成Service
        OutputStreamWriter serviceWrite = new OutputStreamWriter(
        		new FileOutputStream(createServiceFile(entity,exportPath)), "utf-8");
        config.getTemplate("Service.temp" ).process(data,serviceWrite);
        serviceWrite.close();
        
        //生成controller
        OutputStreamWriter controllerWrite = new OutputStreamWriter(
        		new FileOutputStream(createControllerFile(entity,exportPath)), "utf-8");
        config.getTemplate("controller.temp" ).process(data,controllerWrite);
        controllerWrite.close();
        
        //生成 QueryMapper
        OutputStreamWriter queryMapperWrite = new OutputStreamWriter(
        		new FileOutputStream(createQueryMapper(entity,exportPath)), "utf-8");
        config.getTemplate("QueryMapper.temp" ).process(data,queryMapperWrite );
        mapperWrite.close();
        
        //生成dao
        OutputStreamWriter queryDaoWriter = new OutputStreamWriter(
        		new FileOutputStream(createQueryDaoFile(entity,exportPath)), "utf-8");
        config.getTemplate("QueryDao.temp" ).process(data, queryDaoWriter);
        daoWriter.close();
	}
	
	public Map<String, Object> getData(Entity entity){
		Map<String, Object> data = new  HashMap<String, Object>();
		
        data.put("packagePath", entity.getClassPath());
        data.put("className", entity.getClassName());
        data.put("classNote", entity.getClassNote());
        data.put("classAuthor", entity.getClassAuthor());
        
        //保存属性
        List<Map<String, String>> properties = new  ArrayList<Map<String,String>>();
        
        List<Map<String, String>> propNotID = new  ArrayList<Map<String,String>>();
        Field[] fields = entity.getFields();
        for(Field f : fields) {
           	Map<String,String> m = new HashMap<String, String>();
           	m.put("type", f.getType().getTypeName());
           	m.put("name", f.getFieldName());
           	m.put("tip", f.getFileTip());
           	properties.add(m);
           	
           	if(!f.isID()){
           		propNotID.add(m);
           	}
        }

        data.put("entityID", entity.getEntityID().getFieldName());
        data.put("propNotID", propNotID);
        data.put("properties", properties);
        return data;
	}
	
	private File createEntityFile(Entity entity, String path) throws IOException{
		String classPath = entity.getClassPath().replace(".", "/");
		File file = new File(path + "/createCode/" + classPath+"/"+entity.getClassName()+".java");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private File createDaoFile(Entity entity, String path) throws IOException{
		String classPath = entity.getClassPath().replace(".", "/").replace("entity", "dao");
		File file = new File(path + "/createCode/" + classPath+"/"+entity.getClassName()+"Dao.java");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private File createQueryDaoFile(Entity entity, String path) throws IOException{
		String classPath = entity.getClassPath().replace(".", "/").replace("entity", "dao");
		File file = new File(path + "/createCode/" + classPath+"/"+entity.getClassName()+"QueryDao.java");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private File createMapperFile(Entity entity, String path) throws IOException{
		File file = new File(path + "/createCode/" + entity.getClassName()+"Mapper.xml");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private File createIServiceFile(Entity entity, String path) throws IOException {
		String classPath = entity.getClassPath().replace(".", "/").replace("entity", "service");
		File file = new File(path + "/createCode/" + classPath+"/I"+entity.getClassName()+"Service.java");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private File createServiceFile(Entity entity, String path) throws IOException {
		String classPath = entity.getClassPath().replace(".", "/").replace("entity", "service");
		File file = new File(path + "/createCode/" + classPath+"/"+entity.getClassName()+"Service.java");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	
	private File createControllerFile(Entity entity, String path) throws IOException {
		String classPath = entity.getClassPath().replace(".", "/").replace("entity", "controller");
		File file = new File(path + "/createCode/" + classPath+"/"+entity.getClassName()+"Controller.java");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private File createQueryMapper(Entity entity, String path) throws IOException {
		File file = new File(path + "/createCode/" + entity.getClassName()+"QueryMapper.xml");
		createFile(file);
		System.out.println(file.getPath());
		return file;
	}
	
	private void createFile(File file) throws IOException{
		File parentFile = file.getParentFile();
		if(!parentFile.exists()) {
			file.getParentFile().mkdirs();
		}
		if(!file.exists()){
			file.createNewFile();
		}
	}
	
	
}
