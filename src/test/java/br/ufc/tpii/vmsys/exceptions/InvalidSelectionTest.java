package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InvalidSelectionTest {

	@Test
	void testInvalidSelection() {
		assertThrows(InvalidSelection.class, () -> {
			throw new InvalidSelection();
		});
	}

}
