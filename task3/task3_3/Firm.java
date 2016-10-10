package task3_3;

public class Firm {
	private int totalSalary;
	private Employ[] employ = new Employ[10];
	private String firmName;

	public Firm(String firmName) {
		this.firmName = firmName;
		System.out.println("Firm " + firmName + " created!");
	}

	public void addEmploy(Employ person) {
		for (int i = 0; i < employ.length; i++) {
			if (employ[i] == null) {
				employ[i] = person;
				System.out.println("Employer " + person.getName() + " work on " + firmName);
				break;
			}
		}
	}

	public Employ[] getSet() {
		return employ;
	}

	public void calculateSummarySalary() {
		int n = 0;
		System.out.println("Calculating salary :");
		for (int i = 0; i < employ.length; i++) {
			if (employ[i] != null) {
				n = n + employ[i].getSalary();
				System.out.println(employ[i].getSalary());
			}
		}
		this.totalSalary = n;
	}

	public int getSummarySalary() {
		return totalSalary;
	}

}
