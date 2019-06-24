package org.simpro.controller;  
  
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

  
  
@Controller  
@RequestMapping("/system") 
public class SystemController {  
      
    @RequestMapping("/login")  
    public String userList(HttpServletRequest request,Model model){
    	model.addAttribute("basePath",request.getContextPath());
    	HttpSession hs = request.getSession();
        return "/view/manage/login";  
    }  
}  