package com.webproject.EducationalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.EducationalApp.model.CoursesAvailableInfo;
//import com.webproject.EducationalApp.model.StudentCoursesInfo;
import com.webproject.EducationalApp.model.StudentInfo;
import com.webproject.EducationalApp.services.EducationalServices;

@RestController
public class HomePageController {

	@Autowired
	private EducationalServices eduService;
	@Autowired
	private StudentInfo stud;
	private ModelAndView mav = new ModelAndView();
	
	
	@GetMapping(path="profile/{id}")
	@ResponseBody
	public StudentInfo getStudent(@PathVariable int id)
	{
		stud  = eduService.searchStudentService(id);
		
		for(CoursesAvailableInfo courses : stud.getCoursesAvailableInfo())
		{
			System.out.println("Course name : "+courses.getCourseName());
		}
		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("studData", stud);
//		mav.setViewName("login.jsp");
		
		return stud;
	}
	
	
	@GetMapping("/profile")
	public ModelAndView profile()
	{
	    
		StudentInfo studInfo = eduService.profileService();
		
		mav.addObject("studInfo",studInfo);
		mav.setViewName("profile.jsp");
		
		return mav;
	}
	
	@RequestMapping("/deleteAcc")
	public ModelAndView deleteAccount(HttpServletRequest req , HttpSession session)
	{
		String msg = eduService.deleteAccountService(req, session);
		mav.addObject("msg", msg);
		mav.setViewName("registration.jsp");
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req , HttpSession session)
	{
		session.removeAttribute("userName");
		session.removeAttribute("password");
		session.invalidate();
		mav.setViewName("login.jsp");
		return mav;
	}
	
	/*
	 * @GetMapping("/myCourses") public ModelAndView myCourses() {
	 * StudentCoursesInfo courses = eduService.myCoursesServices(); if(courses !=
	 * null) {
	 * System.out.println("Courses is not null..................................");
	 * mav.addObject("showDataMsg",courses); mav.setViewName("showdata.jsp"); return
	 * mav; } else {
	 * System.out.println("Courses is null..................................");
	 * String showDataMsg = "No courses found";
	 * mav.addObject("showDataMsg",showDataMsg); mav.setViewName("showdata.jsp");
	 * return mav; } }
	 */
	
	@GetMapping("/allCourses")
	public ModelAndView courses()
	{
		Iterable<CoursesAvailableInfo> coursesDataMsg = eduService.coursesService();
		Iterator<CoursesAvailableInfo> iteratorCourse = coursesDataMsg.iterator();
		ArrayList<CoursesAvailableInfo> courseArray = new ArrayList<CoursesAvailableInfo>();
	//	ArrayList<String> courseNames = new ArrayList<String>();

		while(iteratorCourse.hasNext())
		{
			courseArray.add(iteratorCourse.next());
		}
		/*
		 * for(CoursesAvailableInfo course :courseArray) {
		 * courseNames.add(course.getCourseId());
		 * System.out.println(course.getCourseId()); }
		 */
		mav.addObject("showDataMsg",courseArray);
		mav.setViewName("allcourses.jsp");
		return mav;
	}
	
	@GetMapping("/searchStudent")
	public ModelAndView searchStudent(@RequestParam("studentName") int  id)
	{
		StudentInfo stud = eduService.searchStudentService(id);
		mav.addObject("showDataMsg", stud);
		mav.setViewName("showdata.jsp");
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateStudInfo(StudentInfo stud,HttpServletRequest req , HttpSession session)
	{
		StudentInfo updatedStudInfo = eduService.updateStudInfoService(stud,  req, session);
		String msg = "Your information is updated ........ ";
		mav.addObject("showDataMsg",msg);
		mav.setViewName("showdata.jsp");
		return mav;
	}
	
	@GetMapping("//beforeUpdate")
	public ModelAndView beforeUpdating()
	{
		StudentInfo studInfo = eduService.profileService();
		mav.addObject("stud",studInfo);
		mav.setViewName("update.jsp");
		return mav;	
	
	}
	
	
	
	@RequestMapping("/addStudCourse") 
	public ModelAndView addingStudCourse(@RequestParam("courseId")int courseId) 
	{ 
		  StudentInfo studInfo = eduService.studInfo;
		  //for(String s : courseObj)
		  System.out.println(courseId);
		 // studInfo.getCoursesAvailableInfo().add(courseObj);
	      mav.addObject("stud","Course added"); 
	      mav.setViewName("allcourses.jsp"); 
	      return mav;
	  
	}
	 
	 
	
	
	
}
