package com.senla.task5.courseui.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

//import com.senla.task5.coursebase.controller.Facade;
//import com.senla.task5.coursebase.controller.FacadeBuilder;
import com.senla.task5.courseui.menu.interfaces.IMenu;
import com.senla.task8.service.RequestHandler;

public class Navigator {

	private Navigator() {
	}

	private static class SingletonHelper {
		private static final Navigator INSTANCE = new Navigator();
	}

	public static Navigator getInstance() {
		return SingletonHelper.INSTANCE;
	}

	private final static String EXIT_ACTION = "* Exit!";
	private MenuBuilder menuBuilder;
	private Scanner scanner;
	private Logger logger = Logger.getLogger(Navigator.class);

	public void startMenu(RequestHandler requestHandler) {

		menuBuilder = new MenuBuilder(requestHandler);
		List<IMenu> rootMenu = menuBuilder.getMenus();
		Printer.printMenu(rootMenu);
		scanner = new Scanner(System.in);

		block:

		while (scanner.hasNextInt()) {
			try {
				Integer number = scanner.nextInt();
				for (IMenu menu : rootMenu) {
					if (menu.getMenuID().equals(number)) {
						if (menu.getAction() == null) {
							Printer.printMenu(menu.getMenus());
							scanner = new Scanner(System.in);
							while (scanner.hasNext()) {
								Integer numbers = scanner.nextInt();
								for (IMenu menus : menu.getMenus()) {
									if (menus.getMenuID().equals(numbers) && menus.getAction() != null) {
										menus.getAction().process();
										Printer.printMenu(menu.getMenus());
									}
								}
								if (numbers.equals(menu.getMenus().size())) {
									Printer.printMenu(rootMenu);
									break;
								}
							}
						} else {
							menu.getAction().process();
							Printer.printMenu(rootMenu);
						}
					} else {
						if (number.equals(rootMenu.size())) {
							Printer.print(EXIT_ACTION);
							break block;
						}
					}
				}
			} catch (InputMismatchException e) {
				logger.error(e.getMessage());
				startMenu(requestHandler);
				break;
			}
		}
		scanner.close();
	}
}
