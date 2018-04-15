import java.util.Date;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) throws Exception {
		ArrayList<Passanger> passangers = new ArrayList<>();
		ArrayList<Pilot> pilots = new ArrayList<>();
		ArrayList<PlainStaff> staff = new ArrayList<>();
		ArrayList<Licence> licences = new ArrayList<>();

		System.out.println(" Creation of 4 passenger:");
		for (int i = 0; i < 4; ++i) {
			passangers.add(new Passanger("name" + i, "surname" + i, new Date(), i % 2));

		}

		System.out.println(" Creation of 2 licences:");
		for (int i = 0; i < 2; ++i) {
			licences.add(new Licence("qwe12234" + i, new Date(), new Date()));

		}

		System.out.println("  Creation of 2 pilots:");
		for (int i = 0; i < 2; ++i) {
			pilots.add(new Pilot("name" + i, "surname" + i, new Date(), 100 + i, (i + 1) * 5, "unit" + 1, 3000 + i, licences.get(i), "grade"));
		}

		System.out.println("  Creation of 2 staff:");
		for (int i = 0; i < 2; ++i) {
			staff.add(new PlainStaff("name" + i, "surname" + i, new Date(), 1000 + i, (i + 1) * 5, "unit" + 1, "position" + 1));
		}

		System.out.println("  Creation of plain:");
		Plane plane = new Plane(13622, "Boeing", "type");

		System.out.println("  Creation of flight authorithation:");
		FlightAuthorization flightAuthorization = new FlightAuthorization(123, new Date(), true);

		System.out.println("  Creation of flight:");
		Flight flight = new Flight(222, plane, pilots, staff, 12, flightAuthorization);

		System.out.println("  Creation of controlRoom:");
		ControlRoom controlRoom = new ControlRoom(55);

		System.out.println("  Creation of airport:");
		Airport airport = new Airport(1, "name", "location", controlRoom);
	}
}