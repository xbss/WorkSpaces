package entity;

public enum FieldType {
	Int("int"),
	String("String"),
	Date("Date"),
	Long("long"),
	Boolean("boolean"),
	Double("double");
	
	private String typeName = null;  
    private FieldType(String d){  
        this.typeName = d;  
    } 
    
    public String getTypeName(){  
        return typeName;  
    }  
}
