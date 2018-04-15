import java.util.ArrayList;
import java.util.List;

public class ControlRoom {
	private int id;
	private ArrayList<Flight> flights;

	public ControlRoom(int id) {
		this.id = id;
		System.out.println("Class constructor " + ControlRoom.class.getSimpleName());
	}

	public int getId() {
		return id;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void addFlight(Flight flight) {
		flights.add(flight);
	}
}