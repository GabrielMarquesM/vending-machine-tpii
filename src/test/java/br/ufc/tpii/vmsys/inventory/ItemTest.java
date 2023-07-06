package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void testItem() {

		int count = 3;
		double price = 3.25;
		String name = "Butter";

		Item item = new Item(name, price, count);
		assertEquals(item.getName(), name);
		assertEquals(item.getPrice(), price);
		assertEquals(item.getCount(), count);

		// Null String
		assertThrows(NullPointerException.class, () -> {
			new Item(null, 5.2, 3);
		});

		// Empty String
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("", 5.2, 3);
		});

		// < 0 Price and Count
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Water", -1, 3);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Water", 5.2, -1);
		});

		// == 0 Price and Count
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Water", 0.0, 3);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Water", 5.2, 0);
		});

	}

	@Test
	void testGetName() {
		int count = 3;
		double price = 3.25;
		String name = "Butter";

		Item item = new Item(name, price, count);
		assertEquals(item.getName(), name);
	}

	@Test
	void testGetPrice() {
		int count = 3;
		double price = 3.25;
		String name = "Butter";

		Item item = new Item(name, price, count);
		assertEquals(item.getPrice(), price);

	}

	@Test
	void testSetPrice() {
		int count = 3;
		double price = 3.25;
		double newPrice = 6.86;
		String name = "Butter";

		Item item = new Item(name, price, count);

		item.setPrice(newPrice);

		assertEquals(item.getPrice(), newPrice);

		// < 0
		assertThrows(IllegalArgumentException.class, () -> {
			Item item_1 = new Item("Water", 2, 3);
			item_1.setPrice(-1.0);

		});

		// == 0
		assertThrows(IllegalArgumentException.class, () -> {
			Item item_1 = new Item("Water", 2, 3);
			item_1.setPrice(0.0);

		});

	}

	@Test
	void testGetCount() {
		int count = 3;
		double price = 3.25;
		String name = "Butter";

		Item item = new Item(name, price, count);
		assertEquals(item.getCount(), count);

	}

	@Test
	void testDecCount() {
		int count = 3;
		double price = 3.25;
		String name = "Butter";

		Item item = new Item(name, price, count);

		for (int i = 0; i < 2; i++) {
			item.decCount();
		}

		assertEquals(item.getCount(), count - 2);

		// Cannot be negative
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Water", 1, 3);
			for (int i = 0; i < 4; i++) {
				item.decCount();
			}
		});

	}

	@Test
	void testIncCount() {
		int count = 3;
		double price = 3.25;
		String name = "Butter";

		Item item = new Item(name, price, count);

		for (int i = 0; i < 2; i++) {
			item.incCount();
		}

		assertEquals(item.getCount(), count + 2);
	}

}
