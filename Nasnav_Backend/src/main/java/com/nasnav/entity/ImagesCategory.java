package com.nasnav.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

import lombok.Data;

@Data   // to generate setter, getter methods and constrcutor
@Entity
@Table(name = "imagescategory")
public class ImagesCategory implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy="images")
    private List<Images>images;

}
