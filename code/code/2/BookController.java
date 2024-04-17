package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepo bookrepo;
	
	@GetMapping
	public List <Book> getAllBooks(){
		List <Book> book=bookrepo.findAll();
		return book;
	}
	@GetMapping("/{id}")
	public Book getbook(@PathVariable int id) {
		Book getBybook=bookrepo.findById(id).get();
		return getBybook;
	}
	@PostMapping("/add")
	public Book createbook(@RequestBody Book book) {
		return bookrepo.save(book);
	}
	@PutMapping("/update/{id}")
	public Book updatebook(@RequestBody Book updatebook ,@PathVariable int id) {
		updatebook.setId(id);
		return bookrepo.save(updatebook);
	}
	@DeleteMapping("/delete/{id}")
	public String deletebook(@PathVariable int id) {
		bookrepo.deleteById(id);
		return "Deleted";
	}
}
