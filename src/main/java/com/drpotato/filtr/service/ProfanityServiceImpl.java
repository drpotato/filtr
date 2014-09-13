package com.drpotato.filtr.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drpotato.filtr.domain.Profanity;
import com.drpotato.filtr.persistence.ProfanityDao;

@Service("profanityService")
public class ProfanityServiceImpl implements ProfanityService {

	private Map<Integer, Profanity> indexedProfanities;
	private int index;

	@Autowired
	private ProfanityDao profanityDao;

	public ProfanityServiceImpl() {
		Profanity[] profanities = new Profanity[] { new Profanity("fuck"),
				new Profanity("shit"), new Profanity("balls") };

		indexedProfanities = new HashMap<Integer, Profanity>();
		for (index = 0; index < profanities.length; index++) {
			Integer id = new Integer(index + 1);
			profanities[index].setId(id);
			indexedProfanities.put(id, profanities[index]);
		}

	}

	@Override
	public Set<Profanity> findAll() {
		return profanityDao.findAll();
	}

	@Override
	public Profanity findById(Integer id) {
		return indexedProfanities.get(id);
	}

	@Override
	public Profanity save(Profanity profanity) {
		// TODO Auto-generated method stub
		this.index++;
		indexedProfanities.put(index, profanity);
		profanity.setId(indexedProfanities.size());
		return profanity;
	}

	@Override
	public boolean delete(Profanity profanity) {
		indexedProfanities.remove(profanity.getId());
		return true;
	}
}
