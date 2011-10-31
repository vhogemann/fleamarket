package br.com.webb.web.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.webb.model.AbstractEntity;
import br.com.webb.model.Supplier;
import br.com.webb.repository.SupplierRepository;

@Component("supplierConverter")
public class SupplierConverter extends StrutsTypeConverter {
	
	@Autowired
	private SupplierRepository repository;
	
	@SuppressWarnings("unchecked")
	@Override
	public Supplier convertFromString(Map context, String[] values, Class toClass) {
		return repository.findOne(values[0]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map context, Object o) {

		try {
			return ((AbstractEntity)o).getId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
