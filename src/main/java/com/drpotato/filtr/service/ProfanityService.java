package com.drpotato.filtr.service;

import java.util.Set;

import com.drpotato.filtr.domain.Profanity;

public interface ProfanityService {

	public Set<Profanity> findAll();

	public Profanity findById(Integer id);

	public Profanity save(Profanity profanity);

	public boolean delete(Profanity profanity);

}
