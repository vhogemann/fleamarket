package br.com.webb.model;

import junit.framework.Assert;

import org.junit.Test;
import static br.com.webb.model.Util.*;

public class QuoteTest {

	@Test
	public void constructorTest(){
		
		Quote quote = validQuote(validRequest());
		Assert.assertTrue(quote.isValid());
		quote = new Quote();
		Assert.assertFalse(quote.isValid());
		
	}
	
	
}
