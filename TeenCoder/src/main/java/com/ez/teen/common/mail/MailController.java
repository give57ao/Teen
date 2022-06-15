package com.ez.teen.common.mail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class MailController {

	@Autowired
	EmailService emailService;
	
	@RequestMapping("/mail")
	  public String write(HttpSession session, Model model) {
		String member_id = (String)session.getAttribute("member_id");
		String member_nick = (String)session.getAttribute("member_nick");
		
		model.addAttribute("member_id", member_id);
		model.addAttribute("member_nick", member_nick);

        return "/email/devCheckEmail"; 
	}
	
	@RequestMapping("/mail/send") 
    public String send(HttpSession session, @ModelAttribute MailModel mailModel, Model model,
    		MultipartHttpServletRequest mpRequest) {
        try {
    		String member_id = (String)session.getAttribute("member_id");
    		String member_nick = (String)session.getAttribute("member_nick");
    		mailModel.setSenderName(member_nick+"("+member_id+")");

            System.out.println(mailModel);
            System.out.println("==================================================");
 
            emailService.sendMail(mailModel, mpRequest); 

        } catch (Exception e) {
            e.printStackTrace();
        }
		return "redirect:/member/mypageModify";
    }
	
	
	
    }
