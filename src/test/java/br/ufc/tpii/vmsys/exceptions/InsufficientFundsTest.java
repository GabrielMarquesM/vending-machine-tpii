package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InsufficientFundsTest {

	@Test
	void testInsufficientFunds() {
		assertThrows(InsufficientFunds.class, () -> {
			throw new InsufficientFunds();
		});

	}

}
