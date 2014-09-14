package com.drpotato.filtr.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.persistence.ProfanityDao;

@Service("profanityService")
public class ProfanityServiceImpl implements ProfanityService {

	@Autowired
	private ProfanityDao profanityDao;

	@Override
	public Set<Profanity> findAll() {
		return profanityDao.findAll();
	}

	@Override
	public Profanity findById(Integer id) {
		return profanityDao.findById(id);
	}

	@Override
	public Profanity save(Profanity profanity) {
		profanityDao.save(profanity);
		return profanity;
	}

	@Override
	public boolean delete(Profanity profanity) {
		profanityDao.delete(profanity);
		return true; // TODO: Get this to return something meaningful.
	}
}
