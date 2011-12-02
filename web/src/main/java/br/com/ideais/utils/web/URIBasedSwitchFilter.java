package br.com.ideais.utils.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class URIBasedSwitchFilter implements Filter {
	private List<Pattern> exclusions;
	private Map<Pattern, Filter> filterMap;
	private Filter defaultFilter;

	public void init(FilterConfig filterConfig) throws ServletException {
		if (filterMap != null) {
			for (Entry<Pattern, Filter> entry : filterMap.entrySet()) {
				entry.getValue().init(
						new FilterConfigImplementation(filterConfig));
			}
		}
		if (defaultFilter != null) {
			defaultFilter.init(new FilterConfigImplementation(filterConfig));
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String uri = ((HttpServletRequest) request).getRequestURI();
		if (exclusions != null) {
			for (Pattern exclusion : exclusions) {
				if (exclusion.matcher(uri).matches()) {
					chain.doFilter(request, response);
					return;
				}
			}
		}
		if (filterMap != null) {
			for (Entry<Pattern, Filter> entry : filterMap.entrySet()) {
				if (entry.getKey().matcher(uri).matches()) {
					entry.getValue().doFilter(request, response, chain);
					return;
				}
			}
		}
		if (defaultFilter != null) {
			defaultFilter.doFilter(request, response, chain);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void setFilterMap(Map<Pattern, Filter> filterMap) {
		this.filterMap = filterMap;
	}

	public void setDefaultFilter(Filter defaultFilter) {
		this.defaultFilter = defaultFilter;
	}

	public void setExclusions(List<Pattern> exclusions) {
		this.exclusions = exclusions;
	}

	private static final class FilterConfigImplementation implements
			FilterConfig {
		private FilterConfig filterConfig;

		public FilterConfigImplementation(FilterConfig filterConfig) {
			this.filterConfig = filterConfig;
		}

		public String getFilterName() {
			return filterConfig.getFilterName();
		}

		public String getInitParameter(String name) {
			return filterConfig.getInitParameter(name);
		}

		public Enumeration<?> getInitParameterNames() {
			return filterConfig.getInitParameterNames();
		}

		public ServletContext getServletContext() {
			return filterConfig.getServletContext();
		}
	}

}