package com.springboot.associate.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.associate.entity.Associate;
import com.springboot.associate.service.ServiceClass;

@RestController
@RequestMapping("/associate")
public class AssociateController {

	@Autowired
	ServiceClass service;

	@PostMapping("/create")
	public String create(@RequestBody Associate asst) {

		asst.setCreatedDate(new Date());
		service.saveOrUpdate(asst);

		return "created successfully";
	}

	@PutMapping("/update")
	public String update(@RequestBody Associate asst) {

		Associate associateDb = service.findById(asst.getId());

		if (associateDb == null) {
			return "Invalid Request.!";
		}

		associateDb.setCountry(asst.getCountry());
		associateDb.setCurrency(asst.getCurrency());
		associateDb.setName(asst.getName());
		associateDb.setStatus(asst.getStatus());

		associateDb.setUpdatedDate(new Date());
		service.saveOrUpdate(associateDb);
		return "updated successfully";
	}

	@GetMapping("/get")
	public Iterable<Associate> findAll() {
		return service.findAll();
	}

	@GetMapping("/get/{id}")
	public Associate getStudentById(@PathVariable int id) {

		return service.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {

		Associate associateDb = service.findById(id);

		if (associateDb == null) {
			return "Invalid Request.!";
		}
		associateDb.setStatus("DELETED");
		//associateDb.setDeletedDate(new Date());

		service.saveOrUpdate(associateDb);

		return "deleted successfully";
	}

}