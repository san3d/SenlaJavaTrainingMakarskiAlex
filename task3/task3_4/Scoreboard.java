package task3_4;

public class Scoreboard {

	private Flight[] flights = new Flight[10];

	public void getFlights() {
		System.out.println("Flights on Scoreboard: ");
		System.out.println("¹ - DeparturePlace - ArrivalPlace - ArrivalTime - Status - FreeSeats");
		int n = 1;
		for (int i = 0; i < flights.length; i++) {
			if (flights[i] != null) {
				System.out.println(n + ": " + flights[i].getDeparturePlace() + "-" + flights[i].getArrivalPlace() + "-"
						+ flights[i].getArrivalTime() + "-" + flights[i].getStatus()+ "-" + flights[i].getFreeSeats());
				n++;
			} else
				break;
		}
	}

	public void addFlight(Flight newFlight) {
		// public void addPassengers(Passenger newPassenger) {
		for (int i = 0; i < flights.length; i++) {
			if (flights[i] == null) {
				flights[i] = newFlight;
				System.out.println("Flight '" + flights[i].getDeparturePlace() + "-" + flights[i].getArrivalPlace()
						+ "' is included on Scoreboard");
				break;
			}
		}

	}
}
