package com.senla.task5.courseui.menu;

import java.util.ArrayList;
import java.util.List;

import com.senla.task5.courseui.action.interfaces.IAction;
import com.senla.task5.courseui.menu.interfaces.IMenu;

public class Menu implements IMenu {

	private String title;
	private Integer menuID;
	private IAction action = null;
	private List<IMenu> menus = new ArrayList<>();

	public Menu(String title, Integer menuID) {
		this.title = title;
		this.menuID = menuID;
	}

	public Menu(String title, Integer menuID, IAction action) {
		this(title, menuID);
		this.action = action;
	}

	public String getMenuTitle() {
		return this.title;
	}

	public void setMenuName(String newTitle) {
		this.title = newTitle;
	}

	public Integer getMenuID() {
		return menuID;
	}

	public void setID(Integer id) {
		this.menuID = id;
	}

	public List<IMenu> getMenus() {

		return this.menus;
	}

	public void addMenu(IMenu menu) {
		menus.add(menu);
	}

	public IAction getAction() {
		return action;
	}

}
