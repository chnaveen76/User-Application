package com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;

@Repository
@Transactional
public class RepoClass {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void saving(User user) {
		System.out.println("in repo layer");
		hibernateTemplate.save(user);
	}

	public User gettinguser(String username) {
		User user = hibernateTemplate.get(User.class, username);
		return user;

	}

	public void updating(User user) throws Exception{
		hibernateTemplate.update(user);

	}

	public void deleting(String username) {
		User user = hibernateTemplate.get(User.class, username);
		if(user!=null) {
			hibernateTemplate.delete(user);
		}
	}


}
