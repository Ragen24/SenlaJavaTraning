 import java.util.Date;

 public class FlightAuthorization {
 	private int id;
 	private Date date;
 	private boolean status;

 	public FlightAuthorization(int id, Date date, boolean status) {
 		this.id = id;
 		this.date = date;
 		this.status = status;
 		System.out.println("Class constructor " + FlightAuthorization.class.getSimpleName());
 	}

 	public int getId() {
 		return id;
 	}

 	public Date getTime() {
 		return date;
 	}

 	public void updateTime(Date newDate) {
 		this.date = newDate;
 	}

 	public boolean getStatus() {
 		return status;
 	}

 	public void updateStatus(boolean status) {
 		this.status = status;
 	}
 }