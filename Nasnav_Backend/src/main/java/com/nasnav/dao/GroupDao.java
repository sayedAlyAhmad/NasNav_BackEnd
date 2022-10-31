package com.nasnav.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasnav.entity.Group;


public interface GroupDao extends JpaRepository<Group, Long>{

}
