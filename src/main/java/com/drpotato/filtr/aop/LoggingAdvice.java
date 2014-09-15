package com.drpotato.filtr.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAdvice implements MethodInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Object[] arguments = methodInvocation.getArguments();

		StringBuilder stringBuilder = new StringBuilder("[");

		for (int i = 0; i < arguments.length - 1; i++) {
			stringBuilder.append(arguments[i].toString());
			stringBuilder.append(", ");
		}
		if (arguments.length > 0) {
			stringBuilder.append(arguments[arguments.length - 1].toString());
		}
		stringBuilder.append("]");

		logger.info(String.format("Executing method '%s' on class '%s'",
				methodInvocation.getMethod().getName().toString(),
				methodInvocation.getThis().getClass().getSimpleName()));
		logger.info(String.format("Arguments: %s", stringBuilder.toString()));
		Object result = methodInvocation.proceed();
		logger.info(String.format("Finished method '%s' on class '%s'",
				methodInvocation.getMethod().getName().toString(),
				methodInvocation.getThis().getClass().getSimpleName()));
		return result;
	}
}
