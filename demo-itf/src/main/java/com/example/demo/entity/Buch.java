package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity

@Table(name = "book")
public class Buch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;
	
	@NotEmpty
	@Column (name = "title")
	private String title;
	
	@DecimalMin("0")
	@Column (name = "price")
	private double price;
	
	@Column (name = "published")
	private Date published; 
	
	@Column (name = "img_url")
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
//	@JsonManagedReference
	private Autor autor;//Beziehung mappedby..
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
//	@JsonManagedReference,um post zu funktionieren, muss es m´nicht geben!
	private Genre genre;
}


