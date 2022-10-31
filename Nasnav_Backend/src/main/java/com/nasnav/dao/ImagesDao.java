package com.nasnav.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.nasnav.entity.Images;

public interface ImagesDao extends JpaRepository<Images, Long>{
	Optional<Images> findByName(String name);

}
