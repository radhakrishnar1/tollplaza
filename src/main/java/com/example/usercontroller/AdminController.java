package com.example.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.serviceimpl.TollPlacesServiceImpl;
import com.example.userdomain.UserDomain;
import com.example.userentity.UserEntity;

public class AdminController {

	@Autowired
	private TollPlacesServiceImpl tollPlacesServiceImpl;


	@RequestMapping(value = "/displayAdminForm", method = RequestMethod.GET)
	public String adminInit(Model model) {
		model.addAttribute("adminObj", new UserDomain());
		return "enteradmdtlsform";
	}

	@RequestMapping(value = "/saveAdminDetails", method = RequestMethod.POST)
	public String hndlCreateAdminBtn(@ModelAttribute("adminObj") UserDomain userDomain, RedirectAttributes attributes) {
		UserEntity entity = tollPlacesServiceImpl.saveAdminData(userDomain);
		if (entity != null) {
			attributes.addFlashAttribute("sccMsg", "ur registration completed please check your email ");
		} else {
			attributes.addFlashAttribute("errMsg",  "ur registration has failed...RETRY");
		}
		return "enteradmdtlsform";
	}
//
//	@RequestMapping(value = "/getAllAdmins", method = RequestMethod.GET)
//	public String displayAllAgents(User user, RedirectAttributes attributes) {
//		List<UserEntity> list = tollPlacesServiceImpl.getAllAdminsDetails();
//
//		if (list != null) {
//			attributes.addFlashAttribute("list", list);
//		} else {
//			attributes.addFlashAttribute(AppConstants.DISPLAY_ERR_MSG, AppConstants.ADMIN_NOT_AVILABLE_MSG);
//		}
//		return AppConstants.REDIRECT_ADMIN_DETAILS_TABLE_FORM;
//	}
//
//	@RequestMapping(value = "/displayAdminsTable", method = RequestMethod.GET)
//	public String displayAdminSccForm(Model model) {
//		return AppConstants.DISPLAY_ADMIN_DETAILS_TABLE_FORM;
//	}
//
//	@RequestMapping(value = "/deleteAdmin/{userId}", method = RequestMethod.GET)
//	public String deleteAdminbyId(@PathVariable("userId") Integer userId, RedirectAttributes attributes) {
//		tollPlacesServiceImpl.deleteAdminById(userId);
//		return AppConstants.REDIRECT_ALL_ADMIN_DETAILS_FORM;
//	}
//
//	@RequestMapping(value = "/updateAdmin/{userId}", method = RequestMethod.POST)
//	public String updateAdminDetails(@PathVariable("userId") Integer userId) {
//		tollPlacesServiceImpl.updateAdmin(userId);
//		return AppConstants.DISPLAY_ADMIN_DETAILS_TABLE_FORM;
//	}
}