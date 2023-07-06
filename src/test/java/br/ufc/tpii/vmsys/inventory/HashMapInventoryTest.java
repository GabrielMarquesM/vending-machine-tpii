package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.inventory.exceptions.ItemAlreadyAdded;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemNotFound;

class HashMapInventoryTest {

	@Test
	void testHashMapInventory() {
		HashMapInventory inventory = new HashMapInventory();
		assertEquals(inventory.numberOfItems(), 0);
	}

	@Test
	void testAddItem() throws ItemNotFound {
		int count = 3;
		double price = 3.25;
		String name = "Butter";

		HashMapInventory inventory = new HashMapInventory();
		Item item = new Item(name, price, count);

		try {
			inventory.addItem(item);
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ItemAlreadyAdded e) {
			fail();
		}

		assertEquals(inventory.numberOfItems(), 1);

		assertThrows(ItemAlreadyAdded.class, () -> {
			inventory.addItem(item);
		});
	}

	@Test
	void testRemoveItem() {
		HashMapInventory inventory = new HashMapInventory();

		try {
			inventory.addItem(new Item("Butter", 3.25, 7));
			inventory.addItem(new Item("Soda", 2.00, 15));
			inventory.addItem(new Item("Pizza", 25.5, 20));
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ItemAlreadyAdded e) {
			fail();
		}

		try {
			inventory.removeItem("Soda");
		} catch (ItemNotFound e) {
			fail();
		}

		assertEquals(inventory.numberOfItems(), 2);

		assertThrows(ItemNotFound.class, () -> {
			inventory.removeItem("Chocolate");
		});

	}

	@Test
	void testGetItem() {
		HashMapInventory inventory = new HashMapInventory();

		int count = 3;
		double price = 3.25;
		String name = "Butter";
		Item item = new Item(name, price, count);

		try {
			inventory.addItem(item);
		} catch (IllegalArgumentException e) {
			fail();
		} catch (ItemAlreadyAdded e) {
			fail();
		}

		try {
			assertEquals(name, inventory.getItem(name).getName());
		} catch (ItemNotFound e) {
			fail();
		}

		assertThrows(ItemNotFound.class, () -> {
			inventory.getItem("Not an Item").getName();
		});

	}

	@Test
	void testNumberOfItems() {
		HashMapInventory inventory = new HashMapInventory();

		try {
			inventory.addItem(new Item("Butter", 3.25, 7));
			inventory.addItem(new Item("Soda", 2.00, 15));
			inventory.addItem(new Item("Pizza", 25.5, 20));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ItemAlreadyAdded e) {
			e.printStackTrace();
		}

		assertEquals(inventory.numberOfItems(), 3);

		try {
			inventory.removeItem("Soda");
		} catch (ItemNotFound e) {
			e.printStackTrace();
		}

		assertEquals(inventory.numberOfItems(), 2);
	}

}
