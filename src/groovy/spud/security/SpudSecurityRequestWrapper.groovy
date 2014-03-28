package spud.security
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper
import javax.servlet.http.HttpServletRequest

class SpudSecurityRequestWrapper extends org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper {
	SpudSecurityRequestWrapper(HttpServletRequest request, String rolePrefix) {
		super(request,rolePrefix)
	}
	
	public String getRequestURI() {
		return getForwardURI();
	}
}