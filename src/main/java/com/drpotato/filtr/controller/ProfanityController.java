package com.drpotato.filtr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.service.ProfanityService;

@Controller
@RequestMapping(value = "/profanity")
public class ProfanityController {

	@Autowired
	private ProfanityService profanityService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Profanity create(Profanity profanity) {
		Profanity newProfanity = profanityService.save(profanity);
		return newProfanity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Profanity findById(@PathVariable Integer id) {

		return profanityService.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Profanity create(Profanity profanity, @PathVariable Integer id) {
		Profanity newProfanity = profanityService.save(profanity);
		return newProfanity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void create(@PathVariable Integer id) {
		Profanity profanity = profanityService.findById(id);
		profanityService.delete(profanity);
	}
}
