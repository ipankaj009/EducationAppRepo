package com.webproject.EducationalApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webproject.EducationalApp.model.StudentInfo;

@Repository
public interface StudentInfoDao extends JpaRepository<StudentInfo, Integer> {

	public StudentInfo findByUserName(String userName);
	
}
