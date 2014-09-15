package com.drpotato.filtr.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drpotato.filtr.controller.ProfanityController;

public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(ProfanityController.class);

	private void before(JoinPoint jp) {
		System.out.println("Test log, please ignore.");
		logger.info(jp.toString());

	}
}
