package entity;

import java.util.Objects;

public class InfoBill {
	private Food food;
	private int quantity;

	public InfoBill(Food food, int quantity) {
		super();
		this.food = food;
		this.quantity = quantity;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void insertQuantity(int i) {
		this.quantity += i;
	}

	@Override
	public int hashCode() {
		return Objects.hash(food);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoBill other = (InfoBill) obj;
		return Objects.equals(food, other.food);
	}

	public int totalPrice() {
		return (int) (food.getPrice() - (food.getPrice() * food.getDiscount()) / 100) * quantity;
	}

}
