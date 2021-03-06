package com.senla.task5.courseui.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.task5.coursebase.controller.Facade;
import com.senla.task5.coursebase.controller.FacadeBuilder;
import com.senla.task5.courseui.menu.interfaces.IMenu;

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
	private MenuBuilder menuBuilder = new MenuBuilder();
	private Scanner scanner;
	private Logger logger = Logger.getLogger(Navigator.class);

	@SuppressWarnings("unused")
	private Facade facade = FacadeBuilder.buildFacade();

	public void startMenu() {

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
				startMenu();
				break;
			}
		}
		scanner.close();
	}
}
