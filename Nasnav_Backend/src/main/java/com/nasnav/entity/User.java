package com.nasnav.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
import lombok.Data;

@Data   // to generate setter, getter methods and constrcutor
@Entity
@Table(name = "enduser")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "password")
    private String password;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="group_id", referencedColumnName = "ID")
    private Group group_id;
    
	

}
