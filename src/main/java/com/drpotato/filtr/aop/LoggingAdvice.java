package com.drpotato.filtr.aop;

import java.util.ArrayList;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAdvice implements MethodInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Object[] arguments = methodInvocation.getArguments();

		StringBuilder stringBuilder = new StringBuilder();

		for (Object argument : arguments) {
			stringBuilder.append(argument.toString());
		}

		logger.info(String.format("Executing: %s on Class: %s",
				methodInvocation.getMethod().getName().toString(),
				methodInvocation.getThis().getClass().getSimpleName()));
		logger.info(String.format("Arguments: %s", stringBuilder.toString()));
		Object result = methodInvocation.proceed();
		logger.info(String.format("Finished: %s on Class: %s", methodInvocation
				.getMethod().getName().toString(), methodInvocation.getThis()
				.getClass().getSimpleName()));
		return result;
	}
}
