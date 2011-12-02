package br.com.ideais.web.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.ideais.model.common.AddressType;

@Component("addressTypeConverter")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AddressTypeConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return AddressType.valueOf(values[0]);
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((AddressType) o).name();
	}

}
