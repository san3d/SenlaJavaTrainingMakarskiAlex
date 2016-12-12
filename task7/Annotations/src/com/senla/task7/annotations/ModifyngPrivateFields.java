package com.senla.task7.annotations;

import java.lang.reflect.Field;

public class ModifyngPrivateFields {

	/*public static void main(String[] args) throws Exception {
		WithPrivateFinalField pf = new WithPrivateFinalField();
		run(pf);
	}*/

	public static void run(Object object) {
		Class<?> class1 = (Class<?>) object;
		System.out.println("(Class<?>) object = "+(Class<?>) object);
		for (Field f : class1.getDeclaredFields()) {
			if (f.isAnnotationPresent(ConfigProperty.class)) {
				//System.out.println("yes");
				f.setAccessible(true);
				try {
					f.setInt(object, 47);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				System.out.println(object);
			}
		}

		/*
		 * for (int i=0; i<class1.getDeclaredFields().length; i++){
		 * System.out.println(class1.getDeclaredFields()[i].getName()); if
		 * (class1.getDeclaredFields()[i].getName().equals("i")){ Field f =
		 * class1.getDeclaredFields()[i]; f.setAccessible(true); try {
		 * f.setInt(object, 47); } catch (IllegalArgumentException |
		 * IllegalAccessException e) { e.printStackTrace(); }
		 * System.out.println(object); }; }
		 * 
		 * /* f = pf.getClass().getDeclaredField("s"); f.setAccessible(true);
		 * f.set(pf, "MODIFY S"); System.out.println(pf);
		 */

		/*
		 * Field n = pf.getClass().getDeclaredField("s2");
		 * n.setAccessible(true); n.set(pf, "MODIFY S2");
		 * System.out.println(pf);
		 */
	}
}
