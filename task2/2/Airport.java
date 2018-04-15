public class Airport {
	private int id;
	private String name;
	private String location;
	private ControlRoom controlRoom;

	public Airport(int id, String name, String location, ControlRoom controlRoom) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.controlRoom = controlRoom;
		System.out.println("Class constructor " + Airport.class.getSimpleName());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public ControlRoom getControlRoom() {
		return controlRoom;
	}
}