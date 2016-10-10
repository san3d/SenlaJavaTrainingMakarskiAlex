package task3_3;

public class Main {
	public static void main(String[] args) {
		Firm firm1 = new Firm("MicroKat");

		Accountants ac1 = new Accountants("Ann Bondarchuk", 100, "Accounting");
		Programmers pr1 = new Programmers("Boris Kot", 200, "IT project");
		Programmers pr2 = new Programmers("Olia Eroshina", 300, "IT project");

		firm1.addEmploy(ac1);
		firm1.addEmploy(pr1);
		firm1.addEmploy(pr2);

		firm1.calculateSummarySalary();
		System.out.println("Total salary = " + firm1.getSummarySalary());
	}
}
