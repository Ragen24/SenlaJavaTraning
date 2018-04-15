import java.util.Date;

public class Licence {
	private String id;
	private Date issueDate;
	private Date expireDate;

	public Licence(String id, Date issueDate, Date expireDate) {
		this.id = id;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
		System.out.println("Class constructor " + Licence.class.getSimpleName());
	}

	public String getId() {
		return id;
	}

	public Date getExpireDate() {
		return expireDate;
	}
}