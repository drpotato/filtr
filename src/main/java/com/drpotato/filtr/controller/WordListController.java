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
import com.drpotato.filtr.domain.WordList;
import com.drpotato.filtr.service.WordListService;

@Controller
@RequestMapping(value = "/word_list")
public class WordListController {

	private Logger logger = LoggerFactory.getLogger(WordListController.class);

	@Autowired
	private WordListService wordListService;

	@PostConstruct
	public void setUp() {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(wordListService);
		pf.addAdvice(new LoggingAdvice());
		wordListService = (WordListService) pf.getProxy();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Set<WordList> getAll() {
		return wordListService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public WordList create(@RequestBody WordList wordList) {
		WordList newWordList = wordListService.save(wordList);
		return newWordList;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public WordList findById(@PathVariable Integer id) {
		return wordListService.findById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public WordList update(@RequestBody WordList wordList) {
		WordList newWordList = wordListService.save(wordList);
		return newWordList;
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public WordList remove(@RequestBody WordList wordList) {
		wordListService.delete(wordList);
		return wordList;
	}

	@ResponseBody
	@RequestMapping(value = "/add_profanity/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public WordList addProfanity(@RequestBody Profanity profanity,
			@PathVariable Integer id) {
		WordList wordList = wordListService.findById(id);
		wordList.addProfanity(profanity);
		wordListService.save(wordList);
		return wordList;
	}

	@ResponseBody
	@RequestMapping(value = "/remove_profanity/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public WordList removeProfanity(@RequestBody Profanity profanity,
			@PathVariable Integer id) {

		WordList wordList = wordListService.findById(id);

		System.out.println(profanity.toString());

		System.out.println(wordList.toString());

		wordList.removeProfanity(profanity);

		System.out.println(wordList.toString());

		wordListService.save(wordList);
		return wordList;
	}
}
