package com.senla.task5.coursebase.controller;

import com.senla.task5.coursebase.dao.*;
import com.senla.task5.coursebase.filework.FileWorker;
import com.senla.task5.coursebase.service.*;

public class FacadeBuilder {

	public static Facade buildFacade() {

		CourseDAO courseDAO = new CourseDAO();
		CourseService courseService = new CourseService(courseDAO);

		LectionDAO lectionDAO = new LectionDAO();
		LectionService lectionService = new LectionService(lectionDAO);

		LecturerDAO lecturerDAO = new LecturerDAO();
		LecturerService lecturerService = new LecturerService(lecturerDAO);

		SectionDAO sectionDAO = new SectionDAO();
		SectionService sectionService = new SectionService(sectionDAO);

		StudentDAO studentDAO = new StudentDAO();
		StudentService studentService = new StudentService(studentDAO);

		FileWorker fileWorker = new FileWorker();

		Facade facade = Facade.getInstance();
		facade.setCourseService(courseService);
		facade.setLectionService(lectionService);
		facade.setLecturerService(lecturerService);
		facade.setSectionService(sectionService);
		facade.setStudentService(studentService);
		facade.setFileWorker(fileWorker);
		return facade;
	}

}
