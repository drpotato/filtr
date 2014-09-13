package com.drpotato.filtr.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "word_list")
public class WordList implements Serializable {

	@Id
	@Column(name = "word_list_id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "profanity_word_list", joinColumns = { @JoinColumn(name = "word_list_id") }, inverseJoinColumns = { @JoinColumn(name = "profanity_id") })
	private Set<Profanity> profanities = new HashSet<Profanity>();

	public WordList() {
	}

	public WordList(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Profanity> getProfanities() {
		return this.profanities;
	}

	public void setProfanities(Set<Profanity> profanities) {

		for (Profanity profanity : profanities) {
			profanity.addWordList(this);
		}

		this.profanities = profanities;
	}

	public void addProfanity(Profanity profanity) {
		profanity.addWordList(this);
		getProfanities().add(profanity);
	}

	public void deleteProfanity(Profanity profanity) {
		profanity.deleteWordList(this);
		getProfanities().remove(profanity);
	}
}
