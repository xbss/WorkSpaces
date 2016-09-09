package entity;

public class Entity {
	public String classPath;
	public String className;
	public String classNote;
	public String classAuthor;
	Field[] fields;
	Field entityID;

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		StringBuilder fieldInfo = new StringBuilder();
		for(Field f : fields) {
			fieldInfo.append(f.getFieldName() + "\t" + f.getType() + "\t" + f.isID() + "\n" );
		}
		
		return this.classPath + "\t" + this.className + "\n" + fieldInfo.toString();
	}

	public Field getEntityID() {
		return entityID;
	}

	public void setEntityID(Field entityID) {
		this.entityID = entityID;
	}

	public String getClassNote() {
		return classNote;
	}

	public void setClassNote(String classNote) {
		this.classNote = classNote;
	}

	public String getClassAuthor() {
		return classAuthor;
	}

	public void setClassAuthor(String classAuthor) {
		this.classAuthor = classAuthor;
	}
	
	
}
