import java.util.Date;

public class Passanger extends Person {
	private int passangerClass;

	public Passanger(String name, String surname, Date birthDate, int passangerClass) {
		super(name, surname, birthDate);
		this.passangerClass = passangerClass;
		System.out.println("Class constructor " + Passanger.class.getSimpleName());
	}

	public int getPassangerClass() {
		return passangerClass;
	}
}