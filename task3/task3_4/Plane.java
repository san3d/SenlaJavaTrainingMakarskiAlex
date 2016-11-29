package task3_4;

public class Plane {

	private int id;
	private String boardNumber;
	private int quantitySeats;
	public Plane(String bn, int qs) {
		id++;
		boardNumber = bn;
		quantitySeats = qs;
		System.out.println("Plane Board : " + boardNumber + " is created!");
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

	public String getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(String bn) {
		boardNumber = bn;
	}

	public int getQuantitySeats() {
		return quantitySeats;
	}

}