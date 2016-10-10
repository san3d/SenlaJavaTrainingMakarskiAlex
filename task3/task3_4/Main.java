package task3_4;

import java.text.ParseException;

public class Main {
	public static void main(String[] args) throws ParseException {
		//�������� ������ ������
		Plane plane1 = new Plane("Boing 555", 15);
		
		// �������� ���������� ��� ������� �������
		Passenger pas11 = new Passenger("Jorge", "Butt", 23);
		Passenger pas12 = new Passenger("Olga", "Leta", 35);
		Passenger pas13 = new Passenger("Viktor", "Tsoi", 68);
		System.out.println();
		
		// �������� ������ ����
		Flight flight1 = new Flight("Grodno", "Minsk");
		flight1.setArrivalTime("2016.10.10 12:48");
		System.out.println("Arrival time : " + flight1.getArrivalTime());
		flight1.setPlane(plane1); //������� ������ � ����
		flight1.setStatusDelay(); // ��������� ������ "��������"
		Scoreboard sc = new Scoreboard();
		sc.addFlight(flight1);// ������� ���� �� �����
		System.out.println();

		// ������� ���������� � ������ ����
		flight1.addPassengers(pas11);
		flight1.addPassengers(pas12);
		flight1.addPassengers(pas13);
		flight1.getPassengers();// ������� ������ ����������
		System.out.println();

		//�������� ������ ������
		Plane plane2 = new Plane("Samol 111", 20);
		
		// �������� ���������� ��� ������� �����
		Passenger pas21 = new Passenger("Bill", "Korn", 32);
		Passenger pas22 = new Passenger("Aaa", "Bbb", 33);
		Passenger pas23 = new Passenger("Oleg", "Zubkov", 29);
		Passenger pas24 = new Passenger("Vika", "Osen", 25);
		System.out.println();

		// �������� ������ ����
		Flight flight2 = new Flight("Moscow", "NewYork");
		flight2.setArrivalTime("2016.10.10 15:53");
		System.out.println("Arrival time : " + flight2.getArrivalTime());
		flight2.setPlane(plane2); //������� ������ � ����
		flight2.setStatusNormal(); // ��������� ������ "����������"
		sc.addFlight(flight2);// ������� ���� �� �����
		System.out.println();

		// ������� ���������� �� ������ ����
		flight2.addPassengers(pas21);
		flight2.addPassengers(pas22);
		flight2.addPassengers(pas23);
		flight2.getPassengers();// ������� ������ ����������
		//������ ������� ���������
		flight2.deletePassenger(1); //���� �� ����� � �������, ����� ����� ������� ����������
		// ������� ��� ��������� �� ������ ����
		flight2.addPassengers(pas24);
		flight2.getPassengers();// ������� ������ ����������
		System.out.println();
		
		//�������� ������ ������
		Plane plane3 = new Plane("Rawen F15", 20);
		
		// �������� ���������� ��� �������� �����
		//Passenger pas31 = new Passenger("Qqq", "Www", 44);
		
		// �������� ������ ����
		Flight flight3 = new Flight("Tallin", "Berlin");
		flight3.setArrivalTime("2016.10.15 10:30");
		System.out.println("Arrival time : " + flight3.getArrivalTime());
		flight3.setPlane(plane3); //������� ������ � ����
		flight3.setStatusCanceled(); // ��������� ������ "������"
		sc.addFlight(flight3);// ������� ������ �� �����
		System.out.println("��������� ����"+flight3.getFreeSeats());

		// ������� ���������� �� �����
		sc.getFlights();

	}
}
