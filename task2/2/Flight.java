import java.util.ArrayList;
import java.util.List;

public class Flight {
	private int id;
	private Plane plane;
	private ArrayList<Pilot> pilots;
	private ArrayList<Passanger> passangers = new ArrayList<>();
	private ArrayList<PlainStaff> staff;

	private int boardingGate;
	private FlightAuthorization flightAuthorization;

	public Flight(int id, Plane Plane, ArrayList<Pilot> pilots, ArrayList<PlainStaff> staff, int boardingGate, FlightAuthorization flightAuthorization) {
		this.id = id;
		this.plane = plane;
		this.pilots = pilots;
		this.staff = staff;
		this.boardingGate = boardingGate;
		this.flightAuthorization = flightAuthorization;
		System.out.println("Class constructor " + Flight.class.getSimpleName());
	}

	public int getId() {
		return id;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane() {
		this.plane = plane;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public List<Passanger> getPassangers() {
		return passangers;
	}

	public void addPassanger(Passanger passanger) {
		passangers.add(passanger);
	}

	public void removePassanger(Passanger passanger) {
		passangers.remove(passanger);
	}

	public int getBoardingGate() {
		return boardingGate;
	}

	public void setBoardingGate() {
		this.boardingGate = boardingGate;
	}
}