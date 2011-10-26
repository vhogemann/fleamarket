package com.ideais.utils.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckboxListInterceptor implements Interceptor {

    /** Auto-generated serialization id */
    private static final long serialVersionUID = -586878104807229585L;

    private String uncheckedValue = "-1";

    private boolean isEmptyUnchecked = false;
    
    public void destroy() {
    }

    public void init() {
    }

    @SuppressWarnings("unchecked")
	public String intercept(ActionInvocation ai) throws Exception {
        Map parameters = ai.getInvocationContext().getParameters();
        Map<String, String> newParams = new HashMap<String, String>();
        Set<String> keys = parameters.keySet();
        for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
            String key = iterator.next();

            if (key.startsWith("__checkboxlist_")) {
                String name = key.substring("__checkboxlist_".length());

                iterator.remove();

                // is this checkbox checked/submitted?
                if (!parameters.containsKey(name)) {
                    // if not, let's be sure to default the value to false
                	if(isEmptyUnchecked) {
                		newParams.put(name, "");
                	}
                	else {
                		newParams.put(name, uncheckedValue);
                	}
                }
            }
        }

        parameters.putAll(newParams);

        return ai.invoke();
    }

    /**
     * Overrides the default value for an unchecked checkbox
     *
     * @param uncheckedValue The uncheckedValue to set
     */
    public void setUncheckedValue(String uncheckedValue) {
        this.uncheckedValue = uncheckedValue;
    }
    
    public void setEmptyUnchecked(boolean emptyUnchecked) {    	
    	this.isEmptyUnchecked = emptyUnchecked;
    }
}
