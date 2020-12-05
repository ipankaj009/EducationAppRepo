package com.webproject.EducationalApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webproject.EducationalApp.model.CoursesAvailableInfo;

@Repository
public interface CoursesAvailableDao extends JpaRepository<CoursesAvailableInfo, Integer>{

}
