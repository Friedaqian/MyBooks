package com.example.demo.Reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Buch;

@Repository

public interface AutorReporsitory extends CrudRepository<Autor, Integer> {

	public Autor findByLastname(String lastname);

}
