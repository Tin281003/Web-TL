package entity;

import java.util.List;

public class Type {
	private String name;
	private List<String> category;

	public Type(String name, List<String> category) {
		super();
		this.name = name;
		this.category = category;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Type [name=" + name + ", category=" + category + "]";
	}

}
