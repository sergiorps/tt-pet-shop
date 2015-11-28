package br.com.tt.web.pet.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CpfUtilTest {

	@Test
	public void testRemoveMascara() {
		assertEquals("12345678977", CpfUtil.removeMascara("123.456.789-77"));
	}

}
