package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AnoTest {

	@Test
	public void testOfDate() throws Exception {
		Calendar calendar = new GregorianCalendar(2014, Calendar.NOVEMBER, 9);
		Ano ano = Ano.of(calendar.getTime());
		assertNotNull(ano);
		assertEquals("2014", ano.toString());
	}

	@Test
	public void testOfString() throws Exception {
		Ano ano = Ano.of("2014");
		assertNotNull(ano);
		assertEquals("2014", ano.toString());
	}
}
