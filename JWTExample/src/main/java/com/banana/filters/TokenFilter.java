package com.banana.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banana.rest.JSONService;

/**
 * Servlet Filter implementation class TokenFilter
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = { "/rest/usuariosf/*" })
public class TokenFilter extends JSONService implements Filter {
	private static Logger logger = Logger.getLogger("TokenFilter");
    
	public TokenFilter() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("Filtering....");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String userEmail = null; 
				
		String token=httpRequest.getHeader("token");
		logger.info("Filtering token:"+token);
		if(token!=null) {
			userEmail = this.getUserEmailFromToken(token);
			logger.info("Filtering email:"+userEmail);
	        request.setAttribute("email", userEmail);
		}
		
		if(userEmail!=null) {
			chain.doFilter(request, response);	
		}else {
			httpResponse.setStatus(403);
			return;
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}


	public void destroy() {
	}

}
