package com.webproject.EducationalApp.services;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webproject.EducationalApp.dao.CoursesAvailableDao;
import com.webproject.EducationalApp.dao.StudentInfoDao;
import com.webproject.EducationalApp.model.CoursesAvailableInfo;
//import com.webproject.EducationalApp.model.StudentCoursesInfo;
import com.webproject.EducationalApp.model.StudentInfo;

@Component
public class EducationalServices {
	
	@Autowired
	private StudentInfoDao studInfoDao;

	@Autowired
	public StudentInfo studInfo;
	
	@Autowired
	private CoursesAvailableDao coursesDao;
	
	
	//for login
	public boolean loginService(String userName , String password)
	{
		studInfo = studInfoDao.findByUserName(userName);
		
		if(studInfo != null)
			return true;
		else
			return false;
	}
	
	//for Registration
	public boolean registrationService(StudentInfo studInfo)
	{
		StudentInfo si = studInfoDao.save(studInfo);
		
		if(si != null)
			return true;
		else
			return false;
	}
	
	//for Profile 
	public StudentInfo profileService()
	{
	
		StudentInfo stud = studInfoDao.findById(studInfo.getId()).orElse(new StudentInfo());
		return stud;
		
	}
	
	//for Delete Account
	public String deleteAccountService(HttpServletRequest req , HttpSession session)
	{
		studInfoDao.deleteById(studInfo.getId());
		return "account deleted";
	}
	
	//for Student Courses
	/*
	 * public Student_Courses myCoursesServices() { //StudentCoursesInfo courses =
	 * studCourseDao.findById(studInfo.getId()).orElse(null); //return courses;
	 * return null;
	 * 
	 * }
	 */
	
	//for All Courses
	public Iterable<CoursesAvailableInfo> coursesService()
	{
		Iterable<CoursesAvailableInfo> courses =  coursesDao.findAll();
		return courses;		
	}
	
	//for Searching Student
	public StudentInfo searchStudentService(int id)
	{
		StudentInfo stud = studInfoDao.findById(id).orElse(null);
		return stud;
	}
	
	//for Updating Student Data
	public StudentInfo updateStudInfoService(StudentInfo stud,HttpServletRequest req , HttpSession session)
	{
		System.out.println(stud);
		StudentInfo updatedStud = studInfoDao.save(stud);
		session.removeAttribute("userName");
		session.removeAttribute("password");
		session.invalidate();
		//studInfoDao.delete(studInfo);
		studInfo = updatedStud;
		session = req.getSession();
		session.setAttribute("userName", studInfo.getUserName());
		session.setAttribute("password", studInfo.getPassword());
		return studInfo;
	}
	
	//for Adding Student course
	
}
