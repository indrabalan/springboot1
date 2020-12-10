package com.springboot.associate.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.associate.entity.Associate;
import com.springboot.associate.repository.Repository;

@Service
@Transactional
public class ServiceClass {

	@Autowired
	Repository repo;

	public void saveOrUpdate(Associate asst) {
		repo.save(asst);
	}

	public Iterable<Associate> findAll() {
		return repo.findAll();

	}

	public Associate findById(int id) {
		return repo.findById(id).get();
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

}
