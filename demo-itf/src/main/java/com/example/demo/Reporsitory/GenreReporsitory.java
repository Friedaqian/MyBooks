package com.example.demo.Reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Buch;
import com.example.demo.entity.Genre;

@Repository

public interface GenreReporsitory extends CrudRepository<Genre, Integer> {

	

}
