package org.simpro.controller;  
  
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seu.service.IUserService;  
  
  
@Controller  
@RequestMapping("/system") 
public class SystemController {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/login")  
    public String userList(HttpServletRequest request,Model model){
    	model.addAttribute("basePath",request.getContextPath());
        return "index";  
    }  
}  