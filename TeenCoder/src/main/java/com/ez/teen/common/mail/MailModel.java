package com.ez.teen.common.mail;

import java.util.Date;

public class MailModel {
	
	private String senderName;    //발신자 이름
    private String senderMail;    //발신자 이메일 주소
    private String receiveMail;    //수신자 이메일 주소
    private String subject;            //제목
 	private String htmlMessage; //html 본문
    private String message;            //본문
    
	//getter,setter,toString
    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getSenderMail() {
        return senderMail;
    }
    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }
    public String getReceiveMail() {
        return receiveMail;
    }
    public void setReceiveMail(String receiveMail) {
        this.receiveMail = receiveMail;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getHtmlMessage() {
 		return htmlMessage;
 	}
 	public void setHtmlMessage(String htmlMessage) {
 		this.htmlMessage = htmlMessage;
 	}
    
	@Override
    public String toString() {
        return "EmailModel [senderName=" + senderName + ", senderMail=" + senderMail + ", receiveMail=" + receiveMail
                + ", subject=" + subject + ", message=" + message + "]";
    }

	
	
    
}
