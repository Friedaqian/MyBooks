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

import com.example.demo.Reporsitory.AutorReporsitory;
import com.example.demo.entity.Autor;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/autors")
public class AutorApiController {
	//Um Autor bei Postman post, muss man auch zuerst ein Controller bei Autor erstellen
	//ODER EntityIdResolver
	@Autowired
	private AutorReporsitory autorrepository;
	
	@GetMapping
	public Iterable<Autor> index(){
		return autorrepository.findAll();
	}

//  GET  /books/--><Book>,find a book mti Id in db	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> show(@PathVariable Integer id){
		return ResponseEntity.of(autorrepository.findById(id));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		if (autorrepository.existsById(id)) {
			autorrepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}
	
	@PostMapping
	public Autor create(@Valid @RequestBody Autor autor) {
		autor.setId(0);
		return autorrepository.save(autor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Autor> update(@PathVariable Integer id,@Valid @RequestBody Autor autor) {
		if (autorrepository.existsById(id)) {
			autor.setId(id);
			return ResponseEntity.ok(autorrepository.save(autor));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}

}

