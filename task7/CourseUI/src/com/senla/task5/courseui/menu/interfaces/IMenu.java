package com.senla.task5.courseui.menu.interfaces;

import java.util.List;

import com.senla.task5.courseui.action.interfaces.IAction;

public interface IMenu {

	public IAction getAction();
	public String getMenuTitle();
    public void setMenuName(String menuName);
	public Integer getMenuID();
    public void setID(Integer id);
	public List<IMenu> getMenus();
    public void addMenu(IMenu menu);

}


