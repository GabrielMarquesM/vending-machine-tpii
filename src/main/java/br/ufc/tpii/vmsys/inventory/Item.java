package br.ufc.tpii.vmsys.inventory;

public class Item {
	private String name;
	private double price = 0.0;
	private int count = 0;

	public Item(String name, double price, int count) throws IllegalArgumentException {
		this.name = name;

		if (name == null) {
			throw new NullPointerException("Name needs to be of type string and not null");
		}

		if (name.isEmpty()) {
			throw new IllegalArgumentException("Item name cant be empty");

		}

		if (price <= 0.0) {
			throw new IllegalArgumentException("Item " + this.name + " price cannot be negative");
		}

		if (count <= 0) {
			throw new IllegalArgumentException("Item " + this.name + " count cannot be negative: " + count);
		}

		this.price = price;
		this.count = count;

	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0.0) {
			throw new IllegalArgumentException("Item " + this.name + " price cannot be negative");
		}
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void decCount() throws IllegalArgumentException {
		if (this.count == 0.0) {
			throw new IllegalArgumentException("Item " + this.name + "cannot be decremented because its already zero");
		}
		this.count--;
	}

	public void incCount() {
		this.count++;
	}
}