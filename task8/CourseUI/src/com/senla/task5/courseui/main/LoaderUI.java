package com.senla.task5.courseui.main;

//import com.senla.task5.coursebase.controller.Facade;
//import com.senla.task5.coursebase.controller.interfaces.IFacade;
import com.senla.task5.courseui.controller.FacadeInjector;
import com.senla.task5.courseui.controller.Navigator;

public class LoaderUI {

	@SuppressWarnings("unused")
	private static FacadeInjector facadeInjector;
	
	public static void start() {
		facadeInjector = new FacadeInjector();
		
		//System.out.println("getMaxQuantityStudentsOnDay()="+facade.getMaxQuantityStudentsOnDay());

		Navigator.getInstance().startMenu();
	}
}
