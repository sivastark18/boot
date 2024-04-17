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
	
	@GetMapping("/product")
	public List<Model> getAllProduct()
	{
		List<Model> product=repo.findAll();
		return product;
	}
	
	@PostMapping("/product/add")
	public void createProduct(@RequestBody Model model)
	{
		repo.save(model);
	}
	
	@PutMapping("/product/update/{id}")
	public Model updatemodel(@PathVariable int id,@RequestBody Model model) {
		model.setId(id);
		return repo.save(model);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void deletemodel(@PathVariable int id)
	{
		repo.deleteById(id);
	}
}
