

public class Realisation {
	public  static  void main(String[] args){
		// создаём пассажиров
		Passenger passenger1 = new Passenger("Oleg", "Ivanov", 22);
		Passenger passenger2 = new Passenger("Olga", "Ivanova", 21);
		
		// создаём travel
		Travel travel = new Travel("Grodno", "Minsk");
		
		// создаём Экипаж
		Equipage еquipage = new Equipage();

		// создаём Метеоролога
		Meteorologist meteorologist = new Meteorologist();

		// создаём Самолёт
		Plane plane = new Plane("SA3000");
		plane.addPassengers(passenger1);
		plane.addPassengers(passenger2);
		plane.setTravelId(travel);
		plane.setEquipageId(еquipage);
		System.out.println("-----------------------------");
		
		System.out.println("Самолёт, бортовой номер "+plane.getBoardNumber());
		System.out.println("Рейс: "+travel.getPlaces());
		System.out.println("Список пилотов: " + еquipage.getPilotsList());
		System.out.println("Список персонала: " + еquipage.getPersonnelList());
		System.out.println("Разрешение на полёт: " + meteorologist.getFlightPermission());
		System.out.println("Количество пассажиров: "+plane.checkPassengersQuantity());
		System.out.println("Список пассажиров:");
		plane.getPassengers();				
	}
			
}
