package service;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Entity;
import entity.Field;
import entity.FieldType;

public class XmlParser {
	   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	   DocumentBuilder buider ;
	   
		public XmlParser(){
			try {
				buider = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} 
		}
		   
		
		
		public Entity parsetToEntity(String xmlPath,boolean isChangeId) throws SAXException, IOException, XPathExpressionException{
			File f = new File(xmlPath);  
		    Document doc = buider.parse(f);  
		    
		    XPathFactory xpfactory = XPathFactory.newInstance();  
		    XPath path = xpfactory.newXPath(); 
		    
		    Entity entity = new Entity();
		    
		    String classPath = path.evaluate("/entity/class/@classPackage", doc);
		    entity.setClassPath(classPath);
		    
		    Node clazz = (Node)path.evaluate("/entity/class", doc,XPathConstants.NODE);
		    String className = toUpperCaseFirstOne(clazz.getTextContent().trim());
		    entity.setClassName(className);
		    
		    String classNote = path.evaluate("/entity/class/@note", doc);
		    entity.setClassNote(classNote);
		    
		    String classAuthor = path.evaluate("/entity/class/@author", doc);
		    entity.setClassAuthor(classAuthor);
		    
		   
		    NodeList fieldNodes = (NodeList)path.evaluate("/entity/fields/field", doc,XPathConstants.NODESET);
		    Field[] fields = new Field[fieldNodes.getLength()];
		    
		    for(int i = 0; i < fieldNodes.getLength(); i++){ 
		    	Node fieldNode = fieldNodes.item(i);
		    	fields[i] = new Field();
		    	Field field = fields[i];
		    	
		    	//Ϊ�����Oracle���ֶ���ȫ��ʹ�ô�д
//		    	String fieldName = fieldNode.getTextContent().trim().toUpperCase();
		    	String fieldName = fieldNode.getTextContent().trim();
		    	
		    	
		    	if(!fieldName.equals("ID")) {	//�������ID��������ĸСд
		    		fieldName = toLowerCaseFirstOne(fieldName);
		    	}
		    	
		    	if((fieldName.contains("id")||fieldName.contains("Id")||fieldName.contains("iD")) && isChangeId){
		    		fieldName = fieldName.replaceAll("id", "ID");
		    	}
		    	
		    	field.setFieldName(fieldName);
		    	
		    	
		    	if(path.evaluate("@isId", fieldNode).equals("1")){
		    		field.setID(true);
		    		
		    		entity.setEntityID(field);	
		    	}
		    	
		    	
		    	
		    	if(path.evaluate("@tip", fieldNode)!=null){
		    		field.setFileTip(path.evaluate("@tip", fieldNode));
		    		System.out.println(field.getFileTip());
		    	}
		    	
		    	String type = path.evaluate("@type", fieldNode);
		    	if(type.equals("")) {
		    		field.setType(FieldType.String);
		    	} else if(type.equals("int")) {
		    		field.setType(FieldType.Int);
		    	} else if(type.equals("date")) {
		    		field.setType(FieldType.Date);
		    	} else if(type.equals("long")) {
		    		field.setType(FieldType.Long);
		    	} else if(type.equals("boolean")) {
		    		field.setType(FieldType.Boolean);
		    	} else if(type.equals("double")) {
		    		field.setType(FieldType.Double);
		    	} else {
		    		System.out.println("字段 " + fieldName + "类型不支持: " + type);
		    		throw new UnsupportedOperationException();
		    	}
		    } 
		    entity.setFields(fields);
		    return entity;
		}
	
		//����ĸ��д
		private  String toUpperCaseFirstOne(String s)
	    {
	        if(Character.isUpperCase(s.charAt(0)))
	            return s;
	        else
	            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	    }
		
		//����ĸСд
		private  String toLowerCaseFirstOne(String s)
	    {
	        if(Character.isLowerCase(s.charAt(0)))
	            return s;
	        else
	            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	    }

}
