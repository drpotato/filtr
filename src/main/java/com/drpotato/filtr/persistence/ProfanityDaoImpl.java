package com.drpotato.filtr.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.drpotato.filtr.domain.Profanity;

@Repository("profanityDao")
public class ProfanityDaoImpl implements ProfanityDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Profanity> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Profanity p").list();
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
