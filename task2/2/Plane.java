public class Plane {
	private int id;
	private String companyName;
	private String type;

	public Plane(int id, String companyName, String type) {
		this.id = id;
		this.companyName = companyName;
		this.type = type;
		System.out.println("Class constructor " + Plane.class.getSimpleName());
	}
}