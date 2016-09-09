package entity;

public class Field {
	private String fieldName;
	private boolean isID;
	private FieldType type;
	private String fileTip;
	

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public boolean isID() {
		return isID;
	}

	public void setID(boolean isID) {
		this.isID = isID;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	public String getFileTip() {
		return fileTip;
	}

	public void setFileTip(String fileTip) {
		this.fileTip = fileTip;
	}

}
