package org.andvicoso.cruduser.controller.interceptor;

import java.util.Map;

import org.andvicoso.cruduser.controller.action.SecureAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		boolean invoke = true;
		String defaultResult = "login";// global result
		Object action = invocation.getAction();

		if (action instanceof SecureAction) {
			Map<String, Object> session = invocation.getInvocationContext()
					.getSession();
			invoke = session.get("userId") != null;
		}

		return invoke ? invocation.invoke() : defaultResult;
	}
}
