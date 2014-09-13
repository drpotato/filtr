package com.drpotato.filtr.controller;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.service.ProfanityService;

@Controller
@RequestMapping(value = "/profanity")
public class ProfanityController {

	@Autowired
	private ProfanityService profanityService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Set<Profanity> getAll() {
		return profanityService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Profanity create(@RequestBody Profanity profanity,
			HttpServletResponse response) {
		Profanity newProfanity = profanityService.save(profanity);
		return newProfanity;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Profanity findById(@PathVariable Integer id) {

		return profanityService.findById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Profanity update(@RequestBody Profanity profanity) {
		Profanity newProfanity = profanityService.save(profanity);
		return newProfanity;
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public Profanity remove(@RequestBody Profanity profanity) {
		profanityService.delete(profanity);
		return profanity;
	}
}
