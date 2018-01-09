package com.xbss.controller.baseControllers;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class LongEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		if (getValue() instanceof java.lang.Long) {
			return getValue().toString();
		}
		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (StringUtils.hasText(text)) {
			try {
				setValue(Long.parseLong(text));
			} catch (Exception e) {
				// TODO: handle exception
				IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
						"ERROR: can not convert long");
				illegalArgumentException.initCause(e);
				throw illegalArgumentException;
			}
		}
	}

}
