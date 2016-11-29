package task3_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {

	private int id;
	private String departurePlace;
	private String arrivalPlace;
	private String arrivalTime;
	private Passenger[] passengers = new Passenger[10];
	private Plane plane;
	private String status;
	private int freeSeats;

	public Flight(String dp, String ap) {
		id++;
		departurePlace = dp;
		arrivalPlace = ap;
		System.out.println("Flight '" + departurePlace + "-" + arrivalPlace + "' created!");
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String depPlace) {
		departurePlace = depPlace;
	}

	public String getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(String arPlace) {
		arrivalPlace = arPlace;
	}

	public String getPlaces() {
		return departurePlace + "-" + arrivalPlace;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Plane getPlane() {
		return plane;
	}

	public void getPassengers() {
		System.out.println("Passengers on Flight " + departurePlace + "-" + arrivalPlace + " : ");
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				System.out.println(passengers[i].getName() + " " + passengers[i].getSurname() + " ("
						+ passengers[i].getAge() + ")");
			} else
				break;
		}
	}

	public void addPassengers(Passenger newPassenger) {
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] == null) {
				passengers[i] = newPassenger;
				System.out.println("Passenger Name: " + passengers[i].getName() + " is included in Flight : "
						+ departurePlace + "-" + arrivalPlace);
				break;
			}
		}
	}

	public void deletePassenger(int i) {
		System.out.println("Passenger Name: " + passengers[i].getName() + " is deleted from Flight : " + departurePlace
				+ "-" + arrivalPlace);
		passengers[i] = null;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String date) {
		/*
		 * throws ParseException { SimpleDateFormat y = new SimpleDateFormat(
		 * "yyyy.MM.dd HH:mm"); Date arrival = y.parse(date); this.arrivalTime =
		 * arrival.toString();
		 */
		this.arrivalTime = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatusNormal() {
		this.status = "Normal";
	}

	public void setStatusDelay() {
		this.status = "Delayed";
	}

	public void setStatusCanceled() {
		this.status = "Cancelled";
	}

	public int getFreeSeats() {
		int n = 0;
		if (passengers.length != 0) {
			for (int i = 0; i < passengers.length; i++) {
				if (passengers[i] != null)
					n++;
			}
		}
		freeSeats = (plane.getQuantitySeats() - n);
		return freeSeats;
	}

}