package com.drpotato.filtr.persistence;

import java.util.List;

import com.drpotato.filtr.domain.WordList;

public interface WordListDao {

	// Find all word lists
	public List<WordList> findAll();

	// Find a word list with details by id
	public WordList findById(Long id);

	// Insert or update a word list
	public WordList save(WordList wordList);

	// Delete a word list
	public void delete(WordList wordList);
}
