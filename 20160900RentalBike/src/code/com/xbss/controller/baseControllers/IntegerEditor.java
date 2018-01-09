package com.xbss.controller.baseControllers;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class IntegerEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		if (getValue() instanceof java.lang.Integer) {
			return getValue().toString();
		}
		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (StringUtils.hasText(text)) {
			try {
				setValue(Integer.parseInt(text));
			} catch (Exception e) {
				// TODO: handle exception
				IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
						"ERROR: can not convert integer!");
				illegalArgumentException.initCause(e);
				throw illegalArgumentException;
			}
		} else {
			setValue(0);
		}
	}

}
