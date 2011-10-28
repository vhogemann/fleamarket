package br.com.webb.web.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.webb.model.AbstractDocument;
import br.com.webb.model.Product;
import br.com.webb.repository.ProductRepository;

@Component("productConverter")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductConverter extends StrutsTypeConverter {
	
	@Autowired
	private ProductRepository productRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public Product convertFromString(Map context, String[] values, Class toClass) {
		return productRepository.findOne(values[0]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map context, Object o) {

		try {
			return ((AbstractDocument)o).getId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

}
