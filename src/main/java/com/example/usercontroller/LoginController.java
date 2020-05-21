package com.example.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.serviceimpl.TollPlacesServiceImpl;
import com.example.userdomain.Login;
import com.example.userentity.UserEntity;

@Controller
public class LoginController {

	
	@Autowired
	private TollPlacesServiceImpl tollPlacesServiceImpl;
	
	@RequestMapping(value="/loginForm")
	public String init(Model model) {
		Login login = new Login();
		model.addAttribute("loginObj", login);
		return "home";
	}
	
	@RequestMapping(value="/getLoginDetails",method=RequestMethod.POST)
	public String hndlLoginBtn(@ModelAttribute("loginObj") Login login,Model model) {
	UserEntity entity = tollPlacesServiceImpl.findLoginDetails(login);
	System.out.println("entity values:: "+entity);
	if(entity!=null) {
			if(entity.getLockStatus().equals("UNLOCKED")) {
				model.addAttribute("sccMsg", "Welcome to TollPlus");
			}else {
				model.addAttribute("errMsg", "please check your Email for Unlock your account");
			}
		
			
		}else {
			model.addAttribute("sccMsg", "please enter valid credentials");
		}
		return "dashBoardForm";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
