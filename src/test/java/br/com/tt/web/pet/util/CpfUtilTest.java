package br.com.tt.web.pet.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CpfUtilTest {

	@Test
	public void testRemoveMascara() {
		assertEquals("12345678977", CpfUtil.removeMascara("123.456.789-77"));
		assertEquals("12345678977", CpfUtil.removeMascara("12345678977"));
		assertEquals(null, CpfUtil.removeMascara(null));
	}

	@Test
	public void testAdicionaMascara() {
		assertEquals("123.456.789-77", CpfUtil.adicionaMascara("12345678977"));
		assertEquals(null, CpfUtil.adicionaMascara(null));
		assertEquals(null, CpfUtil.adicionaMascara("123"));
	}
}
