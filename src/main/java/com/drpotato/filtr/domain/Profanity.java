package com.drpotato.filtr.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profanity")
public class Profanity implements Serializable {

	private static final long serialVersionUID = -4659364195861965720L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "profanities")
	private Set<WordList> wordLists = new HashSet<WordList>();

	public Profanity() {

	}

	public Profanity(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<WordList> getWordLists() {
		return wordLists;
	}

	public void setWordLists(Set<WordList> wordLists) {
		this.wordLists = wordLists;
	}

	public void addWordList(WordList wordList) {
		getWordLists().add(wordList);
	}

	public void deleteWordList(WordList wordList) {
		getWordLists().remove(wordList);
	}
}
