package com.senla.task5.courseui.main;

import com.senla.task5.courseui.controller.Navigator;
import com.senla.task8.service.RequestHandler;

public class MainUI {

	public static void main(String[] a) {
		RequestHandler requestHandler = new RequestHandler(null);
		Navigator.getInstance().startMenu(requestHandler);
	}
}
