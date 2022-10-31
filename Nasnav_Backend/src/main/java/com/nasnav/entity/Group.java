package com.nasnav.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data   // to generate setter, getter methods and constrcutor
@Entity       
@Table(name = "group_name")
public class Group implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @ToString.Exclude
    @OneToMany(mappedBy="group_id")
    private List<User> group_id;

}
