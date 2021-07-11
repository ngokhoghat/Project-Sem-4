package com.bkap.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bkap.entities.Image;
import com.bkap.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	FilesStorageServiceImpl storageImplService;

	public void removeImage(Long id) throws IOException {
		String imageName = imageRepository.getById(id).getLinkImage().split("http://localhost:8888/files/")[1];
		storageImplService.deleteImageById(imageName);
		imageRepository.deleteById(id);
	}

	public Image save(Image image) {
		return imageRepository.save(image);
	}
}
