package com.springboot.associate.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.springboot.associate.entity.Associate;

public interface Repository extends CrudRepository<Associate, Integer> {

}
