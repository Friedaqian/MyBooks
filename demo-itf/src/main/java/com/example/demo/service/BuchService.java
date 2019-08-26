package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.Reporsitory.BuchReporsitory;
import com.example.demo.entity.Buch;

import lombok.extern.slf4j.Slf4j;

@Slf4j//für Lombok
@Service
@Transactional
public class BuchService {
	
	@Autowired
	private BuchReporsitory buchRepository;
	
//	@Scheduled(fixedDelay  = 1000)//public!methode wie oft aufrufen,EnableScheduling in main
//	public void execute () {
//		Buch buch = new Buch();
//		buch.setPrice(11.11);
//		buch.setTitle("Lombok");
//		buch.setPublished(null);
//		buch = buchRepository.save(buch);
//		log.info("Saved book with id {}", buch.getId());
		
//	}

}
