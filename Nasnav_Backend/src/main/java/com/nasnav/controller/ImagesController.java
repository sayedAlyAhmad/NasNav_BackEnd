package com.nasnav.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nasnav.dao.ImagesDao;
import com.nasnav.dto.ImagesDto;
import com.nasnav.serviceimpl.ImagesServiceImpl;
import com.nasnav.util.ImageUtility;
import com.nasnav.util.ImagesResponse;

@RestController
@RequestMapping("${api.prefix.nasnav}" + "/images")
public class ImagesController {
	@Autowired
	ImagesServiceImpl imagesServiceImpl;
	@Autowired
	ImagesDao imagesDao;

	@GetMapping(path = { "/get/image/{name}" })
	public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(imagesServiceImpl.getImageByName(name).getImagedescription()))
				.body(ImageUtility.decompressImage(imagesServiceImpl.getImageByName(name).getImage()));
	}

	@GetMapping(path = { "/image/info/{name}" })
	public ImagesDto getImageDetails(@PathVariable("name") String name) throws IOException {
		return ImagesDto.builder().imagedescription(imagesServiceImpl.getImageByName(name).getImagedescription())
				.image(ImageUtility.decompressImage(imagesServiceImpl.getImageByName(name).getImage())).build();
	}

	@PostMapping("/upload")
	public ResponseEntity<ImagesResponse> uplaodImage(@RequestParam("image") MultipartFile file) throws Exception {

		imagesServiceImpl.save(ImagesDto.builder().imagedescription(file.getOriginalFilename())
				.image(ImageUtility.compressImage(file.getBytes())).build());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ImagesResponse("Image uploaded successfully: " + file.getOriginalFilename()));
	}

	@DeleteMapping("/{id}")
	public void deleteImageById(@PathVariable(value = "id") Long id) {
		imagesServiceImpl.delete(id);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ImagesResponse> updateImage(@RequestParam("image") MultipartFile file, @PathVariable(value = "id") Long id) throws Exception {
		
		imagesServiceImpl.update(ImagesDto.builder().imagedescription(file.getOriginalFilename())
				.image(ImageUtility.compressImage(file.getBytes())).build(),id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ImagesResponse("Image updated successfully: " + file.getOriginalFilename()));
	}

	

}
