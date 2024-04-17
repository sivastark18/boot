package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Model;
import com.example.demo.repo.Repo1;


@RestController
public class Controller {
	@Autowired
	Repo1 repo;
	
	@GetMapping("/employee")
	public List<Model> getAllEmployee(){
		List<Model> employee = repo.findAll();
		return employee;
	}
	
	@GetMapping("/employee/{id}")
	public Model getModel(@PathVariable int id) {
		 Model model= repo.findById(id).get();
		return model;
	}
	
	@PostMapping("/employees/add")
	public void createEmployee(@RequestBody Model model) {
		repo.save(model);
	}
	
	@PutMapping("/employee/update/{id}")
	public Model updateModel(@PathVariable int id,@RequestBody Model model){
		Model existmodel;
		try {
			existmodel = repo.findById(id).get();
		}
		catch(Exception e) {
			existmodel=null;
		}
		if(existmodel!=null) {
			existmodel.setName(model.getName());
			existmodel.setEmail(model.getEmail());
			existmodel.setDepartment(model.getDepartment());
			existmodel.setSalary(model.getSalary());
			repo.save(existmodel);
		}
		return existmodel;
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public void deleteEmployee(@PathVariable int id){
		repo.deleteById(id);
	}

	
	
}
