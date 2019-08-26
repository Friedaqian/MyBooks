package com.example.demo.Reporsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Buch;

@Repository

public interface BuchReporsitory extends CrudRepository<Buch, Integer> {
	
	
	public List<Buch> findByAutorLastname(String lastname);
	public List<Buch> findByGenreGenrename(String genrename);

}
