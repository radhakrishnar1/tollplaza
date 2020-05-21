package com.example.usercontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.TollPlacesService;
import com.example.userdomain.UnlockAccountDomain;

@Controller
public class UnlockAccController {
	 @Autowired
	private TollPlacesService tollPlacesService;
	
	
    @RequestMapping(value="/unlock")
	public String loadUnlockForm(HttpServletRequest req, Model model) {
    UnlockAccountDomain unlockAccObj = new UnlockAccountDomain();
    
    	String email = req.getParameter("email");
    	if(email != null && !"".equals(email)) {
    		unlockAccObj.setEmail(email);
    		model.addAttribute("unlockAcc", unlockAccObj);
    	}
		return "unlock-acc-form";
		
	}
    @RequestMapping(value="/unlockAccount", method= RequestMethod.POST )
	public String handleSubmitBtn(@ModelAttribute("unlockAcc") UnlockAccountDomain unlockAccountDomain,Model model) {
		 boolean unlockAcc = tollPlacesService.UnlockAccount(unlockAccountDomain);
		if(unlockAcc) {
			
			model.addAttribute("succMsg", "your account has been unlocked..continue with the login");
		}else {
			model.addAttribute("errMsg", "enter the temporary password provided in the mail");
		}
		
    	return "unlock-acc-form";
		
	}
}
