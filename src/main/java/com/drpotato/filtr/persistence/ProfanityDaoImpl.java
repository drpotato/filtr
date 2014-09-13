package com.drpotato.filtr.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.drpotato.filtr.domain.Profanity;

@Transactional
@Repository("profanityDao")
public class ProfanityDaoImpl implements ProfanityDao {

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Set<Profanity> findAll() {
		return new HashSet<Profanity>(sessionFactory.getCurrentSession()
				.createQuery("from com.drpotato.filtr.domain.Profanity p")
				.list());
	}

	@Override
	public Profanity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profanity save(Profanity profanity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Profanity profanity) {
		// TODO Auto-generated method stub

	}

}
