package com.example.demo;

//import static org.junit.Assert.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Reporsitory.BuchReporsitory;
import com.example.demo.entity.Buch;
import com.example.demo.service.BuchService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class DemoItfApplicationTests {
	@Autowired
	public BuchReporsitory repo;
	
	@Autowired
	private BuchService buchService;


	
//	@Test
//	public void contextLoads() {
//
//		assertEquals(6, repo.count());
//	}
//
//	@Test//findById()
//	public void testSave() {
//
//		Buch b = new Buch();
//
//		b.setTitle("haha");
//		b.setPublished(null);
//		b.setPrice(11.4);
//
//		repo.save(b);
//
//		assertEquals(7, repo.count());
//
//	}
//	
	@Test//findById()
	public void testReadAutorAndGenre() {

		Optional<Buch> buchOptional = repo.findById(1);
		if (buchOptional.isPresent()) {
			log.debug(buchOptional.get().getAutor().getLastname());
			log.debug(buchOptional.get().getGenre().getGenrename());
		}
		
	
	}
	
//	@Test
//	public void testFindMostExpensiveBook() {
//		log.debug("Most expensive price ist {}", repo.findFirst().getPrice());
//		}
//	
	@Test
	public void testFindByAutorLastName() {

			log.debug("Number of King's books is {}", repo.findByAutorLastname("King").size());
		}
	
	@Test
	public void testFindByGenreName() {

			log.debug("Number of Horror is {}", repo.findByGenreGenrename("Horror").size());
		}

}
