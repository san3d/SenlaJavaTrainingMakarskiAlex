package com.senla.task5.courseui.controller;

import java.util.List;

import com.senla.task5.courseui.menu.interfaces.IMenu;

public class MenuShower {

	public static void showMenu(List<IMenu> listMenus) {
		for (IMenu menu : listMenus) {
			System.out.println(menu.getMenuID() + ": " + menu.getMenuTitle());
		}
	}

}
