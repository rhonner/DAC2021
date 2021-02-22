package br.com.ufpr.dac.bean;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;






public class BackingBean implements Serializable {
	
	private static final long serialVersionUID = -7673568902938882861L;

	public <T extends Object> T getOrCreateManagedBean(Class<T> beanClass, String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext().getSessionMap();
		Object bean = session.get(beanName);
		if (bean == null) {
			bean = context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", beanClass);
		}
		return (T) bean;
	}
	
    protected void setJsfMessage(String clientId, Severity severity, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(clientId, new FacesMessage(severity, message, message));
    }
	
	public String getCookieValue(String key) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		  for (Cookie cookie: cookies)
		    if (cookie.getName().equals(key))
		      return cookie.getValue();
		return null;
	}
}