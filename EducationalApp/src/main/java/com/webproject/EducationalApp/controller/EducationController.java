package com.webproject.EducationalApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.EducationalApp.model.StudentInfo;
import com.webproject.EducationalApp.services.EducationalServices;

@RestController
public class EducationController {

	@Autowired
	private EducationalServices eduService;
	
	@GetMapping("/login")
	public ModelAndView login(String userName , String password,HttpServletRequest req, HttpSession session)
	{
		
		ModelAndView mav = new ModelAndView();
	
		if(userName.length()<=0 || password.length()<=0)
		{
			System.out.println(" Inside 1st main if Username :"+userName+" :: Password : "+password);
  
			String msg = "username and password must not be null";
			mav.addObject("msg", msg);
			mav.setViewName("login.jsp");
			return mav;
		}
		
		if(userName!=null && password!=null)
		{
			System.out.println(" Inside 1st if Username :"+userName+" :: Password : "+password);
			if(eduService.loginService(userName, password))
			{
				session = req.getSession();
				session.setAttribute("userName", userName);
				session.setAttribute("password", password);
			
				String name = userName;
				mav.addObject("name", name);
				mav.setViewName("home.jsp");
				return mav;
			}else
			{
				System.out.println("Inside 1st else Username :"+userName+" :: Password : "+password);

				String msg = "Invalid username and password";
				mav.addObject("msg", msg);
				mav.setViewName("login.jsp");
				return mav;
			}
		}else
		{
			System.out.println(" Inside 2nd else Username :"+userName+" :: Password : "+password);

			String msg = "username and password must not be null";
			mav.addObject("msg", msg);
			mav.setViewName("login.jsp");
			return mav;
		}
		
	}
	
	@PostMapping("/register")
	public ModelAndView registration(StudentInfo studInfo)
	{
		ModelAndView mav = new ModelAndView();
		if(eduService.registrationService(studInfo))
		{
			String msg = "Registration successful"; 
			mav.addObject("msg",msg);
			mav.setViewName("login.jsp");
			return mav;
		}else
		{
			String msg = "Registration unsuccessful"; 
			mav.addObject("msg",msg);
			mav.setViewName("registration.jsp");
			return mav;
		}
	}
	
	
}
