package com.example.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.serviceimpl.TollPlacesServiceImpl;
import com.example.userdomain.Login;
import com.example.userdomain.UserDomain;
import com.example.userentity.UserEntity;
import com.example.utils.EmailUtils;

@Controller
public class UserController {

	@Autowired
	private TollPlacesServiceImpl tollPlacesServiceImpl;

	@Autowired
	private EmailUtils emailUtils;

	@RequestMapping(value="/home")
	public String welocme(Model model) {
		Login login = new Login();
		model.addAttribute("loginObj", login);
		return "home";
	}

	@RequestMapping(value="/displayUserForm")
	public String displayHomePage(Model model) {
		UserDomain userDomain = new UserDomain();
		model.addAttribute("userobj", userDomain);
		return "userform";
	}
	@RequestMapping(value="/saveUserDetails",method=RequestMethod.POST)
	public String handleSingUp(@ModelAttribute("userobj") UserDomain userDomain,Model model) {
		
		UserEntity userEntity = tollPlacesServiceImpl.saveUserDetails(userDomain);

		if(userEntity != null && userEntity.getUId()!=0) { 
			model.addAttribute("sccMsg", "Registration almost done, please check your email to unlock ");
		}else{
			model.addAttribute("errMsg", "failed to insert data");
		}


		return "userform";
	}


}
