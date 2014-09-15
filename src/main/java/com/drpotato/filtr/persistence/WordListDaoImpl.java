package com.drpotato.filtr.persistence;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.drpotato.filtr.domain.WordList;

@Transactional
@Repository("wordListDao")
public class WordListDaoImpl implements WordListDao {

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Set<WordList> findAll() {
		// TODO Auto-generated method stub
		return new TreeSet<WordList>(sessionFactory.getCurrentSession()
				.createQuery("FROM WordList w").list());
	}

	@Override
	public WordList findById(Integer id) {
		// TODO Auto-generated method stub
		return (WordList) sessionFactory
				.getCurrentSession()
				.createQuery("SELECT DISTINCT w FROM WordList w WHERE w.id=:id")
				.setParameter("id", id).uniqueResult();
	}

	@Override
	public WordList save(WordList wordList) {
		sessionFactory.getCurrentSession().saveOrUpdate(wordList);
		return wordList;
	}

	@Override
	public void delete(WordList wordList) {
		sessionFactory.getCurrentSession().delete(wordList);
	}
}
