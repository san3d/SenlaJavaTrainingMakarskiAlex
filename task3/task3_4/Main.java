package task3_4;

import java.text.ParseException;

public class Main {
	public static void main(String[] args) throws ParseException {
		//создадим первый самолЄт
		Plane plane1 = new Plane("Boing 555", 15);
		
		// создадим пассажиров дл€ первого самолЄта
		Passenger pas11 = new Passenger("Jorge", "Butt", 23);
		Passenger pas12 = new Passenger("Olga", "Leta", 35);
		Passenger pas13 = new Passenger("Viktor", "Tsoi", 68);
		System.out.println();
		
		// создадим первый рейс
		Flight flight1 = new Flight("Grodno", "Minsk");
		flight1.setArrivalTime("2016.10.10 12:48");
		System.out.println("Arrival time : " + flight1.getArrivalTime());
		flight1.setPlane(plane1); //ƒобавим самолЄт в рейс
		flight1.setStatusDelay(); // установим статус "задержан"
		Scoreboard sc = new Scoreboard();
		sc.addFlight(flight1);// добавим рейс на табло
		System.out.println();

		// добавим пассажиров в первый рейс
		flight1.addPassengers(pas11);
		flight1.addPassengers(pas12);
		flight1.addPassengers(pas13);
		flight1.getPassengers();// выведем список пассажиров
		System.out.println();

		//создадим второй самолЄт
		Plane plane2 = new Plane("Samol 111", 20);
		
		// создадим пассажиров дл€ второго рейса
		Passenger pas21 = new Passenger("Bill", "Korn", 32);
		Passenger pas22 = new Passenger("Aaa", "Bbb", 33);
		Passenger pas23 = new Passenger("Oleg", "Zubkov", 29);
		Passenger pas24 = new Passenger("Vika", "Osen", 25);
		System.out.println();

		// создадим второй рейс
		Flight flight2 = new Flight("Moscow", "NewYork");
		flight2.setArrivalTime("2016.10.10 15:53");
		System.out.println("Arrival time : " + flight2.getArrivalTime());
		flight2.setPlane(plane2); //ƒобавим самолЄт в рейс
		flight2.setStatusNormal(); // установим статус "нормальный"
		sc.addFlight(flight2);// добавим рейс на табло
		System.out.println();

		// добавим пассажиров во второй рейс
		flight2.addPassengers(pas21);
		flight2.addPassengers(pas22);
		flight2.addPassengers(pas23);
		flight2.getPassengers();// выведем список пассажиров
		//удалим второго пассажира
		flight2.deletePassenger(1); //тупо по р€дку в массиве, потом можно красиво доработать
		// добавим ещЄ пассажира во второй рейс
		flight2.addPassengers(pas24);
		flight2.getPassengers();// выведем список пассажиров
		System.out.println();
		
		//создадим третий самолЄт
		Plane plane3 = new Plane("Rawen F15", 20);
		
		// создадим пассажиров дл€ третьего рейса
		//Passenger pas31 = new Passenger("Qqq", "Www", 44);
		
		// создадим третий рейс
		Flight flight3 = new Flight("Tallin", "Berlin");
		flight3.setArrivalTime("2016.10.15 10:30");
		System.out.println("Arrival time : " + flight3.getArrivalTime());
		flight3.setPlane(plane3); //ƒобавим самолЄт в рейс
		flight3.setStatusCanceled(); // установим статус "отменЄн"
		sc.addFlight(flight3);// добавим самолЄт на табло
		System.out.println("—вободных мест"+flight3.getFreeSeats());

		// выведем информацию на табло
		sc.getFlights();

	}
}
