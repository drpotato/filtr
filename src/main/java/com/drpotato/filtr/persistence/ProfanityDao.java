package com.drpotato.filtr.persistence;

import java.util.List;

import com.drpotato.filtr.domain.Profanity;

public interface ProfanityDao {

	// Find all profanities
	public List<Profanity> findAll();

	// Find a profanity with details by id
	public Profanity findById(Long id);

	// Insert or update a profanity
	public Profanity save(Profanity profanity);

	// Delete a profanity
	public void delete(Profanity profanity);
}
