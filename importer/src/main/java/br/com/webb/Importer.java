package br.com.webb;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webb.model.Product;
import br.com.webb.repository.ProductRepository;

public class Importer {
	
	private String query;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ProductRepository repository;
	
	public void run() throws SQLException{
		ResultSet set = query();
		if(set != null)
			while(set.next()){
				Product product = convert(set);
				repository.save(product);
			}
	}
	
	private ResultSet query() throws SQLException {
		PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
		return statement.executeQuery();
	}

	public Product convert(ResultSet set) throws SQLException{
		
		String name = set.getString("PNAME");
		String description = set.getString("PTECHDESCRIPTION");
		BigDecimal referencePrice = set.getBigDecimal("PRI_IPRICE");
		
		return new Product(name, description, referencePrice);
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
