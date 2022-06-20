package com.ez.teen.common.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class EmailServiceImpl implements EmailService{
	  private static final String filePath = "C:\\upload\\";

	@Autowired
	JavaMailSender mailSender; 
		
	
	@Override
	public void sendMail(MailModel mailModel, MultipartHttpServletRequest mpRequest) {
		   try {
	            // 이메일 객체
	            MimeMessage msg = mailSender.createMimeMessage();
	 
	            // 받는 사람을 설정 (수신자, 받는사람의 이메일 주소 객체를 생성해서 수신자 이메일주소를 담음)
	            msg.addRecipient(RecipientType.TO, new InternetAddress(mailModel.getReceiveMail()));
	
	            //메일 본문 html 태그 감싸기
	            StringBuffer sb = new StringBuffer();
	            sb.append("<html><body>");
	     		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
	     		sb.append(mailModel.getMessage());
	     		sb.append("</body></html>");
	     		String str=sb.toString();
	     		mailModel.setMessage(str);
	     		
	     	   //메일 작성에 필요한 값 적용
	     	   MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
	     	   messageHelper.setSubject(mailModel.getSubject());
	     	   messageHelper.setTo(mailModel.getReceiveMail());
	     	   messageHelper.setFrom(mailModel.getSenderMail());
	     	   messageHelper.setText(mailModel.getMessage(), true);
	     	  
	     	    //첨부 파일
	     	    Iterator<String> iterator = mpRequest.getFileNames();
	     	    System.out.println(mpRequest.getFileNames());
		   		MultipartFile multpartFile = null;
				String originalFileName = null;
				String originalFileExtension = null;
				String storedFileName = null;
				
				List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
				Map<String, Object> listMap = null;
				File file = new File(filePath);
				if(file.exists() == false) {
					file.mkdirs();
				} 

				while (iterator.hasNext()) {
					multpartFile = mpRequest.getFile(iterator.next());
				if(multpartFile.isEmpty() == false) {
					originalFileName = multpartFile.getOriginalFilename();
					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
					
					storedFileName = getRandomString() + originalFileExtension;
					
					file = new File(filePath + originalFileName);
					
					multpartFile.transferTo(file);
					
					listMap = new HashMap<String, Object>();
					listMap.put("ORG_FILE_NAME", originalFileName);
					listMap.put("STORED_FILE_NAME", storedFileName);
					list.add(listMap);
					
				
			
				DataSource dataSource = new FileDataSource(filePath+originalFileName); 
				messageHelper.addAttachment(MimeUtility.encodeText(originalFileName, "UTF-8", "B"), dataSource);
				}
				}
	     	 
	 
	            // 이메일 보내기
	            mailSender.send(msg);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
public static String getRandomString() {
	return UUID.randomUUID().toString().replace("-", "");
}
		
	}
	

