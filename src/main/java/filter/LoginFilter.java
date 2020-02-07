package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SessionUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest hsq  = (HttpServletRequest) request;
		HttpServletResponse hsr = (HttpServletResponse)response;
		
		boolean authenticated = SessionUtils.isAuthenticated();
		String url            = hsq.getRequestURI(); 
		
		if (url.indexOf("javax.faces.resource") < 0) {
			System.out.println("Authenticated: "+SessionUtils.isAuthenticated()+" URL: "+hsq.getRequestURI());
			if (authenticated) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				//hsr.sendRedirect("http://localhost:8080/Modelo/");
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
