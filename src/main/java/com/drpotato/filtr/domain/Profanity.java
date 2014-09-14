package com.drpotato.filtr.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "profanity")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "_")
public class Profanity implements Serializable {

	private static final long serialVersionUID = -4659364195861965720L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "profanities", cascade = { CascadeType.REMOVE })
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
		return new HashSet<WordList>();
	}

	public void setWordLists(Set<WordList> wordLists) {
		this.wordLists = wordLists;
	}

	public void addWordList(WordList wordList) {
		wordLists.add(wordList);
	}

	public void removeWordList(WordList wordList) {
		for (Iterator<WordList> i = wordLists.iterator(); i.hasNext();) {
			WordList element = i.next();
			if (element.getId() == wordList.getId()) {
				i.remove();
			}
		}
	}

	public String toString() {
		return String.format("Profanity(id =  %s, name =  %s)", id, name);
	}

}
