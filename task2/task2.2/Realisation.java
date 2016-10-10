

public class Realisation {
	public  static  void main(String[] args){
		// ������ ����������
		Passenger passenger1 = new Passenger("Oleg", "Ivanov", 22);
		Passenger passenger2 = new Passenger("Olga", "Ivanova", 21);
		
		// ������ travel
		Travel travel = new Travel("Grodno", "Minsk");
		
		// ������ ������
		Equipage �quipage = new Equipage();

		// ������ �����������
		Meteorologist meteorologist = new Meteorologist();

		// ������ ������
		Plane plane = new Plane("SA3000");
		plane.addPassengers(passenger1);
		plane.addPassengers(passenger2);
		plane.setTravelId(travel);
		plane.setEquipageId(�quipage);
		System.out.println("-----------------------------");
		
		System.out.println("������, �������� ����� "+plane.getBoardNumber());
		System.out.println("����: "+travel.getPlaces());
		System.out.println("������ �������: " + �quipage.getPilotsList());
		System.out.println("������ ���������: " + �quipage.getPersonnelList());
		System.out.println("���������� �� ����: " + meteorologist.getFlightPermission());
		System.out.println("���������� ����������: "+plane.checkPassengersQuantity());
		System.out.println("������ ����������:");
		plane.getPassengers();				
	}
			
}
