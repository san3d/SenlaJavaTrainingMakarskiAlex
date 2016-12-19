package com.senla.task5.courseui.controller;

import java.util.ArrayList;
import java.util.List;

import com.senla.task5.courseui.action.LoadCoursesBaseAction;
import com.senla.task5.courseui.action.NewCourseAction;
import com.senla.task5.courseui.action.NewLecturerAction;
import com.senla.task5.courseui.action.PrintAllLecturers;
import com.senla.task5.courseui.action.ScheduleAction;
import com.senla.task5.courseui.action.TotalCalculationAction;
import com.senla.task5.courseui.action.SerializationAction;
import com.senla.task5.courseui.action.CloneCourseAction;
import com.senla.task5.courseui.action.CoursesExportAction;
import com.senla.task5.courseui.action.CoursesImportAction;
import com.senla.task5.courseui.action.DeSerializationAction;
import com.senla.task5.courseui.menu.Menu;
import com.senla.task5.courseui.menu.interfaces.IMenu;
import com.senla.task8.service.RequestHandler;

public class MenuBuilder {

	private List<IMenu> menus;

	public MenuBuilder(RequestHandler requestHandler) {
		
		menus = new ArrayList<IMenu>();
		IMenu menuCourses = new Menu("Work with Courses", 1);
		IMenu menuCourses01 = new Menu("Load DataBase from \"CoursesBase\"", 1, new LoadCoursesBaseAction(requestHandler));
		IMenu menuCourses02 = new Menu("Create new Course", 2, new NewCourseAction(requestHandler));
		IMenu menuCourses03 = new Menu("Back", 3);

		menuCourses.addMenu(menuCourses01);
		menuCourses.addMenu(menuCourses02);
		menuCourses.addMenu(menuCourses03);

		IMenu menuLecturers = new Menu("Work with Lecturers", 2);
		IMenu menuLecturers01 = new Menu("Create new Lecturer", 1, new NewLecturerAction(requestHandler));
		IMenu menuLecturers02 = new Menu("Print all Lecturers", 2, new PrintAllLecturers(requestHandler));
		IMenu menuLecturers03 = new Menu("Back", 3);
		menuLecturers.addMenu(menuLecturers01);
		menuLecturers.addMenu(menuLecturers02);
		menuLecturers.addMenu(menuLecturers03);

		IMenu task6 = new Menu("TASK 6", 3);
		IMenu task61 = new Menu("Прочитать property и добавить студентов на лекцию", 1, new ScheduleAction(requestHandler));
		IMenu task62 = new Menu("Клонировать курс", 2, new CloneCourseAction(requestHandler));
		IMenu task63 = new Menu("Serialize", 3, new SerializationAction(requestHandler));
		IMenu task64 = new Menu("DeSerialize", 4, new DeSerializationAction(requestHandler));
		IMenu task65 = new Menu("Import Courses from file", 5, new CoursesImportAction(requestHandler));
		IMenu task66 = new Menu("Export Courses to file", 6, new CoursesExportAction(requestHandler));
		IMenu task67 = new Menu("Back", 7);
		task6.addMenu(task61);
		task6.addMenu(task62);
		task6.addMenu(task63);
		task6.addMenu(task64);
		task6.addMenu(task65);
		task6.addMenu(task66);
		task6.addMenu(task67);

		IMenu calculate = new Menu("Посчитать все сущности", 4, new TotalCalculationAction(requestHandler));
		IMenu menuExit = new Menu("Exit", 5);
		menus.add(menuCourses);
		menus.add(menuLecturers);
		menus.add(task6);
		menus.add(calculate);
		menus.add(menuExit);

	}

	public List<IMenu> getMenus() {
		return menus;
	}

}
