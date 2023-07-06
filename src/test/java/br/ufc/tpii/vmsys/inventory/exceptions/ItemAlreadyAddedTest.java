package br.ufc.tpii.vmsys.inventory.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ItemAlreadyAddedTest {

	@Test
	void testItemAlreadyAdded() {
		assertThrows(ItemAlreadyAdded.class, () -> {
			throw new ItemAlreadyAdded();
		});

	}
}
