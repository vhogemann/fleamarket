package br.com.webb.web.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.webb.model.AbstractDocument;
import br.com.webb.repository.RequestRepository;

@Component("requestConverter")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RequestConverter  extends StrutsTypeConverter{
	
	@Autowired
	RequestRepository repository;

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return repository.findOne(values[0]);
	}

	@Override
	public String convertToString(Map context, Object o) {
		try {
			return ((AbstractDocument)o).getId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
