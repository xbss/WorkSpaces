package com.xbss.entity.suggestion;

import java.util.Date;
import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 意见建议
 */
public class Suggestion{
	
	@ID
	private String  suggestionId;
	private String content;
	private int state;
	private String operatorId;
	private String operatorName;
	private String userId;
	private String userName;
	private Date submitTime;
	private String feedBackInfo;
	
	
	public String getSuggestionId() {
		return suggestionId;
	}	
	
	public void setSuggestionId(String suggestionId) {
		this.suggestionId = suggestionId;
	}
	public String getContent() {
		return content;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public String getOperatorId() {
		return operatorId;
	}	
	
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}	
	
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getUserId() {
		return userId;
	}	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getSubmitTime() {
		return submitTime;
	}	
	
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public String getFeedBackInfo() {
		return feedBackInfo;
	}	
	
	public void setFeedBackInfo(String feedBackInfo) {
		this.feedBackInfo = feedBackInfo;
	}
	
	@Override
	public String toString() {
		return   suggestionId  + "\t" +  content  + "\t" +  state  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  userId  + "\t" +  userName  + "\t" +  submitTime  + "\t" +  feedBackInfo  + "\t"  ;
	}
}
