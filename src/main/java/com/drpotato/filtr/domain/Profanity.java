package com.drpotato.filtr.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profanity")
public class Profanity implements Serializable {

	private int id;
	private String name;
	private Set<WordList> wordLists = new HashSet<WordList>();

	public Profanity() {

	}

	public Profanity(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "profanity_id")
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "profanities")
	public Set<WordList> getWordLists() {
		return wordLists;
	}

	public void addWordList(WordList wordList) {
		getWordLists().add(wordList);
	}

	public void deleteWordList(WordList wordList) {
		getWordLists().remove(wordList);
	}
}
