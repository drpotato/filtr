package com.drpotato.filtr.service;

import java.util.List;

import com.drpotato.filtr.domain.Profanity;

public interface ProfanityService {

	public List<Profanity> findAll();

	public Profanity findById(Integer id);

	public Profanity save(Profanity profanity);

	public boolean delete(Profanity profanity);

}
