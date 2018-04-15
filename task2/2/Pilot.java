import java.util.Date;

public class Pilot extends Employee {
	private int numberOfFlightHours;
	private Licence licence;
	private String grade;

	public Pilot(String name, String surname, Date birthDate, int id, int experience, String unit, 
					int numberOfFlightHours, Licence licence, String grade) {
		super(name, surname, birthDate, id, experience, unit);
		this.numberOfFlightHours = numberOfFlightHours;
		this.licence = licence;
		this.grade = grade;
		System.out.println("Class constructor " + Pilot.class.getSimpleName());
	}

	public void setNewLicence(Licence licence) {
		this.licence = licence;
	}

	public int getNumberOfFlightHours() {
		return numberOfFlightHours;
	}

	public void addNumberOfFlightHours(int add) {
		if (add > 0)
			this.numberOfFlightHours += add;
	}

	public String getGrade() {
		return grade;
	}
}