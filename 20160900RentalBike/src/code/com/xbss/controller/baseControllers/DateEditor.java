package com.xbss.controller.baseControllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {

	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		if (getValue() instanceof java.util.Date) {
			try {
				Calendar calendar = Calendar.getInstance();
				Date date = (Date) getValue();
				calendar.setTimeInMillis(date.getTime());
				if (calendar.get(Calendar.HOUR_OF_DAY) == 0
						&& calendar.get(Calendar.MINUTE) == 0
						&& calendar.get(Calendar.SECOND) == 0) {
					return dateFormat.format(date);
				} else {
					return dateTimeFormat.format(date);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (StringUtils.hasText(text)) {
			try {
				if (text.indexOf(":") == -1 && text.length() == 10) {
					setValue(this.dateFormat.parse(text));
				} else if (text.indexOf(":") > 0 && text.length() == 19) {
					setValue(this.dateTimeFormat.parse(text));
				} else {
					throw new IllegalArgumentException(
							"ERROR: can not parse data !");
				}
			} catch (Exception e) {
				// TODO: handle exception
				IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
						"ERROR: can not parse data !");
				illegalArgumentException.initCause(e);
				throw illegalArgumentException;
			}
		} else {
			setValue(null);
		}
	}

}
