package com.drpotato.filtr.persistence;

import java.util.Set;
import java.util.TreeSet;

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
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Set<Profanity> findAll() {

		return new TreeSet<Profanity>(sessionFactory.getCurrentSession()
				.createQuery("FROM Profanity p").list());
	}

	@Override
	public Profanity findById(Integer id) {
		return (Profanity) sessionFactory
				.getCurrentSession()
				.createQuery(
						"SELECT DISTINCT p FROM Profanity p WHERE p.id=:id")
				.setParameter("id", id).uniqueResult();
	}

	@Override
	public Profanity save(Profanity profanity) {
		sessionFactory.getCurrentSession().saveOrUpdate(profanity);
		return profanity;
	}

	@Override
	public void delete(Profanity profanity) {
		sessionFactory.getCurrentSession().delete(profanity);
	}

}
