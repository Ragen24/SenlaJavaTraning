import java.util.Date;

public class PlainStaff extends Employee{
	private String position;

	public PlainStaff(String name, String surname, Date birthDate, int id, int experience, String unit, String position) {
		super(name, surname, birthDate, id, experience, unit);
		this.position = position;
		System.out.println("Class constructor " + PlainStaff.class.getSimpleName());
	}

	public String getPosition() {
		return position;
	}
}