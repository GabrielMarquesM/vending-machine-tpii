package br.ufc.tpii.vmsys.inventory.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ItemNotFoundTest {

	@Test
	void testItemNotFound() {
		assertThrows(ItemNotFound.class, () -> {
			throw new ItemNotFound();
		});
	}
}
