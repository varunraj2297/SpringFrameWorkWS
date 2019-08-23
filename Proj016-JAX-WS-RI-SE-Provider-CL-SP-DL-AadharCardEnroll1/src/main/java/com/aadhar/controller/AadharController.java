package com.aadhar.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aadhar.command.AadharCommand;
import com.aadhar.dto.AadharDTO;
import com.aadhar.service.AadharService;

@Controller
@SessionAttributes(value = "aadharCommand")
public class AadharController {

	@Autowired
	private AadharService aadharService;

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String showForm(Map<String, Object> map) {
		System.out.println("AadharController.showForm()");
		AadharCommand aadharCommand = null;

		aadharCommand = new AadharCommand();
		map.put("aadharCommand", aadharCommand);
		return "enroll_form";
	}

	@RequestMapping(value = "/home.htm", method = RequestMethod.POST)
	public String processRegistration(Map<String, Object> map,
			@ModelAttribute("aadharCommand") AadharCommand aadharCommand) {
		AadharDTO aadharDTO = null;
		String resultMsg = null;

		try {
			aadharDTO = new AadharDTO();
			BeanUtils.copyProperties(aadharCommand, aadharDTO);

			resultMsg = aadharService.registerApplicant(aadharDTO);
			map.put("resultMsg", resultMsg);
			return "result";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@ModelAttribute("gendersList")
	public List<String> getGendersList() {
		List<String> gendersList = null;

		gendersList = new ArrayList<String>();
		gendersList.add("MALE");
		gendersList.add("FEMALE");
		gendersList.add("OTHERS");

		return gendersList;
	}

	@InitBinder
	public void dateBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat sdf = null;

		sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
