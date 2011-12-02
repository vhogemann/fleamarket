package br.com.ideais.model;

import junit.framework.Assert;

import org.junit.Test;

import br.com.ideais.model.Quote;
import static br.com.ideais.model.Util.*;

public class QuoteTest {

	@Test
	public void constructorTest(){
		
		Quote quote = validQuote(validRequest());
		Assert.assertTrue(quote.isValid());
		quote = new Quote();
		Assert.assertFalse(quote.isValid());
		
	}
	
	
}
