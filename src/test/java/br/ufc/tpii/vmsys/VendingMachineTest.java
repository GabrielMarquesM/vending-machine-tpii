package br.ufc.tpii.vmsys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.exceptions.InsufficientFunds;
import br.ufc.tpii.vmsys.exceptions.InvalidSelection;
import br.ufc.tpii.vmsys.exceptions.OutOfStock;
import br.ufc.tpii.vmsys.inventory.HashMapInventory;
import br.ufc.tpii.vmsys.inventory.Inventory;
import br.ufc.tpii.vmsys.inventory.Item;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemAlreadyAdded;

class VendingMachineTest {

	@Test
	void testVendingMachine() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		assertEquals(vm.howManyCoinsLeft(), 0.0);
	}

	@Test
	void testAddCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		vm.addCoins(15);
		assertEquals(vm.howManyCoinsLeft(), 15);
		vm.addCoins(3);
		assertEquals(vm.howManyCoinsLeft(), 18);

		// < 0
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addCoins(-1.0);
		});

		// == 0
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addCoins(0.0);
		});
	}

	@Test
	void testWithdrawRemainingCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		vm.addCoins(15);
		assertEquals(vm.withdrawRemainingCoins(), 15);

		vm.withdrawRemainingCoins();
		assertEquals(vm.howManyCoinsLeft(), 0.0);

	}

	@Test
	void testHowManyCoinsLeft() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		vm.addCoins(15);
		assertEquals(vm.howManyCoinsLeft(), 15);
	}

	@Test
	void testVend() {
		Inventory inv = new HashMapInventory();

		Item item = new Item("Butter", 3.25, 3);
		Item item_2 = new Item("Cake", 6.55, 5);
		Item item_3 = new Item("Soda", 5.12, 1);

		try {
			inv.addItem(item);
			inv.addItem(item_2);
			inv.addItem(item_3);
		} catch (ItemAlreadyAdded e) {
			e.printStackTrace();
		}

		VendingMachine vm = new VendingMachine(inv);

		// Price == Coins
		try {
			vm.addCoins(3.25);
			vm.vend("Butter");
		} catch (Exception e) {
			fail();
		}
		assertEquals(0, vm.howManyCoinsLeft());

		// Price < Coins
		vm.addCoins(15);
		try {
			vm.vend("Butter");
		} catch (InvalidSelection e) {
			fail();
		} catch (OutOfStock e) {
			fail();
		} catch (InsufficientFunds e) {
			fail();
		}
		assertEquals(11.75, vm.howManyCoinsLeft());

		assertThrows(OutOfStock.class, () -> {
			for (int i = 0; i < 2; i++) {
				vm.vend("Soda");
			}
		});

		assertThrows(InvalidSelection.class, () -> {
			vm.vend("Not an item");
		});

		assertThrows(InsufficientFunds.class, () -> {
			vm.withdrawRemainingCoins();
			for (int i = 0; i < 10; i++) {
				vm.vend("Cake");
			}
		});

	}

}
