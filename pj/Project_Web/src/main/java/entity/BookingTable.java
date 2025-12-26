package entity;

public class BookingTable {
	private String email;
	private String phone;
	private String date;
	private String quantity;
	private String time;

	public BookingTable(String email, String phone, String date, String quantity, String time) {
		super();
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.quantity = quantity;
		this.time = time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
