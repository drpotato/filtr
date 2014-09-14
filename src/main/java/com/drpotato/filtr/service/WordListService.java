package com.drpotato.filtr.service;

import java.util.Set;

import com.drpotato.filtr.domain.WordList;

public interface WordListService {

	public Set<WordList> findAll();

	public WordList findById(Integer id);

	public WordList save(WordList wordList);

	public boolean delete(WordList wordList);

}
