package com.drpotato.filtr.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "word_list")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "_")
public class WordList implements Serializable {

	private static final long serialVersionUID = 8165529717421708886L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profanity_word_list", joinColumns = { @JoinColumn(name = "word_list_id") }, inverseJoinColumns = { @JoinColumn(name = "profanity_id") })
	private Set<Profanity> profanities = new HashSet<Profanity>();

	public WordList() {
	}

	public WordList(String name) {
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

	public Set<Profanity> getProfanities() {
		return profanities;
	}

	public void setProfanities(Set<Profanity> profanities) {

		this.profanities = profanities;
	}

	public void addProfanity(Profanity profanity) {
		profanities.add(profanity);
	}

	public void removeProfanity(Profanity profanity) {

		for (Iterator<Profanity> i = profanities.iterator(); i.hasNext();) {
			Profanity element = i.next();
			if (element.getId() == profanity.getId()) {
				i.remove();
			}
		}

		profanities.remove(profanity);
	}

	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[");

		for (Profanity profanity : profanities) {
			stringBuilder.append(profanity);
			stringBuilder.append(",");
		}

		stringBuilder.append("]");

		return String.format(
				"WordList(id =  %s, name =  %s, profanities = %s)", id, name,
				stringBuilder.toString());
	}
}
