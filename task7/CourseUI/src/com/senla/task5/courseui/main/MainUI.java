package com.senla.task5.courseui.main;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.controller.FacadeInjector;
import com.senla.task5.courseui.controller.Navigator;

public class MainUI {

	@SuppressWarnings("unused")
	private static FacadeInjector facadeInjector;
	
	public static void main(String[] a) {
		facadeInjector = new FacadeInjector();
		
		IFacade facade = new Facade();
		System.out.println("getMaxQuantityStudentsOnDay()="+facade.getMaxQuantityStudentsOnDay());

		Navigator.getInstance().startMenu();
	}
}
