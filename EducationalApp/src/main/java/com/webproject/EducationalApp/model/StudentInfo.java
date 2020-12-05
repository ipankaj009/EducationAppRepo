package com.webproject.EducationalApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class StudentInfo {

	@Id
	int id;
	String userName;
	String password;
	String sname;
	String email;
	String address;
	int contact;
	String tech;
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Student_Courses",
		joinColumns= {@JoinColumn(name="student_id")},
		inverseJoinColumns = {@JoinColumn(name="course_id")})
	List<CoursesAvailableInfo> coursesAvailableInfo = new ArrayList<CoursesAvailableInfo>();
	
	
	
	public List<CoursesAvailableInfo> getCoursesAvailableInfo() {
		return coursesAvailableInfo;
	}

	public void setCoursesAvailableInfo(List<CoursesAvailableInfo> coursesAvailableInfo) {
		this.coursesAvailableInfo = coursesAvailableInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", userName=" + userName + ", password=" + password + ", sname=" + sname
				+ ", email=" + email + ", address=" + address + ", contact=" + contact + ", tech=" + tech
				+ ", coursesAvailableInfo=" + coursesAvailableInfo + "]";
	}
	
	
	
}
