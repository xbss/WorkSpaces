package com.xbss.controller.baseControllers;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class DoubleEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		if (getValue() instanceof java.lang.Double) {
			return getValue().toString();
		}
		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (StringUtils.hasText(text)) {
			try {
				setValue(Double.parseDouble(text));
			} catch (Exception e) {
				// TODO: handle exception
				IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
						"ERROR: cannot convert double");
				illegalArgumentException.initCause(e);
				throw illegalArgumentException;
			}
		}
	}

}
