package com.everydaymall.entity;

import java.io.Serializable;

public class Feedback implements Serializable{
   
	private static final long serialVersionUID = 1791490034559108842L;

	private Integer idIndex;

    private String idFeedback;

    private String feedbackCreateby;

    private String feedbackCreatetime;

    private String feedbackContent;

    public Feedback(Integer idIndex, String idFeedback, String feedbackCreateby, String feedbackCreatetime, String feedbackContent) {
        this.idIndex = idIndex;
        this.idFeedback = idFeedback;
        this.feedbackCreateby = feedbackCreateby;
        this.feedbackCreatetime = feedbackCreatetime;
        this.feedbackContent = feedbackContent;
    }

    public Feedback() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(String idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getFeedbackCreateby() {
        return feedbackCreateby;
    }

    public void setFeedbackCreateby(String feedbackCreateby) {
        this.feedbackCreateby = feedbackCreateby;
    }

    public String getFeedbackCreatetime() {
        return feedbackCreatetime;
    }

    public void setFeedbackCreatetime(String feedbackCreatetime) {
        this.feedbackCreatetime = feedbackCreatetime;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

	@Override
	public String toString() {
		return "Feedback [idIndex=" + idIndex + ", idFeedback=" + idFeedback + ", feedbackCreateby=" + feedbackCreateby
				+ ", feedbackCreatetime=" + feedbackCreatetime + ", feedbackContent=" + feedbackContent + "]";
	}
    
    
}