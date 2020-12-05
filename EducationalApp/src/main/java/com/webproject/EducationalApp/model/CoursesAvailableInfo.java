package com.webproject.EducationalApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CoursesAvailableInfo {

	@Id
	int courseId;
	String courseName;
	String coursePrice;
	@ManyToMany(mappedBy = "coursesAvailableInfo", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	List<StudentInfo> studentInfo = new ArrayList<StudentInfo>();
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}
	public List<StudentInfo> getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(List<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}
	
	@Override
	public String toString() {
		return "CoursesAvailableInfo [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice="
				+ coursePrice + ", studentInfo=" + studentInfo + "]";
	}
	
	
	
	
}
