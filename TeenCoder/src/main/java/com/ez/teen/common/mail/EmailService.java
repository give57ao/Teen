package com.ez.teen.common.mail;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmailService {
	public void sendMail(MailModel mailModel, MultipartHttpServletRequest mpRequest);
}
