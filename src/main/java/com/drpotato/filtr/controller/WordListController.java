package com.drpotato.filtr.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.domain.WordList;
import com.drpotato.filtr.service.WordListService;

@Controller
@RequestMapping(value = "/word_list")
public class WordListController {

	@Autowired
	private WordListService wordListService;

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
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
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
	@RequestMapping(value = "/add_profanity/{id}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public WordList addWordList(@RequestBody Profanity profanity,
			@PathVariable Integer id) {
		WordList wordList = wordListService.findById(id);
		wordList.addProfanity(profanity);
		wordListService.save(wordList);
		return wordList;
	}
}
