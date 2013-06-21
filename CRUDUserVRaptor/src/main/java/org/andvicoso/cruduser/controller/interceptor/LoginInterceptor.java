package org.andvicoso.cruduser.controller.interceptor;

import org.andvicoso.cruduser.controller.login.LoginController;
import org.andvicoso.cruduser.model.LoginInfo;
import org.andvicoso.cruduser.model.Public;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class LoginInterceptor implements Interceptor {

	private Result result;
	private LoginInfo loginInfo;

	public LoginInterceptor(Result result, LoginInfo loginInfo) {
		this.result = result;
		this.loginInfo = loginInfo;
	}

	public boolean accepts(ResourceMethod method) {
		return !(method.getMethod().isAnnotationPresent(Public.class) || method
				.getResource().getType().isAnnotationPresent(Public.class));
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) {
		if (loginInfo.isLogged()) {
			stack.next(method, resourceInstance);
		} else {
			result.redirectTo(LoginController.class).login();
		}
	}

}