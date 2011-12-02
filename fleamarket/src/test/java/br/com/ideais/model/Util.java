package br.com.ideais.model;

import java.math.BigDecimal;

import br.com.ideais.model.Product;
import br.com.ideais.model.Quote;
import br.com.ideais.model.Request;
import br.com.ideais.model.Supplier;
import br.com.ideais.model.common.Address;
import br.com.ideais.model.common.AddressType;

public class Util {

	public static Request validRequest(){
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		request.addProduct(new Product("prod1", "desc", new BigDecimal(10.0)), 1);
		request.addProduct(new Product("prod2", "desc", new BigDecimal(5.0)), 2);
		request.addProduct(new Product("prod3", "desc", new BigDecimal(20.0)), 1);
		return request;
	}
	
	public static Quote validQuote(Request request){
		return new Quote(
				new Supplier("Supplier",
						new Address(
								"Rua da Assembleia", "98", null,
								"20011-000", "Brasil", "RJ",
								"Rio de Janeiro", AddressType.COMMERCIAL)), 
							request); 
	}
	

}
