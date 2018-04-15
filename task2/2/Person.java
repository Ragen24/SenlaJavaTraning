import java.util.Date;

public abstract class Person {
	private String name;
	private String surname;
	private Date birthDate;

	public Person(String name, String surname, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		System.out.println("Class constructor " + Person.class.getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}
}