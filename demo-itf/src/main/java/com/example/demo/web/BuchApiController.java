package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Reporsitory.BuchReporsitory;
import com.example.demo.entity.Buch;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BuchApiController {
	
	@Autowired
	private BuchReporsitory buchrepository;

//  GET  /books/-->List<Book>,find all books in db	
	@GetMapping
	public Iterable<Buch> index(){
		return buchrepository.findAll();
	}

//  GET  /books/--><Book>,find a book mti Id in db	
	@GetMapping("/{id}")
	public ResponseEntity<Buch> show(@PathVariable Integer id){
//		Optional<Buch> buch = buchrepository.findById(id);
		return ResponseEntity.of(buchrepository.findById(id));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		if (buchrepository.existsById(id)) {
			buchrepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}
	
	@PostMapping
	public Buch create(@Valid @RequestBody Buch buch) {//Valid immer bei Body bei postman noch bemerkung wo fehler
		buch.setId(0);
		return buchrepository.save(buch);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Buch> update(@PathVariable Integer id, @Valid @RequestBody Buch buch) {
		if (buchrepository.existsById(id)) {
			buch.setId(id);
			return ResponseEntity.ok(buchrepository.save(buch));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}
	
//check controller ob funltioniert
//	@GetMapping("/hello")
//	public String helloWorld() {
//		return "hello world";
//	}
}
