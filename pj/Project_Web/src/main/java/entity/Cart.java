package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int id;
	private int tableId;
	private int accountId;
	private String nameCustomer;
	private String address;
	private String email;
	private String phone;
	private String note;
	private List<InfoBill> bill;
	private int price;

	public Cart() {
		this.bill = new ArrayList<InfoBill>();
	}

	public Cart(int id, int tableId, int accountId, String nameCustomer, String address, String email, String phone,
			String note, List<InfoBill> bill) {
		this.id = id;
		this.tableId = tableId;
		this.accountId = accountId;
		this.nameCustomer = nameCustomer;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.note = note;
		this.bill = bill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<InfoBill> getBill() {
		return bill;
	}

	public void setBill(List<InfoBill> bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", tableId=" + tableId + ", accountId=" + accountId + ", nameCustomer=" + nameCustomer
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", note=" + note + ", bill=" + bill
				+ "]";
	}

	public int totalBill() {
		int total = 0;
		for (InfoBill infoBill : bill) {
			total += infoBill.totalPrice();
		}
		return total;
	}

	public int totalFood() {
		int total = 0;
		for (InfoBill infoBill : bill) {
			total += infoBill.getQuantity();
		}
		return total;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void main(String[] args) {
		Cart c = new Cart();
		for (InfoBill s : c.bill) {

		}
	}
}
