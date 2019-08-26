package com.example.demo.entity;
//persist time fehler bei Postman bedeutet Speichung fehler
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;
	
	@NotEmpty
	@Column (name = "firstname")
	private String firstname;
	
	@NotEmpty
	@Column (name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Buch> books;

}
