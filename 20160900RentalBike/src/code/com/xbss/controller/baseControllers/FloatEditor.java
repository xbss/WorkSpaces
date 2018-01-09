package com.xbss.controller.baseControllers;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class FloatEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		if (getValue() instanceof java.lang.Float) {
			return getValue().toString();
		}
		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (StringUtils.hasText(text)) {
			try {
				setValue(Float.parseFloat(text));
			} catch (Exception e) {
				// TODO: handle exception
				IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
						"ERROR: can not convert float");
				illegalArgumentException.initCause(illegalArgumentException);
				throw illegalArgumentException;
			}
		}
	}

}
