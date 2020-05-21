package com.example.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.serviceimpl.TollPlacesServiceImpl;
import com.example.userdomain.ForgotPwd;
import com.example.userentity.UserEntity;

@Controller
public class ForgotPwdController {
	@Autowired
	private TollPlacesServiceImpl tollPlacesServiceImpl;

	@RequestMapping(value = "/displayForgotForm")
	public String forgotPwdInit(Model model) {
		ForgotPwd forgotPwd = new ForgotPwd();
		model.addAttribute("forgotObj", forgotPwd);
		return "forgotPwdForm";

	}

	
	@RequestMapping(value = "/getForgotEmail", method = RequestMethod.POST)
	public String hndlForgotPwdBtn(@ModelAttribute("forgotObj") ForgotPwd fgtPwd, Model model) {
		System.out.println(fgtPwd.getUserEmail());
		UserEntity entity = tollPlacesServiceImpl.findPwdByEmail(fgtPwd);
		if (entity != null) {
			if (entity.getLockStatus().equals("UNLOCKED")) {
				String pwd = entity.getUPwd();
				model.addAttribute("pwdMsg", "Your password is :" + pwd);
			} else {
				model.addAttribute("errMsg",
						"please check your email first to unlock your account");
			}
		} else {
			model.addAttribute("errMsg", "enter valid register email id");
		}
		return "forgotPwdForm";

	}
}
