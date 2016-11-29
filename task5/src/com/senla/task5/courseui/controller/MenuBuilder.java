package com.senla.task5.courseui.controller;

import java.util.ArrayList;
import java.util.List;

import com.senla.task5.courseui.action.ExitAction;
import com.senla.task5.courseui.action.LoadCoursesBaseAction;
import com.senla.task5.courseui.action.NewCourseAction;
import com.senla.task5.courseui.action.NewLecturerAction;
import com.senla.task5.courseui.action.PrintAllLecturers;
import com.senla.task5.courseui.action.SortCoursesAlphabetAction;
import com.senla.task5.courseui.action.TotalCalculationAction;
import com.senla.task5.courseui.menu.Menu;
import com.senla.task5.courseui.menu.interfaces.IMenu;

public class MenuBuilder {

	private List<IMenu> menus;

	public MenuBuilder() {
		menus = new ArrayList<IMenu>();
		IMenu menuCourses = new Menu("Work with Courses", 1);
		IMenu menuCourses01 = new Menu("Load DataBase from \"CoursesBase\"", 1, new LoadCoursesBaseAction());
		IMenu menuCourses02 = new Menu("Create new Course", 2, new NewCourseAction());
		IMenu menuCourses03 = new Menu("Sort Courses by Alphabet", 3, new SortCoursesAlphabetAction());
		IMenu menuCourses04 = new Menu("Back", 4);
		
		menuCourses.addMenu(menuCourses01);
		menuCourses.addMenu(menuCourses02);
		menuCourses.addMenu(menuCourses03);
		menuCourses.addMenu(menuCourses04);

		IMenu menuLecturers = new Menu("Work with Lecturers", 2);
		IMenu menuLecturers01 = new Menu("Create new Lecturer", 1, new NewLecturerAction());
		IMenu menuLecturers02 = new Menu("Print all Lecturers", 2, new PrintAllLecturers());
		IMenu menuLecturers03 = new Menu("Back", 3);
		menuLecturers.addMenu(menuLecturers01);
		menuLecturers.addMenu(menuLecturers02);
		menuLecturers.addMenu(menuLecturers03);

		IMenu fakeMenu = new Menu("Посчитать всех", 3, new TotalCalculationAction());
		IMenu menuExit = new Menu("Exit", 4, new ExitAction());
		menus.add(menuCourses);
		menus.add(menuLecturers);
		menus.add(fakeMenu);
		menus.add(menuExit);

	}

	public List<IMenu> getMenus() {
		return menus;
	}

}
