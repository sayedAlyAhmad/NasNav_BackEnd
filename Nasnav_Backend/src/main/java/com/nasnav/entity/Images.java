package com.nasnav.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // to generate setter, getter methods and constrcutor
@Entity
@Builder
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Images implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "imagedescription")
    private String imagedescription;
    @Column(name = "name")
    private String name; 
    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image; 
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cat_id", referencedColumnName = "ID")
    private ImagesCategory images;
   
  
   

}
