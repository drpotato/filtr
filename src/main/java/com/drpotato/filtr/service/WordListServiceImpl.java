package com.drpotato.filtr.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.domain.WordList;
import com.drpotato.filtr.persistence.WordListDao;

@Service("wordListService")
public class WordListServiceImpl implements WordListService {

	@Autowired
	private WordListDao wordListDao;

	@Override
	public Set<WordList> findAll() {
		return wordListDao.findAll();
	}

	@Override
	public WordList findById(Integer id) {
		return wordListDao.findById(id);
	}

	@Override
	public WordList save(WordList wordList) {
		return wordListDao.save(wordList);
	}

	@Override
	public boolean delete(WordList wordList) {
		wordListDao.delete(wordList);
		return true; // TODO: Get this to return something meaningful.
	}

}
