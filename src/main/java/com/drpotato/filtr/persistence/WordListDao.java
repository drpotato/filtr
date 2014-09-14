package com.drpotato.filtr.persistence;

import java.util.Set;

import com.drpotato.filtr.domain.WordList;

public interface WordListDao {

	// Find all word lists
	public Set<WordList> findAll();

	// Find a word list with details by id
	public WordList findById(Integer id);

	// Insert or update a word list
	public WordList save(WordList wordList);

	// Delete a word list
	public void delete(WordList wordList);
}
