import java.util.Date;

public abstract class Employee extends Person {
	private int id;
	private int experience;
	private String unit;

	public Employee(String name, String surname, Date birthDate, int id, int experience, String unit) {
		super(name, surname, birthDate);
		this.id = id;
		this.experience = experience;
		this.unit = unit;
		System.out.println("Class constructor " + Employee.class.getSimpleName());
	}

	public int getExperience() {
		return experience;
	}

	public void incrementExperience() {
		experience++;
	}

	public String getUnit() {
		return unit;
	}

	public void transferToAnotherUnit(String unit) {
		this.unit = unit;
	}

	public void delete() {
		//
	}

	public int getId() {
		return id;
	}
}