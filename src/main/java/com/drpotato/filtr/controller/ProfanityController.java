package com.drpotato.filtr.controller;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drpotato.filtr.aop.LoggingAdvice;
import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.service.ProfanityService;

@Controller
@RequestMapping(value = "/profanity")
public class ProfanityController {

	private Logger logger = LoggerFactory.getLogger(ProfanityController.class);

	@Autowired
	private ProfanityService profanityService;

	@PostConstruct
	public void setUp() {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(profanityService);
		pf.addAdvice(new LoggingAdvice());
		profanityService = (ProfanityService) pf.getProxy();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Set<Profanity> getAll() {
		return profanityService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Profanity create(@RequestBody Profanity profanity) {
		Profanity newProfanity = profanityService.save(profanity);
		return newProfanity;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Profanity findById(@PathVariable Integer id) {

		return profanityService.findById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Profanity update(@RequestBody Profanity profanity) {
		Profanity newProfanity = profanityService.save(profanity);
		return newProfanity;
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public Profanity remove(@RequestBody Profanity profanity) {
		profanityService.delete(profanity);
		return profanity;
	}
}
