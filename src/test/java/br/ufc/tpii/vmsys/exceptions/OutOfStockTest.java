package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OutOfStockTest {

	@Test
	void testOutOfStock() {
		assertThrows(OutOfStock.class, () -> {
			throw new OutOfStock();
		});
	}

}
